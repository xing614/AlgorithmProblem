package medium;
/**
 * 334.递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

数学表达式如下:

如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。

示例 1:

输入: [1,2,3,4,5]
输出: true
示例 2:

输入: [5,4,3,2,1]
输出: false
 * @author liang
 *
 */
public class IncreasingTripletSubsequence_334 {

	/**
	 * 遍历更新最小的数和次小的数，如果某个数大于这两个数，则有三个数递增，返回true.
	 * @param nums
	 * @return
	 */
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3)
        	return false;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]<=firstMin) {
        		firstMin = nums[i];
        	}else if(nums[i]<=secondMin) {
        		secondMin = nums[i];
        	}else {
        		return true;
        	}
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}