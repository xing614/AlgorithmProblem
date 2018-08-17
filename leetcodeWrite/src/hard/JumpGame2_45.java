package hard;
/**
 * 45. 跳跃游戏 II
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。
 * @author liang
 *
 */
public class JumpGame2_45 {
	/**
	 * 贪心算法，贪心策略是每步前进的地方是下一步能达到的地方最远。
	 * 在每一步可走步长内，走最大前进的步数
	 * @param nums
	 * @return
	 */
    public int jump(int[] nums) {
        if(nums.length<=1) {
        	return 0;
        }
        int index,max = 0;//index为当前位置可走最大范围内的  下一个可走最远的位置索引；max是可走最大值
        int step = 0;//返回值，走的步数
        int i = 0;//当前位置
        while(i<nums.length) {
        	//当前位置可走的最远位置超过了数组长度，直接步数+1结束
        	if(i+nums[i]>=nums.length-1) {
        		step++;
        		break;
        	}
        	max = 0;//每次都初始化最长距离
        	index = i+1;//记录索引，最少前进1步
        	for(int j = i+1;j-i<=nums[i];j++) {//就是说j在[i+1,i+nums[i]]范围内遍历找可走最远距离的位置坐标索引
        		if(max<j+nums[j]) {
        			max = j+nums[j];
        			index = j;
        		}
        	}
        	i = index;//直接走到能走最远的那步
        	step++;//步长+1
        }
        return step;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
