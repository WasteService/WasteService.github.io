package ap;

import java.util.List;

import util.MatrixUtils;
import dep.ExtendGcd;



public class Order0 {
	
	/**
	 * 
	 * @param sts ѭ���е����
	 * @param list ѭ�������е�������
	 * @param n ѭ���Ĳ��
	 * @return
	 */
	public int[][] gen(List<Statement> sts,List<DependentPair> list,int n){
		int s=sts.size();
		if(list.isEmpty()){
			return MatrixUtils.eye(n*s+s);// ���ѭ��������������ʲô��λ������
		}
		assert n==list.get(0).F1.length;//ѭ���Ĳ�������ʵ��ѭ�������ĸ�����������ڷ��Ų����أ���
		int[][] result=null;
		for(int i=0;i<list.size();i++){
			DependentPair dp=list.get(i);
			int[][] solution=dp.independentSolution();
			assert solution[0].length==2*n+1;
			int[][] solutionExpand=expandSolution(sts, s, n, dp, solution);
			if(i==0){
				result=solutionExpand;
			}else{
				result=merge(result,solutionExpand);
			}
		}
		return result;
	}

	/**
	 * �ϲ������null space�����㷨��ԭ����
	 * TODO: ����㷨�����⣬ԭ��������0�Ĵ����д���
	 * ����null space�漰���ı�����0����˼�Ǹñ�����ֵ����Ϊ0;������δ�漰���ı�����0�����������ȡֵ��
	 * @param oldSolution
	 * @param newSolution
	 * @return
	 */
	public int[][] merge(int[][] oldSolution, int[][] newSolution) {
		int[][] m=MatrixUtils.rowMerge(oldSolution, newSolution);
		int[][] nul=new ExtendGcd().nullSpace(m);
		int[][] left=MatrixUtils.splitColumn(nul, oldSolution.length).m1;
		return MatrixUtils.multi(left, oldSolution);
	}

	/**
	 * ������dp�Ľ��Ӧ��[C1,C2,d1-d2]����һ��(k,2*n+1)ά������������k�ǽ�ռ����,n��ѭ���Ĳ�����
	 * ����Ҫ�Ѹý���չΪһ��(k+1,s*n+s)ά������������sѭ��������������
	 * ���ӵ�һά��һ��trival�Ľ⡣��չ�Ժ����d1-d2�зָ�Ϊd1�к�d2��,��Ӧ�Ľ�Ҳ��Ҫ����һά��
	 * @param sts ѭ���������б�
	 * @param s ѭ������������
	 * @param n ѭ���Ĳ���
	 * @param dp ������
	 * @param solution ������ԭ���Ľ�
	 * @return ��չ��Ľ�ռ�����
	 */
	int[][] expandSolution(List<Statement> sts, int s, int n,DependentPair dp, int[][] solution) {
		int c1=sts.indexOf(dp.s1);
		int c2=sts.indexOf(dp.s2);
		int[][] solutionExpand=new int[solution.length+1][s*n+s];
		//solutionExpand�����ǽ�ռ���ȣ�����s*n+s��ʾ[c1,c2,...,cs,d1,d2,...ds],����c1��nά��������d1�Ǳ���
		for(int i=0;i<solution.length;i++){
			for(int j=c1*n;j<c1*n+n;j++){
				solutionExpand[i][j]=solution[i][j-c1*n];
			}
		}
		for(int i=0;i<solution.length;i++){
			for(int j=c2*n;j<c2*n+n;j++){
				solutionExpand[i][j]=solution[i][j-c2*n];
			}
		}
		for(int i=0;i<solution.length;i++){
			if(solution[i][solution[0].length-1]!=0){
				solutionExpand[i][s*n+c1]=solution[i][solution[0].length-1];
			}
		}
		solutionExpand[solution.length][s*n+c1]=1;
		solutionExpand[solution.length][s*n+c2]=1;
		return solutionExpand;
	}
	
	/**
	 * ����C<sub>1</sub>i<sub>1</sub>+d1=C<sub>2</sub>i<sub>2</sub>+d2��һ��trival�Ľ⡣
	 * �������û������ġ���Ϊ�����������㶼�ŵ�ͬһ����������Ҳ����û�в��л���
	 * @param k [C<sub>1</sub>,C<sub>2</sub>,d1,d2]��ά��
	 * @return
	 */
	private int[][] trivalSolution(int k){
		int[][] ret=new int[1][k];
		ret[0][k-2]=1;
		ret[0][k-1]=1;
		return ret;
	}



}

class MappingMatrix{
	Statement s;
	int[] c;//n*1ά��������n����������ѭ����Ƕ�ײ���
	int d;
}

class Statement{
	
}