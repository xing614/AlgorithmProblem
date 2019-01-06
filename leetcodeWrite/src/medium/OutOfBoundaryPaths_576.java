package medium;
/**
 * 576. 出界的路径数
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 * @author liang
 *
 */
public class OutOfBoundaryPaths_576 {

	/**
	 * 动态规划 d[i][j][k]表示从(i, j)开始在k步内移除边界的路径数.可知dp[i][j][k]只与(i, j)四周邻接点在k-1步内移除边界的路径数有关
	 * dp[i][j][k] = dp[i-1][j][k-1] + dp[i+1][j][k-1] + dp[i][j-1][k-1] + dp[i][j+1][k-1];
	 * @param m
	 * @param n
	 * @param N
	 * @param i
	 * @param j
	 * @return
	 */
    public int findPaths(int m, int n, int N, int i, int j) {
        if(N<=0)
        	return 0;
        int mod = 1000000007;
        int[][][] dp = new int[m][n][N+1];
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        
        for(int k=1;k<=N;k++) {
        	for(int x=0;x<m;x++) {
        		for(int y=0;y<n;y++) {
        			for(int[] dir:dirs) {
        				int nx = x+dir[0];
        				int ny = y+dir[1];
        				// 边界处理, 无论在第几步只要位置处于边界都包含一步出界的情况
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n) 
                            dp[x][y][k] += 1;
                        else
                            dp[x][y][k] = (dp[x][y][k] + dp[nx][ny][k-1]) % mod;
        			}
        		}
        	}
        }
        
        return dp[i][j][N];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
