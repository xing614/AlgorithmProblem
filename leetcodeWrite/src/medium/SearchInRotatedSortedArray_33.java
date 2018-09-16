package medium;
/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
 * @author liang
 *
 */
public class SearchInRotatedSortedArray_33 {

	/**
	 * 可以直接使用二分查找,总结出旋转数组会对首尾指针的移动造成哪些改变
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		if(nums.length == 0 ) return 1;
		int low = 0,high = nums.length;
		while(low !=high) {
			int mid = low+ (high-low)/2;//二分查找中间位置
			if(nums[mid]== target) return mid;
			if(nums[low]<=nums[mid]) {//low数值<mid
				if(nums[low] <= target && target < nums[mid]) //从low 到mid是升序
					high = mid;//接着二分查找
				else low = mid + 1;
			}else {//low的值>mid
				if(target <= nums[high - 1] && nums[mid] < target)//从mid到high是升序
					low = mid + 1;
				else high = mid;
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
