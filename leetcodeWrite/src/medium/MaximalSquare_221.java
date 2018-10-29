package medium;
/**
 * 221. 最大正方形
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
 * @author liang
 *
 */
public class MaximalSquare_221 {
	/**
	 * 当 maxtrix[i][j] = '1' 时，以 matrix[i][j] 为正方形右下角的边长，
	 * 最多总是比以 matrix[i - 1][j]、matrix[i][j - 1]、matrix[i - 1][j - 1] 为右下角的正方形边长中最小的边长大1。
	 * 这是因为，如果以 matrix[i - 1][j]、matrix[i][j - 1]、matrix[i - 1][j - 1] 为右下角的正方形边长相等，那么加上该点后就可以构成一个更大的正方形。
	 * 如果它们不相等，那么因为缺失某部分，而无法构成更大正方形，那么只能取3个正方形中最小的一个加1，为此可以得到动态规划递推式：
	 * dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
	 * @param matrix
	 * @return
	 */
    public int maximalSquare(char[][] matrix) {
    	if(matrix.length == 0)
    		return 0;
    	int[][] dp = new int[matrix.length][matrix[0].length];
    	int max = 0;//最大正方形长度
    	for(int i=0;i<matrix.length;i++) {//将左一列条设置dp，为1 的设置为1
    		dp[i][0] = matrix[i][0] - '0';
    		max = Math.max(max, dp[i][0]);
    	}
    	for(int i=0;i<matrix[0].length;i++) {//第一行设置
    		dp[0][i] = matrix[0][i] - '0';
    		max = Math.max(max, dp[0][i]);
    	}
    	for(int i = 1;i<matrix.length ;i++) {
    		for(int j = 1;j<matrix[0].length;j++) {
    			if(matrix[i][j] == '1') {//如果当前位置是1，就看它右上那个位置是正方形右下角的大小和当前位置左和上为正方形右下角 面积小的那个 +1
    				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]))+1;
    				max = Math.max(dp[i][j], max);
    			}
    		}
    	}
    	return max*max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
