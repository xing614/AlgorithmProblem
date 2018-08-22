package medium;
/**
 * 64. 最小路径和
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 * @author liang
 *
 */
public class MinimumPathSum_64 {

	/**
	 * 动态规划
	 * 利用到上一次的结果
	 * 从原点到达（i, j）的最小路径等于 ：
	 * 原点到达（i-1, j）最小路径与到达（i, j-1）最小路径中的最小值。
	 * 即 dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]
	 * O（M*n）
	 * @param grid
	 * @return
	 */
    public int minPathSum(int[][] grid) {
    	//动态规划直接使用grid作为保存数据数组
        for(int i=1;i<grid.length;i++) grid[i][0] += grid[i-1][0];//设置第一列的所有数据
        for(int j=1;j<grid[0].length;j++) grid[0][j] += grid[0][j-1];//设置第一行
        for(int i=1;i<grid.length;i++) {
        	for(int j=1;j<grid[0].length;j++) {
        		grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
        	}
        }
        return grid[grid.length-1][grid[0].length-1];
    }
    /**
     * 优化
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        int[] dp = new int[grid.length];
        dp[0] = grid[0][0];
        for(int i=1; i<grid.length; i++) dp[i] = grid[i][0]+dp[i-1];
        for(int j=1; j<grid[0].length; j++)
            for(int i=0; i<grid.length; i++)
                dp[i] = (i==0 ? dp[i] : Math.min(dp[i], dp[i-1])) + grid[i][j];
        return dp[grid.length-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
