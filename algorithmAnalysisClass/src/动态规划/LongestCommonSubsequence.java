package 动态规划;
/**
 * 当一个问题具有最优子结构性质时，可以使用动态规划求解
 * 
 * 最长公共子序列
 * 例如：X={A,B,C,B,D,A,B},Y={B,D,C,A,B,A},则最长公共子序列：{B,C,B,A}
 * @author liang
 * 1.分析最优子结构
 * 	若xm = yn,则zk = xm = yn,Z(k-1)是X(m-1)和Y(n-1)的最长公共子序列
 *  若xm!= yn,且zk!=xm,则Z是X(m-1)和Y的最长公共子序列
 *  若xm!= yn,且zk!=yn,则Z是X和Y(n-1)的最长公共子序列
 * 2.找出子问题的递归结构
 *  c[i][j]   记录序列Xi和Yj的最长公共子序列的长度
 *  		= 0                 i=0,j=0
 *  		= c[i-1][j-1]+1     i,i>0;xi = yj
 *  		= max{c[i][j-1],c[i-1][j]}	i,j>0;xi!=yj
 */
public class LongestCommonSubsequence {

	public static String[] A = {"","A","B","C","B","D","A","B"};
	public static String[] B = {"","B","D","C","A","B","A"};
	public static int c[][] = new int[A.length][B.length];//存储Xi和Yj的最长公共子序列的长度
	public static int b[][] = new int[A.length][B.length];//记录c[][]由哪个子问题的解得到
	
	/**
	 * 用于得到最长公共子序列的长度，c[][]和b[][]
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
				if(A[i] == B[j]){//结构1
					c[i][j] = c[i-1][j-1]+1;b[i][j] = 1;
				}
				else if(c[i-1][j]>=c[i][j-1]){//结构2
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
	 * 获得子序列
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
