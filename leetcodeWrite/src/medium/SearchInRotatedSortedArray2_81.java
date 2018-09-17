package medium;
/**
 * 81. 搜索旋转排序数组 II
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

示例 1:

输入: nums = [2,5,6,0,0,1,2], target = 0
输出: true
示例 2:

输入: nums = [2,5,6,0,0,1,2], target = 3
输出: false
进阶:

这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * @author liang
 *
 */
public class SearchInRotatedSortedArray2_81 {

	/**
	 * 二分搜索
	 * 当 nums[mid] = nums[left] 时，这时由于很难判断 target 会落在哪，那么只能采取 left++
	 * 当 nums[mid] > nums[left] 时，这时可以分为两种情况，判断左半部比较简单
	 * 当 nums[mid] < nums[left] 时，这时可以分为两种情况，判断右半部比较简单
	 * @param nums
	 * @param target
	 * @return
	 */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) return true;
            if (nums[mid] == nums[left]) left++;
            else if (nums[mid] > nums[left]) {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}