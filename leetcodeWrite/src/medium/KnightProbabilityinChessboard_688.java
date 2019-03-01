package medium;

import java.util.Arrays;

/**
 * 688. “马”在棋盘上的概率
 * 已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。 

现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。 

如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。

 



 

现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。

求移动结束后，“马” 仍留在棋盘上的概率。

 

示例：

输入: 3, 2, 0, 0
输出: 0.0625
解释: 
输入的数据依次为 N, K, r, c
第 1 步时，有且只有 2 种走法令 “马” 可以留在棋盘上（跳到（1,2）或（2,1））。对于以上的两种情况，各自在第2步均有且只有2种走法令 “马” 仍然留在棋盘上。
所以 “马” 在结束后仍在棋盘上的概率为 0.0625。
 

注意：

N 的取值范围为 [1, 25]
K 的取值范围为 [0, 100]
开始时，“马” 总是位于棋盘上
 * @author liang
 *
 */
public class KnightProbabilityinChessboard_688 {

	/**
	 * dp动态规划
	 * 储存的dp[i][j]的是经过x次能走到当前位置的走法次数
	 * 初始化所有位置只有1种走法
	 * 这样经过K次变换后，dp[r][c]保存的就是有多少种走法能最后走到这个位置
	 * 反过来想  就是 从这个位置能有多少种走法走到 棋盘上的某个位置
	 * 然后dp[r][c]/8^K 结果就是概率
	 * @param N
	 * @param K
	 * @param r
	 * @param c
	 * @return
	 */
    public static double knightProbability(int N, int K, int r, int c) {
    	int[][] moves = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
    	double[][] dp = new double[N][N];
    	for(double [] row:dp) {
    		Arrays.fill(row, 1);
    	}
    	for(int step=0;step<K;step++) {
    		double[][] dp1 = new double[N][N];
    		for(int i=0;i<N;i++) {
    			for(int j=0;j<N;j++) {
    				for(int[] move:moves) {
    					int row = move[0]+i;
    					int col = move[1]+j;
    					if(isIllegal(row,col,N)) {
    						dp1[row][col]+=dp[i][j];
    					}
    				}
    			}
    		}
    		dp = dp1;//每走完一轮，就重置，保证初始值不变
    	}

    	return dp[r][c]/Math.pow(8,K);
    }
    
	private static boolean isIllegal(int row, int col, int n) {
		// TODO Auto-generated method stub
		return row>=0 && row<n && col>=0 && col<n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnightProbabilityinChessboard_688.knightProbability(4, 4, 4, 4);
	}

}
