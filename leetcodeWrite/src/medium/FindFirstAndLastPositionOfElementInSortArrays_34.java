package medium;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 * @author liang
 *
 */
public class FindFirstAndLastPositionOfElementInSortArrays_34 {
	/**
	 * 思路：二分查找，分别查找最小位置和最大位置，区别就是二分查找时找最小位置就右指针在中位置减一，找最大位置就左指针加一
	 * @param nums
	 * @param target
	 * @return
	 */
    public int[] searchRange(int[] nums, int target) {
        int l = 0;//找最小左指针
        int r = nums.length-1;//找最小右指针
        int low = 0;//找最大左指针
        int high = nums.length-1;//找最大右指针
        int[] n = new int[2];
        n[0] = -1;
        n[1] = -1;
        if(nums.length == 0 ||nums == null) return n;
        while(l<=r) {//找最小位置
        	int mid = l+(r-l)/2;
        	if(nums[mid]==target) {
        		n[0]=mid;
        		r=mid-1;
        	}else if(nums[mid]<target) {
        		l=mid+1;
        	}else {
        		r=mid-1;
        	}
        }
        while(low<=high) {
        	int mid = low+(high-low)/2;
        	if(nums[mid]==target) {
        		n[1]=mid;
        		low = mid+1;
        	}else if(nums[mid]<target) {
        		low = mid+1;
        	}else {
        		high = mid-1;
        	}
        }
        return n;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
