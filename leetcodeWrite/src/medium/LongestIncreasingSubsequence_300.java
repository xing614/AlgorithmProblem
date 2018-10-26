package medium;

import java.util.TreeSet;

/**
 * 300. 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * @author liang
 *
 */
public class LongestIncreasingSubsequence_300 {

	/**
	 * 是相对最长上升子序列
	 * 方法一 ：n^2
	 * 动态规划
	 * 建立一个大小与 nums 长度相等的数组 maxLens，用于记录每个 nums 最长长度，
	 * 即 maxLens[i] 表示nums 第 0 个到第 i 个元素中以 nums[i]为最大值的最长子序列长度（注意序列的最后一个值为 nums[i]）
	 * @param nums
	 * @return
	 */
    public int lengthOfLIS(int[] nums) {
    	int[] maxLens = new int[nums.length];
    	int maxLen = 0;
    	//二层遍历j->i
    	for(int i=0;i<nums.length;i++) {
    		for(int j=0;j<i;j++) {
    			if(nums[i]>nums[j]) {
    				maxLens[i] = Math.max(maxLens[j]+1, maxLens[i]);
    			}
    		}
    		maxLen = Math.max(maxLen, maxLens[i]+1);
    	}
    	return maxLen;
    }
    /**
     * 方法二：二分查找 nlogn
     * 立一个 maxLens 数组，这个数组和上一种思路的数组不同。
     * 上一种思路 maxLens[i] 的值代表 nums 中第0个到第 i 个元素以 nums[i] 为最大值的最大递增序列长度。
     * 而这种思路的 maxLens[i] 代表 nums 中第0个到第 i  个元素最大长度为 i 的最小值是多少（注意最小值是 nums数组中的某个数）
     * [10,9,2,5,3,7,101,18]
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
    	int[] maxLens = new int[nums.length+1];
    	int maxLen = 0;
    	for(int num:nums) {
    		int len = binarySearch(num,maxLen,maxLens);//查询当前位置num是哪个长度的最小值
    		maxLen = Math.max(len, maxLen);
    		maxLens[len] = num;
//    		System.out.println(len);
    	}
    	for(int i=0;i<maxLens.length;i++) {
    		System.out.println(maxLens[i]);
    	}
    	return maxLen;
    }
    /**
     * 二分查找
     * @param num  当前位置数据
     * @param maxLen  当前最长长度
     * @param maxLens  maxLens[i] 代表 nums 中第0个到第 i个元素最大长度为 i 的最小值是多少
     * @return
     */
	private static int binarySearch(int num, int maxLen, int[] maxLens) {
		int left = 1,right = maxLen;
		while(left<=right) {
			int mid = left+(right-left)/2;
			if(maxLens[mid]<num) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return left;
	}
	/**
	 * 借用 TreeSet类实现
	 * [10,9,2,5,3,7,101,18]
	 * +10 -10 +9 -9 +2 +5 -5 +3 +7 +101 -101 +18
	 * 每次去掉大于当前数的
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS3(int[] nums) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int num:nums) {
			Integer ceil = set.ceiling(num);//返回至少元素大于或等于e或null
			if(ceil !=null)
				set.remove(ceil);
			set.add(num);
			
		}
		return set.size();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {10,9,2,5,3,7,101,18};
		lengthOfLIS2(num);
	}

}
