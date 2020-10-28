package dep;

import util.MatrixPair;
import util.MatrixUtils;

public class DependenceAnalysis {

	/**
	 * �ж���A1x+b>=0��x'A2=c��ɵ�ѭ���Ƿ��������
	 * 
	 * @param A1
	 * @param b
	 * @param A2
	 * @param c
	 * @return �����������������true;�������������������false
	 */
	public boolean dependent(int[][] A1, int[] b, int[][] A2, int[] c) {
		assert A1[0].length == A2.length;// ����x��ά��
		ExtendGcd gcd = new ExtendGcd();
		MatrixPair mp = null;
		try{
			mp = gcd.solve(A2, c);
		}catch(NoSolutionException e){
			return false;
		}
		// U*A2=D,�ⷽ��TD=c�õ�T����Ϊx'A2=c,����x'=T*U��T�а���k�����n-k��δ֪����n��x��ά����
		// ��x'��ʾΪe+t.f������tΪT�е�δ֪����
		// x=f't'+e'
		// Ax+b=A(f't'+e')+b
		// _A1=A1.f'
		// _b=A1.e'+b
		// _A1,_b�ǽ�x�滻Ϊt�Ժ�Ĳ���ʽԼ��
		int[][] _A1 = MatrixUtils.multi(A1, MatrixUtils.transpose(mp.m1));
		int[] _b = MatrixUtils.add(MatrixUtils.collapse(MatrixUtils.multi(A1,
				MatrixUtils.transpose(mp.m2))), b);
//		IndependentVariableds  iv=new IndependentVariableds();
//		 try{
//			 return iv.dependent(_A1, _b);
//		 }catch (NotApplicableCaseException nace) {
//			 _A1=iv.A; _b=iv.b;
//		 }
		 Acyclic acyclic=new Acyclic();
		 try{
			 return acyclic.dependent(_A1, _b);
		 }catch (NotApplicableCaseException nace) {
			 _A1=acyclic.A; _b=acyclic.b;
		 }
		 try{
			 new LoopResidue().dependent(_A1, _b);
		 }catch (NotApplicableCaseException nace) {}
		return new BranchBound().solve(_A1, _b);
	}
	
	/**
	 * Ӧ�ú�dependent��������ͬ���Ľ��
	 */
	boolean dependent2(int[][] A1, int[] b, int[][] A2, int[] c) {
		assert A1[0].length == A2.length;// ����x��ά��
		ExtendGcd gcd = new ExtendGcd();
		MatrixPair mp = null;
		try{
			mp = gcd.solve(A2, c);
		}catch(NoSolutionException e){
			return false;
		}
		int[][] _A1 = MatrixUtils.multi(A1, MatrixUtils.transpose(mp.m1));
		int[] _b = MatrixUtils.add(MatrixUtils.collapse(MatrixUtils.multi(A1,
				MatrixUtils.transpose(mp.m2))), b);
		return new BranchBound().solve(_A1, _b);
	}

}
