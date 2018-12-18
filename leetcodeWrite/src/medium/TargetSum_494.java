package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

示例 1:

输入: nums: [1, 1, 1, 1, 1], S: 3
输出: 5
解释: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。
注意:

数组的长度不会超过20，并且数组中的值全为正数。
初始的数组的和不会超过1000。
保证返回的最终结果为32位整数。
 * @author liang
 *
 */
public class TargetSum_494 {

	/**
	 * 方法一，dfs每次sum+nums[]或sum-nums[]
	 * @param nums
	 * @param S
	 * @return
	 */
    public int findTargetSumWays1(int[] nums, int S) {
        int[] arr = new int[1];//保存返回值
        helper1(nums,S,arr,0,0);//第四个0是当前的和，第五个是起点
        return arr[0];
    }
    
	private void helper1(int[] nums, int s, int[] arr, int sum, int start) {
		// TODO Auto-generated method stub
		if(start == nums.length) {
			if(sum == s)
				arr[0]++;
			return ;
		}
		// 这里不要加for循环，因为只是从index0开始
		helper1(nums,s,arr,sum+nums[start],start+1);
		helper1(nums,s,arr,sum-nums[start],start+1);
	}

	/**
	 * 方法2 备忘录  使用一个map保存index->sum时有多少种答案
	 * @param nums
	 * @param S
	 * @return
	 */
	public int findTargetSumWays2(int[] nums, int S) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return helper2(nums, 0, 0, S, new HashMap<>());
	}
 
	private int helper2(int[] nums, int index, int sum, 
			int S, Map<String, Integer> map) {
		// 避免数字是重复，无法找到截断点
		String encodeString = index + "->" + sum;
		if (map.containsKey(encodeString)) {
			return map.get(encodeString);
		}
		if (index == nums.length) {
			if (sum == S) {
				return 1;
			} else {
				return 0;
			}
		}
		int curNum = nums[index];
		int add = helper2(nums, index + 1, sum - curNum, S, map);
		int minus = helper2(nums, index + 1, sum + curNum, S, map);
		map.put(encodeString, add + minus);
		return add + minus;
	}
	
	/**
	 * 方法三
	 * 动态规划问题
	 * 举例说明: nums = {1,2,3,4,5}, target=3, 一种可行的方案是+1-2+3-4+5 = 3

     该方案中数组元素可以分为两组，一组是数字符号为正(P={1,3,5})，另一组数字符号为负(N={2,4})

     因此: sum(1,3,5) - sum(2,4) = target

              sum(1,3,5) - sum(2,4) + sum(1,3,5) + sum(2,4) = target + sum(1,3,5) + sum(2,4)

              2sum(1,3,5) = target + sum(1,3,5) + sum(2,4)

              2sum(P) = target + sum(nums)

              sum(P) = (target + sum(nums)) / 2

     由于target和sum(nums)是固定值，因此原始问题转化为求解nums中子集的和等于sum(P)的方案个数问题
	 * 
	 * 求解nums中子集合只和为sum(P)的方案个数(nums中所有元素都是非负)
	 * 给定集合nums={1,2,3,4,5}, 求解子集，使子集中元素之和等于9 = new_target = sum(P) = (target+sum(nums))/2
	 * @param nums
	 * @param S
	 * @return
	 */
	public int findTargetSumWays3(int[] nums, int S) {
		int sum = 0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
		}
		if(S>sum || (sum+S)%2 == 1) {
			return 0;
		}
		return subSum(nums,(sum+S)/2);
	}
	/**
	 * 定义dp[S+1]数组, dp[10] = {1,0,0,0,0,0,0,0,0,0}
	 * dp[i]表示子集合元素之和等于当前目标值的方案个数, 当前目标值等于S减去当前元素值
	 *   当前元素等于1时，dp[9] = dp[9] + dp[9-1]
	 *   dp[8] = dp[8] + dp[8-1]
	 * @param nums
	 * @param S
	 * @return
	 */
	private int subSum(int[] nums, int S) {
		// TODO Auto-generated method stub
		int[] dp = new int[S+1];
		dp[0] = 1;
		for(int i =0;i<nums.length;i++) {
			for(int j =S;j>=nums[i];j--) {
				dp[j]+=dp[j-nums[i]];
			}
		}
		return dp[S];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
