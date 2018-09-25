package medium;
/**
 * 279. 完全平方数
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.

 * @author liang
 *
 */
public class PerfectSquares_279 {

	/**
	 * dp动态规划
	 * dp[1] = dp[0]+1 = 1
		dp[2] = dp[1]+1 = 2
		dp[3] = dp[2]+1 = 3
		dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
		      = Min{ dp[3]+1, dp[0]+1 } 
		      = 1                
		dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
		      = Min{ dp[4]+1, dp[1]+1 } 
		      = 2
		dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
		       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
		       = 2
		dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
		
	 * @param n
	 * @return
	 */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++) {
        	dp[i] = i;// 最多都由1组成
        	for(int j=1;j*j<n;j++) {
        		dp[i] = Math.min(dp[i-j*j]+1, dp[i]);//类似0-1背包，选择最小数量
        	}
        }
        return dp[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
