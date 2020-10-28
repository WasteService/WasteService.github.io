package util;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtils {
	
	public final static int[][] ZeroMatrix=new int[][]{};
	
	/**
	 * ����һ��n*n�׵ĵ�λ����
	 */
	public static int[][] eye(final int n){
		int[][] ret=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				if(i==j) ret[i][j]=1;
				else ret[i][j]=0;
		}
		return ret;
	}
	
	/**
	 *����ת��
	 */
	public static int[][] transpose(final int[][] m){
		int[][] ret=new int[m[0].length][m.length];
		for(int i=0;i<m[0].length;i++)
			for(int j=0;j<m.length;j++) ret[i][j]=m[j][i];
		return ret;
	}
	
	/**
	 * ��һ��һά����m��չΪһ����ά���飬ά��Ϊm*1
	 * @param m
	 * @return
	 */
	public static int[][] expandColumn(int[] m){
		int[][] ret=new int[m.length][1];
		for(int i=0;i<ret.length;i++) ret[i][0]=m[i];
		return ret;
	}
	
	/**
	 * ��һ��һά����m��չΪһ����ά���飬ά��Ϊ1*m
	 * @param m
	 * @return
	 */
	public static int[][] expandRow(int[] m){
		int[][] ret=new int[1][m.length];
		ret[0]=m;//�������Ƿ�ã�
		//for(int i=0;i<ret.length;i++) ret[0][i]=m[i];
		return ret;
	}
	
	/**
	 *��һ����ά����ѹ��Ϊһ��һά���顣�ö�ά������л����е�ά������Ϊ1��
	 */
	public static int[] collapse(int[][] m){
		if(m.length==1) return m[0];
		if(m[0].length==1){
			int[] ret=new int[m.length];
			for(int i=0;i<m.length;i++) ret[i]=m[i][0];
			return ret;
		}
		throw new RuntimeException();
	}
	
	/**
	 * ˮƽ�ϲ�������������
	 * @param left �����
	 * @param right �Ҿ���
	 * @return �ϲ��Ժ�ľ���
	 */
	public static int[][] columnMerge(int[][] left,int[][] right){
		assert left.length==right.length;
		int row=left.length;
		int col=left[0].length+right[0].length;
		int[][] ret=new int[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(j<left[0].length) ret[i][j]=left[i][j];
				else ret[i][j]=right[i][j-left[0].length];
			}
		}
		return ret;
	}
	
	public static int[][] columnMerge(int[][] left,int[] right){
		assert left.length==right.length;
		int row=left.length;
		int col=left[0].length+1;
		int[][] ret=new int[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col-1;j++){
				ret[i][j]=left[i][j];
			}
			ret[i][col-1]=right[i];
		}
		return ret;
	}
	
	public static int[][] rowMerge(int[][] up, int[][] down) {
		assert up[0].length==down[0].length;
		int[][] ret=new int[up.length+down.length][up[0].length];
		for(int i=0;i<up.length;i++) ret[i]=up[i];
		for(int i=0;i<down.length;i++) ret[i+up.length]=down[i];
		return ret;
	}
	
	/**
	 * �ӵ�k�зָ����m��ʹ�÷ָ����ߵľ���Ϊk�о���
	 * @return
	 */
	public static MatrixPair splitColumn(int[][] m , int k){
		assert m[0].length>k;
		int[][] m1=new int[m.length][k];
		int[][] m2=new int[m.length][m[0].length-k];
		for(int i=0;i<m.length;i++)
			for(int j=0;j<k;j++) m1[i][j]=m[i][j];
		for(int i=0;i<m.length;i++)
			for(int j=k;j<m[0].length;j++) m2[i][j-k]=m[i][j];
		MatrixPair mp=new MatrixPair();
		mp.m1=m1;
		mp.m2=m2;
		return mp;
	}
	
	/**
	 * �ӵ�k�зָ����m��ʹ�÷ָ���ϱߵľ���Ϊk�о���
	 * @return
	 */
	public static MatrixPair splitRow(int[][] m,int k){
		assert m.length>k;
		int[][] m1=new int[k][m[0].length];
		int[][] m2=new int[m.length-k][m[0].length];
		for(int i=0;i<k;i++) m1[i]=m[i];
		for(int i=k;i<m.length;i++) m2[i-k]=m[i];
		MatrixPair mp=new MatrixPair();
		mp.m1=m1;
		mp.m2=m2;
		return mp;
	}
	
	/**
	 * ��һ����ģ�任����-1����һ��
	 * @param matrix Ҫ�任�ľ���
	 * @param k ������-1����һ��
	 */
	public static void unimodular1(int[][] matrix,int k){
		for(int i=0;i<matrix[0].length;i++) matrix[k][i]=-matrix[k][i];
	}
	
	/**
	 * �ڶ�����ģ�任���������������
	 * @param matrix Ҫ�任�ľ���
	 * @param k1, k2 ������������
	 */
	public static void unimodular2(int[][] matrix, int k1,int k2){
		for(int i=0;i<matrix[0].length;i++){
			int tmp=matrix[k1][i];
			matrix[k1][i]=matrix[k2][i];
			matrix[k2][i]=tmp;
		}
	}
	
	public static void rowExchange(int[][] matrix, int k1,int k2){
		unimodular2(matrix,k1,k2);
	}
	
	public static void columnExchange(int[][] matrix, int k1,int k2){
		for(int i=0;i<matrix.length;i++){
			int tmp=matrix[i][k1];
			matrix[i][k1]=matrix[i][k2];
			matrix[i][k2]=tmp;
		}
	}
	
	/**
	 * ��������ģ�任��������ĵ�k1�м���k2�е�n��
	 * @param matrix Ҫ�任�ľ���
	 * @param k1 ���ӵ���һ��
	 * @param k2 ���Դ���
	 * @param n  ����
	 */
	public static void unimodular3(int[][] matrix, int k1,int k2,int n){
		for(int i=0;i<matrix[0].length;i++){
			matrix[k1][i]+=matrix[k2][i]*n;
		}
	}
	
	/**
	 * ����m1�;���m2���
	 * @param m1
	 * @param m2
	 * @return
	 */
	public static int[][] multi(int[][] m1,int[][] m2){
		assert m1[0].length==m2.length;
		int[][] ret=new int[m1.length][m2[0].length];
		for(int i=0;i<m1.length;i++){
			for(int j=0;j<m2[0].length;j++){
				int tmp=0;
				for(int k=0;k<m2.length;k++){
					tmp+=m1[i][k]*m2[k][j];
				}
				ret[i][j]=tmp;
			}
		}
		return ret;
	}
	
	public static void scalarOperation(int[][] matrix,int value,char op){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				switch(op){
					case '+': matrix[i][j]=matrix[i][j]+value;break;
					case '-': matrix[i][j]=matrix[i][j]-value;break;
					case '*': matrix[i][j]=matrix[i][j]*value;break;
					case '/': matrix[i][j]=matrix[i][j]/value;break;
					default: throw new RuntimeException("��֧�ֵ������:"+op);
				}
			}
		}
	}
	
	public static void scalarOperation(int[] array,int value,char op){
		for(int i=0;i<array.length;i++){
				switch(op){
					case '+': array[i]=array[i]+value;break;
					case '-': array[i]=array[i]-value;break;
					case '*': array[i]=array[i]*value;break;
					case '/': array[i]=array[i]/value;break;
					default: throw new RuntimeException("��֧�ֵ������:"+op);
				}
		}
	}
	

	/**
	 * ����m1�;���m2���
	 * @param m1
	 * @param m2
	 * @return
	 */
	public static int[][] add(int[][] m1, int[][] m2) {
		assert m1.length==m2.length;
		assert m1[0].length==m2[0].length;
		int[][] ret=new int[m1.length][m1[0].length];
		for(int i=0;i<ret.length;i++){
			for(int j=0;j<ret[0].length;j++){
				ret[i][j]=m1[i][j]+m2[i][j];
			}
		}
		return ret;
	}
	
	public static int[] add(int[] m1, int[] m2) {
		assert m1.length==m2.length;
		int[] ret=new int[m1.length];
		for(int i=0;i<ret.length;i++) ret[i]=m1[i]+m2[i];
		return ret;
	}
	
	/**
	 * ����m1��ȥ����m2
	 * @param m1
	 * @param m2
	 * @return
	 */
	public static int[][] subtract(int[][] m1, int[][] m2) {
		assert m1.length==m2.length;
		assert m1[0].length==m2[0].length;
		int[][] ret=new int[m1.length][m1[0].length];
		for(int i=0;i<ret.length;i++){
			for(int j=0;j<ret[0].length;j++){
				ret[i][j]=m1[i][j]-m2[i][j];
			}
		}
		return ret;
	}
	
	public static int[] subtract(int[] m1, int[] m2) {
		assert m1.length==m2.length;
		int[] ret=new int[m1.length];
		for(int i=0;i<ret.length;i++) ret[i]=m1[i]-m2[i];
		return ret;
	}
	
	/**
	 * ɾ��������ȫ��Ϊ0����
	 */
	public static int[][] clearAllZeroColumn(int[][] A){
		List<Integer> zeroCol=new ArrayList<Integer>();
		for(int i=0;i<A[0].length;i++){
			boolean allZero=true;
			for(int j=0;j<A.length;j++){
				if(A[j][i]!=0) {
					allZero=false;
					break;
				}
			}
			if(allZero) zeroCol.add(i);
		}
		int[][] ret=new int[A.length][A[0].length-zeroCol.size()];
		for(int i=0,k=0;i<A[0].length;i++){
			if(zeroCol.contains(i)) continue;
			for(int j=0;j<A.length;j++){
				ret[j][k]=A[j][i];
			}
			k++;
		}
		return ret;
	}

	public static int[][] clone(int[][] A) {
		int[][] ret=new int[A.length][A[0].length];
		for(int i=0;i<ret.length;i++){
			for(int j=0;j<ret.length;j++){
				ret[i][j]=A[i][j];
			}
		}
		return ret;
	}

}

