package medium;
/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * @author liang
 *
 */
public class JumpGame {

	/**
	 * 动态规划
	 * 局部解就是i + nums[i]，全局解就是最大的局部解。每次遍历开始先判断能不能走到这一步
 		也就是（glo >= i）？，不符合的话直接break，因为如果能到达最后，肯定前边的都能到达。
 		最后比较glo和nums.length-1的大小。
 		注意遍历的最终点事nums.length-2,数组的最后一个元素是不遍历的。
	 * @param nums
	 * @return
	 */
    public static boolean canJump(int[] nums) {
        if(nums.length == 1){
        	return true;
        }
        int loc = 0;//局部解
        int glo = 0;//当前能走到的位置  全局解
        boolean res = false;
        for(int i=0;i<nums.length-1;i++) {
        	if(glo<i) {//说明从之前那个位置走到的最大位置比i小
        		break;
        	}
        	loc = i+nums[i];
        	glo = Math.max(loc, glo);
        }
        if(glo>=nums.length-1) {
        	res = true;
        }
        return res;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{2,3,1,1,4};
        System.out.println(canJump(nums));
	}

}
