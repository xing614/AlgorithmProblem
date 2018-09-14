package medium;
/**
 * 213. 打家劫舍 II
题目描述提示帮助提交记录社区讨论阅读解答
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2:

输入: [1,2,3,1]
输出: 4
解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
 * @author liang
 *
 */
public class HouseRobber2_213 {

	/**
	 * HouseRobber_198不用构成环
	 * 这里的关键就是最后那一个房间N和第一个房间相连了，可以这么进行转化：
	 * 考虑抢劫了第0个房间，那么问题就是求抢劫第0~N-1个房间的最大数。
	 * 考虑不抢劫第0个房间，那么问题就是求抢劫第1~N个房间的最大数。
	 * 上面转化后的两个问题就是House Robber I中的问题。再求上面两个解的最大值，就是本题的解。
	 * @param nums
	 * @return
	 */
    public int rob(int[] nums) {
        if(nums.length == 0)
        	return 0;
        if(nums.length == 1)
        	return nums[0];
        return Math.max(robber(nums,0,nums.length -1), robber(nums,1,nums.length));
    }
    /**
     * 找最大值
     * @param nums
     * @param start
     * @param end
     * @return
     */
	private int robber(int[] nums, int start, int end) {
		int per = 0,cur = 0;
		for(int i = start;i<end;i++) {
			int num = Math.max(cur, per+nums[i]);
			per = cur;
			cur = num;
		}
		return cur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
