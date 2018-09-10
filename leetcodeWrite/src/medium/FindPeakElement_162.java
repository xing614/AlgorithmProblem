package medium;
/**
 * 162. 寻找峰值
题目描述提示帮助提交记录社区讨论阅读解答
峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞。

示例 1:

输入: nums = [1,2,3,1]
输出: 2
解释: 3 是峰值元素，你的函数应该返回其索引 2。
示例 2:

输入: nums = [1,2,1,3,5,6,4]
输出: 1 或 5 
解释: 你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
说明:

你的解法应该是 O(logN) 时间复杂度的。
 * @author liang
 *
 */
public class FindPeakElement_162 {

	/**
	 * O(logN)表示不能完全遍历
	 * 又因为只需要找到其中的一个峰值，那么，每次对半分，便可以达到logn的复杂度
	 * 1，A[i] > A[i+1] & A[i] < A[i-1] ,此时，峰值只能在A[i-1] 左边。
	 * 2，A[i] < A[i+1] & A[i] > A[i-1]，此时，峰值只能在A[i+1]右边。 
	 * 3，A[i] > A[i-1]&A[i] > A[i+1] ，此时求得峰值。
	 * @param nums
	 * @return
	 */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if(right == 0)
        	return 0;
        while(left<right-1) {
        	int mid = (left+right)/2;
        	if(nums[mid]<nums[mid+1]) {//上升
        		left = mid +1 ;
        	}else {
        		right = mid;
        	}
        }
        return nums[left]>nums[right]?left:right;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
