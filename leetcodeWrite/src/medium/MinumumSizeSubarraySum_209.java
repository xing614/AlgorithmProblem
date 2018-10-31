package medium;
/**
 * 209. 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

示例: 

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * @author liang
 *
 */
public class MinumumSizeSubarraySum_209 {


	/**
	 * 两个指针维护一个窗口
	 * @param s
	 * @param nums
	 * @return
	 */
    public int minSubArrayLen(int s, int[] nums) {
		int l = 0,r = -1;
		int sum = 0;//窗口内的和
		int res = nums.length+1;//返回值
		while(l<nums.length) {
			if(r+1<nums.length && sum<s) {//小于
				sum += nums[++r];
			}else {//r到头了
				sum -= nums[l++];//l会一直往右移
			}
			if(sum>=s)
				res = Math.min(res, r-l+1);
		}
		
		if (res == nums.length + 1)
            return 0;
 
        return res;

		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
