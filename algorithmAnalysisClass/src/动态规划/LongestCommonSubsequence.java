package ��̬�滮;
/**
 * ��һ��������������ӽṹ����ʱ������ʹ�ö�̬�滮���
 * 
 * �����������
 * ���磺X={A,B,C,B,D,A,B},Y={B,D,C,A,B,A},������������У�{B,C,B,A}
 * @author liang
 * 1.���������ӽṹ
 * 	��xm = yn,��zk = xm = yn,Z(k-1)��X(m-1)��Y(n-1)�������������
 *  ��xm!= yn,��zk!=xm,��Z��X(m-1)��Y�������������
 *  ��xm!= yn,��zk!=yn,��Z��X��Y(n-1)�������������
 * 2.�ҳ�������ĵݹ�ṹ
 *  c[i][j]   ��¼����Xi��Yj������������еĳ���
 *  		= 0                 i=0,j=0
 *  		= c[i-1][j-1]+1     i,i>0;xi = yj
 *  		= max{c[i][j-1],c[i-1][j]}	i,j>0;xi!=yj
 */
public class LongestCommonSubsequence {

	public static String[] A = {"","A","B","C","B","D","A","B"};
	public static String[] B = {"","B","D","C","A","B","A"};
	public static int c[][] = new int[A.length][B.length];//�洢Xi��Yj������������еĳ���
	public static int b[][] = new int[A.length][B.length];//��¼c[][]���ĸ�������Ľ�õ�
	
	/**
	 * ���ڵõ�����������еĳ��ȣ�c[][]��b[][]
	 */
	public static void LCSLength(){
		int i,j;
		for(i=0;i<A.length;i++){
			c[i][0] = 0;
		}
		for(i=0;i<B.length;i++){
			c[0][i] = 0;
		}
		for(i = 1;i<A.length;i++){
			for(j = 1;j<B.length;j++){
				if(A[i] == B[j]){//�ṹ1
					c[i][j] = c[i-1][j-1]+1;b[i][j] = 1;
				}
				else if(c[i-1][j]>=c[i][j-1]){//�ṹ2
					c[i][j] = c[i-1][j];
					b[i][j] = 2;
				}else{
					c[i][j] = c[i][j-1];
					b[i][j] = 3;					
				}
			}
		}
		
	}
	
	/**
	 * ���������
	 */
	public static void LCS(int i,int j){
		if(i==0||j==0)
			return;
		if(b[i][j] == 1){
			LCS(i-1,j-1);
			System.out.println(A[i]);
		}
		else if(b[i][j] ==2){
			LCS(i-1,j);
		}else{
			LCS(i,j-1);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LCSLength();
		LCS(A.length-1,B.length-1);
	}

}
