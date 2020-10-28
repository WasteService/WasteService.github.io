package ap;

import java.util.List;

import dep.ExtendGcd;

import util.MatrixPair;
import util.MatrixUtils;

@Deprecated
public class NewOrder0 {

	/**
	 * �����Ⱥϲ��ɴ��������null space vector�ķ�����
	 * �������������ȷ����ΪmergeEquation�����ںϲ����̵�ʱ������ͬʱ�����������̵Ľ⣬Ҳ����and�ĺ��塣����ʵ��Ҫ�����ʵ��or�ĺ��塣
	 * ����[i1,i2]*[F1;F2]=f2-f1��[i1,i2]*[F3;F4]=f4-f3���ϲ��Ժ�ľ���[F1;F2,F3;F4]����˼��ԭ�����������̱���ͬʱ���㡣
	 * @param sts
	 * @param list
	 * @return
	 */
	public int[][] gen(List<Statement> sts,List<DependentPair> list){
		int s=sts.size();
		//if(list.isEmpty()) return ? // ���ѭ��������������ʲô����λ������
		int n=list.get(0).F1[0].length;//ѭ���Ĳ�������ʵ��ѭ�������ĸ�����������ڷ��Ų����أ���
		Equation equ=mergeEquation(sts, list);
		MatrixPair mp=equ.solve();
		int[][] U=mergeU(sts, list, s, n, mp);
		return new ExtendGcd().nullSpace(U);
	}



	private int[][] mergeU(List<Statement> sts, List<DependentPair> list,int s, int n, MatrixPair mp) {
		int[][] U=null;
		for(int i=0;i<list.size();i++){
			DependentPair dp=list.get(i);
			if(i==0){
				U=expandU(mp,dp,sts,n,s);
			}else{
				int[][] u=expandU(mp,dp,sts,n,s);
				U=MatrixUtils.columnMerge(U, u);
			}
		}
		return U;
	}



	private int[][] expandU(MatrixPair mp,DependentPair dp, List<Statement> sts, int n, int s) {
		int c1=sts.indexOf(dp.s1);
		int c2=sts.indexOf(dp.s2);
		int[][] F_E=MatrixUtils.transpose(MatrixUtils.rowMerge(mp.m1, mp.m2));
		for(int i=c2*n;i<c2*n+n;i++){
			for(int j=0;j<F_E[0].length;j++){
				F_E[i][j]=-F_E[i][j];
			}
		}
		int[][] m=new int[n][F_E[0].length];
		m[c1][m[0].length-1]=1;
		m[c2][m[0].length-1]=-1;
		return MatrixUtils.rowMerge(F_E, m);
	}

	Equation mergeEquation(List<Statement> sts, List<DependentPair> list) {
		int s=sts.size();
		int n=list.get(0).F1[0].length;
		int[][] F=null;
		int[] E=null;
		for(int i=0;i<list.size();i++){
			DependentPair dp=list.get(i);
			if(i==0){
				F=expandF(dp,sts,n,s);
				E=expandE(dp);
			}else{
				int[][] expandF=expandF(dp,sts,n,s);//[F1,-F2]
				int[] expandE=expandE(dp);//(f2-f1)
				F=MatrixUtils.columnMerge(F, expandF);
				E=merge(E, expandE);
			}
		}
		return new Equation(F,E);
	}
	
	private int[] merge(int[] a,int[] b){
		int[] ret=new int[a.length+b.length];
		System.arraycopy(a, 0, ret, 0, a.length);
		System.arraycopy(b, 0, ret, a.length, b.length);
		return ret;
	}
	
	int[] expandE(DependentPair dp) {
		int[] ret=new int[dp.f1.length];
		for(int i=0;i<ret.length;i++) ret[i]=dp.f2[i]-dp.f1[i];
		return ret;
	}

	int[][] expandF(DependentPair dp, List<Statement> sts, int n, int s){
		int m=dp.F1.length;//�����ά��
		int[][] ret=new int[m][n*s];//[F1,-F2]
		int c1=sts.indexOf(dp.s1);
		int c2=sts.indexOf(dp.s2);
		for(int i=0;i<dp.F1.length;i++){
			for(int j=c1*n;j<c1*n+dp.F1[0].length;j++){
				ret[i][j]=dp.F1[i][j-c1*n];
			}
		}
		for(int i=0;i<dp.F2.length;i++){
			for(int j=c2*n;j<c2*n+dp.F2[0].length;j++){
				ret[i][j]=-dp.F2[i][j-c2*n];
			}
		}
		return MatrixUtils.transpose(ret);//[F1';-F2']
	}
	
}
