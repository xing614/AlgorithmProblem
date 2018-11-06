package medium;
/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].
 

示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.
 * @author liang
 *
 */
public class PartitionEqualSubsetSum_416 {

	/**
	 * 动态规划，0/1背包问题。对于输入的数组nums，首先nums中各个元素之和要是偶数，然后就是找到可以将nums中的元素划分为2个不相交子集，并且这2个子集互补。
	 * nums中的元素可以划分为2类：考虑了的和没考虑了的。由大值遍历到小值
	 * @param nums
	 * @return
	 */
    public boolean canPartition(int[] nums) {
        if(nums.length == 0 || nums == null) {
        	return false;
        }
        int sum = 0;
        for(int num:nums)
        	sum +=num;
        if(sum%2 == 1)
        	return false;
        sum /=2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        int curSum = 0;//当前的和
        //nums中的元素可以划分为2类：考虑了的和没考虑了的
        for(int i=0;i<nums.length;i++) {
        	int tmax = Math.min(curSum+nums[i], sum);//内循环的上限的有效值
        	for(int j=tmax;j>=nums[i];j--) {
        		//构成j值只有2种情况：包含nums[i]，不包含nums[i]
        		//包含nums[i]：dp[j] = dp[j - nums[i]]
        		//不包含nums[i]：dp[j] = dp[j] 
        		dp[j] = dp[j] || dp[j-nums[i]];//有true则为true
        	}
        	if(dp[sum])//一旦满足直接返回，减少遍历
        		return true;
        	curSum +=nums[i];
        }
        return dp[sum];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
