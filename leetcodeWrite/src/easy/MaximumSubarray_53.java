package easy;
/**
 * 53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
 * @author liang
 *
 */
public class MaximumSubarray_53 {

	/**
	 * 方法一，O（n）
	 * 定义两个变量res和curSum，
	 * 其中res保存最终要返回的结果，即最大的子数组之和，curSum初始值为0，
	 * 每遍历一个数字num，比较curSum + num和num中的较大值存入curSum，
	 * 然后再把res和curSum中的较大值存入res，
	 * 以此类推直到遍历完整个数组，可得到最大子数组的值存在res中
	 * @param nums
	 * @return
	 */
    public int maxSubArray(int[] nums) {
    	int res = Integer.MIN_VALUE;
    	int curSum = 0;
    	for (int num : nums) {
            curSum = Math.max(curSum + num, num);//-2,1,-2,4,3,5,6,1,5  每次取大的那个
            res = Math.max(res, curSum);
        }
        return res;
    }
 
    /**
     * 分治法类似于二分搜索法，O（nlogn）
     * 把数组一分为二，分别找出左边和右边的最大子数组之和，
     * 然后还要从中间开始向左右分别扫描，求出的最大值分别和左右两边得出的最大值相比较取最大的那一个
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
    	if(nums.length==0) return 0;
    	return help(nums,0,nums.length-1);
    }
    
	private int help(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
        if (left >= right) return nums[left];
        int mid = left + (right - left) / 2;
        int lmax = help(nums, left, mid - 1);
        int rmax = help(nums, mid + 1, right);
        int mmax = nums[mid], t = mmax;
        for (int i = mid - 1; i >= left; --i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        t = mmax;
        for (int i = mid + 1; i <= right; ++i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
