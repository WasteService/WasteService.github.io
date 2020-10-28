package ap;

import util.MatrixPair;
import util.MatrixUtils;
import dep.ExtendGcd;

public class DependentPair{
	public int[][] F1; //m*nά��������m�������ά����n����������ѭ����Ƕ�ײ���
	public int[] f1;   //m*1ά����
	public Statement s1;
	public int[][] F2;
	public int[] f2;
	public Statement s2;
	
	
	int[][] independentSolution(){
		assert F1.length==f1.length;
		if(s1.equals(s2)) return new int[1][2*F1[0].length+1];
		//���ͬһ�����������������ʴ���������������޷����л�������2n+1ά��������
		int[][] A=MatrixUtils.rowMerge(F1, F2);
		//����������[F1;-F2],Ҳ�������и����Ĺ�ʽ����ô�����õ���[C1,-C2,(c1-c2)]�Ľ�������
		//���õ���[F1;F2]���Ƿ������õľ���[C1,C2,(c1-c2)]�Ľ�������Ҳ����������Ҫ�Ľ����
		int[] c =MatrixUtils.subtract(f2, f1);
		ExtendGcd gcd=new ExtendGcd();
		MatrixPair mp=gcd.solve(A, c);
		int[][] F_E=MatrixUtils.transpose(MatrixUtils.rowMerge(mp.m1, mp.m2));
		int[][] low=new int[1][F_E[0].length];
		low[0][low[0].length-1]=1;
		int[][] U=MatrixUtils.rowMerge(F_E,low);
		//���P837ҳ����2(b)���ᵽ�ľ���U����������΢�в��,[C1,C2,(c1-c2)]U=0
		return gcd.nullSpace(U);
	}
	
}