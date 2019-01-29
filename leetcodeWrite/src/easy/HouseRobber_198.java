package easy;
/**
 * 198. 打家劫舍
题目描述提示帮助提交记录社区讨论阅读解答
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2:

输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @author liang
 *
 */
public class HouseRobber_198 {

	/**
	 * 动态规划（Dynamic Programming） 
	 * 状态转移方程：dp[i] = max(dp[i - 2], dp[i - 3]) + num[i] 【A】 
	 * 其中，dp[i]表示打劫到第i间房屋时累计取得的金钱最大值。 
	 * 第 i 个位置的 max 值是由 max(i-2, i-3) 加上 i 位置的值决定，以此类推) 
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        
        if(nums.length == 1)
        	return nums[0];
        // 如果数组中的元素个数大于2个，对于【A】式，i=2，dp[2-3]不存在
        if (nums.length > 2) {
            nums[2] += nums[0];
        }
        //从第4元素开始处理
        int i =3;
        for(;i<nums.length;i++) {
        	//第i个元素最大值
        	nums[i] += Math.max(nums[i-2], nums[i-3]);
        }
        if(nums.length == 1) {
        	return nums[0];
        }else if(nums.length == 2) {
        	return nums[1]>nums[0]?nums[1]:nums[0];
        }else{// 多于两个元素，最大值在末尾两个之间，找最大的返回
        	return Math.max(nums[i-1], nums[i-2]);
        }
    }
	/**
	 * 方法二
	 * 动态规划解法，每个index的位置有两种选择，rob或者notrob，
	 * rob的话可以更新值，notrob可以一直把前面的最大值向后传递，最后返回rob和notrob的最大值即可
	 * 。时间复杂度为O(n)，空间复杂度为O(1)。
	 * @param nums
	 * @return
	 */
	public int rob2(int[] nums) {
        int rob = 0, notrob = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = rob;//上一个 抢劫的值
            rob = notrob + nums[i];//上一个位置未抢劫的值+抢劫当前位置的值
            notrob = Math.max(temp, notrob);//
        }
        return Math.max(rob, notrob);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
