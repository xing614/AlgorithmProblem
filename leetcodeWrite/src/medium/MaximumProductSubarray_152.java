package medium;
/**
 * 152. 乘积最大子序列
给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * @author liang
 *
 */
public class MaximumProductSubarray_152 {

	/**
	 * 简单动态规划， 递推公式 
	 * 对于Product Subarray，要考虑到一种特殊情况，即负数和负数相乘： 
	 * 如果前面得到一个较小的负数，和后面一个较大的负数相乘，得到的反而是一个较大的数，如{2，-3，-7}， 
	 * 所以，我们在处理乘法的时候，除了需要维护一个局部最大值，同时还要维护一个局部最小值 
	 * n<1说明输入有错，n大于0时 
	 * Fmax(0)=num[0] 
	 * Fmin(0)=num[0] 
	 * Fmax(n+1) = MAX(MAX(num[n+1]*Fmax(n), num[n+1]), num[n+1]*Fmin(n)) // 最大值 
	 * Fmin(n+1) = MIN(MIN(num[n+1]*Fmax(n), num[n+1]), num[n+1]*Fmin(n)) // 最小值，为下一个新计算
	 * @param nums
	 * @return
	 */
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length <1)
        	throw new IllegalArgumentException();
        if(nums.length == 1)
        	return nums[0];
        int result = nums[0];
        int fMax = nums[0];
        int fMin = nums[0];
        int prevMax;
        for(int i=1;i<nums.length;i++) {
        	prevMax = fMax;
        	fMax = Math.max(Math.max(nums[i]*prevMax, nums[i]), nums[i]*fMin);
        	fMin = Math.min(Math.min(nums[i]*prevMax, nums[i]), nums[i]*fMin);
        	result = Math.max(result, fMax);
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
