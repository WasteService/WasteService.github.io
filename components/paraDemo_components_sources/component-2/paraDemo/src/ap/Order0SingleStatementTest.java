package ap;

import util.MatrixUtilsTest;

public class Order0SingleStatementTest extends Order0Test {
	
	public void test(){
		Statement s3=new Statement();
		DependentPair dp3=null;
		dp3=new DependentPair();
		dp3.F1=new int[][]{{1}};
		dp3.f1=new int[]{0};
		dp3.s1=s3;
		dp3.F2=new int[][]{{1}};
		dp3.f2=new int[]{-2};
		dp3.s2=s3;
		sts.add(s3);
		dps.add(dp3);
		
		int[][] ret=new Order0().gen(sts, dps,2);
		int[][] result=new int[][]{
				{0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		//TODO: ������S1��S2���Բ��л������S3�޷����л����ѵ����仮���㷨���޷����л����������㷨ʵ�ֵ����⣿
		MatrixUtilsTest.equalMatrix(result, ret);
	}
}
