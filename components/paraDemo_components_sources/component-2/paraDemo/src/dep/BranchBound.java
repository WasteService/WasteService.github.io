package dep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.MatrixUtils;

/**
 * ʹ�÷�֧���編���������Թ滮
 * @author ylt
 *
 */
public class BranchBound {
	/**
	 * ��Ax+b>=0�ķ������Ƿ����������
	 * @param Ab ϵ������
	 * @return ����������ⷵ��true�����򷵻�false
	 */
	public boolean solve(int[][] Ab){
		List<int[][]> ss=new ArrayList<int[][]>();
		ss.add(Ab);
		int k=Ab[0].length;
		for(int i=k-2;i>=0;i--){
			try{
				Ab=new FourierMotzkin().elimination(Ab, i);
			}catch(NoSolutionException e){
				return false;
			}
			ss.add(Ab);
		}
		Collections.reverse(ss);
		List<Integer> sampleSolutions=new ArrayList<Integer>();
		int i=1;
		SolutionSet solution=null;
		for(;i<ss.size();i++){
			int[][] reduce=reduce(ss.get(i),sampleSolutions);
			try{
				solution=findSolution(reduce);
				sampleSolutions.add(solution.calcMiddle());
			}catch(NoSolutionException e){
				//��ĳЩ����ֵ�޽��Ƿ��һ���޽⣿
				return false;
			}catch(NoIntegerSolutionException e){
				break;
			}
		}
		if(i==k) return true;
		if(i==1) return false;
		if(solve(addMinOrMaxConstraint(Ab, i, solution.min(), true)) || 
				solve(addMinOrMaxConstraint(Ab, i, solution.max(), false))) return true;
		return false;
	}
	
	public boolean solve(int[][] A,int[] b){
		int[][] Ab=MatrixUtils.columnMerge(A, b);
		return solve(Ab);

	}
	
	private int[][] addMinOrMaxConstraint(int[][] Ab,int k,int minOrMaxValue,boolean min){
		int[][] ret=new int[Ab.length+1][Ab[0].length];
		System.arraycopy(Ab, 0, ret, 0, Ab.length);
		for(int i=0;i<Ab[0].length;i++){
			ret[Ab.length][i]=0;
		}
		if(min){
			ret[Ab.length][k]=1;
			ret[Ab.length][Ab[0].length-1]=-minOrMaxValue;
		}else{
			ret[Ab.length][k]=-1;
			ret[Ab.length][Ab[0].length-1]=minOrMaxValue;
		}
		return ret;
	}
	
	/**
	 * ����Լ��Ax+b>=0����ǰm��������sampleSolutions�е���������ֵ�滻��
	 * @param Ab ϵ������
	 * @param sampleSolutions m������ֵ���б�
	 * @return �滻�������Ab����
	 */
	int[][] reduce(int[][] Ab,List<Integer> sampleSolutions) {
		int ks=sampleSolutions.size();
		if(ks==0) return Ab;
		int[][] ret=new int[Ab.length][Ab[0].length-ks];
		for(int i=0;i<ret.length;i++){
			for(int j=0;j<ret[0].length;j++){
				ret[i][j]=Ab[i][j+ks];
			}
			for(int k=0;k<ks;k++){
				ret[i][ret[0].length-1]+=sampleSolutions.get(k)*Ab[i][k];
			}
		}
		return ret;
	}

	/**
	 * ��ֻ����һ�������ķ�����,���ؽ�����½硣<br>
	 * A<sub>1</sub>x+b<sub>1</sub>>=0<br>
	 * A<sub>2</sub>x+b<sub>2</sub>>=0<br>
	 * ...<br>
	 * A<sub>n</sub>x+b<sub>n</sub>>=0<br>
	 * @param Ab ϵ������
	 * @return ���㷽�̵Ľ�
	 */
		SolutionSet findSolution(int[][] Ab) {
		assert Ab[0].length==2;
		SolutionSet tri=new SolutionSet();
		for(int i=0;i<Ab.length;i++){
			if(Ab[i][0]>0){
				double d=(-1.0*Ab[i][1])/Ab[i][0];
				tri.min=Math.max(tri.min, d);
			}else if(Ab[i][0]==0){
				if(Ab[i][1]<0) throw new NoSolutionException();
			}else{
				double d=Ab[i][1]/(-1.0*Ab[i][0]);
				tri.max=Math.min(tri.max, d);
			}
		}
		return tri;
	}

}

final class SolutionSet{
	public SolutionSet(){
		max=Double.MAX_VALUE;
		min=-max;//ע�⣺Double��MIN_VALUEָ������С���������������ĸ���
		//min=Double.MIN_VALUE;
	}
	Double min;
	Double max;
	
	public int calcMiddle(){
		double precision=0.00001;
		if(max-min+precision<0) throw new NoSolutionException();
		int m2=(int) min.doubleValue();
		int m1=(int) max.doubleValue();
		if(m1-m2>1) return (m1+m2)/2;
		if(m1-m2==1){
			double difference=max-min;
			if(difference+precision<1) throw new NoIntegerSolutionException();
			return m1;
		}
		if(max-m1>precision&&min-m1>precision) throw new NoIntegerSolutionException();
		if(m1-max>precision&&m1-max>precision) throw new NoIntegerSolutionException();
		return m1;//m1==m2
	}
	
	public int min(){
		int ret=min.intValue();
		if((min-ret)>=0.5) ret+=1;
		return ret;
	}
	
	public int max(){
		int ret=max.intValue();
		if((max-ret)>=0.5) ret+=1;
		return ret;
	}
}

class NoIntegerSolutionException extends RuntimeException{}

