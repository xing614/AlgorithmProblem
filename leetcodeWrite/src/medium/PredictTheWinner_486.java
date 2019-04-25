package medium;
/**
 * 486. 预测赢家
 * 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。

给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。

示例 1:

输入: [1, 5, 2]
输出: False
解释: 一开始，玩家1可以从1和2中进行选择。
如果他选择2（或者1），那么玩家2可以从1（或者2）和5中进行选择。如果玩家2选择了5，那么玩家1则只剩下1（或者2）可选。
所以，玩家1的最终分数为 1 + 2 = 3，而玩家2为 5。
因此，玩家1永远不会成为赢家，返回 False。
示例 2:

输入: [1, 5, 233, 7]
输出: True
解释: 玩家1一开始选择1。然后玩家2必须从5和7中进行选择。无论玩家2选择了哪个，玩家1都可以选择233。
最终，玩家1（234分）比玩家2（12分）获得更多的分数，所以返回 True，表示玩家1可以成为赢家。
注意:

1 <= 给定的数组长度 <= 20.
数组里所有分数都为非负数且不会大于10000000。
如果最终两个玩家的分数相等，那么玩家1仍为赢家。
 * @author liang
 *
 */
public class PredictTheWinner_486 {

	/**
	 * 两人依次拿，如果Player1赢，则Player1拿的>Player2拿的。我们把Player1拿的视为"+"，把Player2拿的视为"-"，如果最后结果大于等于0则Player1赢。
	 * 因此对于递归来说，beg ~ end的结果为max(nums[beg] - partition(beg + 1, end), nums[end] - partition(beg, end + 1))；对于非递归来说DP[beg][end]表示即为beg ~ end所取的值的大小（最终与零比较）。
	 * @param nums
	 * @return
	 */
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums,0,nums.length-1)>=0;
    }
    
	private int helper(int[] nums, int start, int end) {
		if(start == end)
			return nums[start];
		else
			return Math.max(nums[start]-helper(nums,start+1,end), nums[end]-helper(nums,start,end-1));
	}
	
	/**
	 * 非递归 保存中间结果
	 * 
	 * 使用一个二位的数组dp来表示nums数组中任意开始和结束位置两人结果的差值。
	 * 在dp中赋初始值
	 * @param nums
	 * @return
	 */
	public boolean PredictTheWinner2(int[] nums) {
		if(nums.length==0 || nums == null)
			return false;
		int n = nums.length;
		int[][] dp = new int[n][n];
		for(int i =0;i<n;i++) {
			dp[i][i] = nums[i];
		}
		for(int i = n-2;i>=0;i--) {
			for(int j = i+1;j<n;j++) {
				dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
			}
		}
		return dp[0][n-1] >= 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
