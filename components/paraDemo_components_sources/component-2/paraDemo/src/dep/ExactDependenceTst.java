package dep;

/*
 * ��ȷ�������ԵĹ�ͬ�ӿڣ��������������ԡ��޻����Ժ�ѭ���������ԡ�
 * Ϊ�˲���Junit������ϰ�߳�ͻ������û��ȡ��ΪExactDependenceTest
 */
public interface ExactDependenceTst {
	
	/**
	 * �ж�Ax+b>=0�Ƿ���������⡣
	 * @param A
	 * @param b
	 * @return ������ڽⷵ��true����������ڽⷵ��false��
	 * 		   ������㷨�޷��жϣ��׳�NotApplicableCaseException�쳣��
	 * @throws NotApplicableCaseException 
	 */
	public boolean dependent(int[][] A,int[] b) throws NotApplicableCaseException;

}

class NotApplicableCaseException extends RuntimeException{
	
}