package medium;
/**
 * 377. 组合总和4
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

示例:

nums = [1, 2, 3]
target = 4

所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

请注意，顺序不同的序列被视作不同的组合。

因此输出为 7。
进阶：
如果给定的数组中含有负数会怎么样？
问题会产生什么变化？
我们需要在题目中添加什么限制来允许负数的出现？
 * @author liang
 *
 */
public class CombinationSum4_377 {

	/**
	 * 动态规划
	 * 设dp[i]是target为i的组成总数，他从dp[0] ~ dp[i-1]来得到
	 * 当target是0，即i是0的时候，理解上dp[0]应该是0，但是这里要设置成1，是因为要把这个1想象成空集去组合其他的数。
	 * dp[i-nums[j]]即以i-nums[j]作为target的时候所需要的组合数
	 * 随着nums[j]不同，dp[i]的值应该是考虑所有nums[j]后的总和
	 * 得到状态转移方程 dp[i] = dp[i] + dp[i-nums[j]]
	 * @param nums
	 * @param target
	 * @return
	 */
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target<=0)
        	return 0;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1;i<=target;i++) {
        	for(int j=0;j<nums.length;j++) {
        		if(i>=nums[j])
        			dp[i]+=dp[i-nums[j]];
        	}
        }
        return dp[target];
    }
    
}
