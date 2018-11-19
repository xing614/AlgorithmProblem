package medium;
/**
 * 713.乘积小于K的子数组
 * 给定一个正整数数组 nums。

找出该数组内乘积小于 k 的连续的子数组的个数。

示例 1:

输入: nums = [10,5,2,6], k = 100
输出: 8
解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
说明:

0 < nums.length <= 50000
0 < nums[i] < 1000
0 <= k < 10^6
 * @author liang
 *
 */
public class SubarrayProductLessThanK_713 {

	/**
	 * 使用滑动窗口的方法，维护一个乘积小于k的窗口，窗口大小等于该窗口内子数组的数量
	 * 
	 * 1.如果当前窗口乘积小于k，记录当前窗口大小，右边界则向右滑动一格，
	 * 2.如果乘积大于等于k，先将左边第一格的数除掉，左边窗口向右滑动一格。
	 * @param nums
	 * @param k
	 * @return
	 */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
        	return 0;
        int left = 0, count = 0, pro = 1;
        for(int right = 0;right<nums.length;right++) {
        	pro *= nums[right];
        	while(pro>=k) {
        		pro/=nums[left];
        		left++;
        	}
        	count+=right-left+1;
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
