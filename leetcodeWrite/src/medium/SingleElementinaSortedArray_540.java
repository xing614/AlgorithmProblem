package medium;
/**
 * 540. 有序数组中的单一元素
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。

示例 1:

输入: [1,1,2,3,3,4,4,8,8]
输出: 2
示例 2:

输入: [3,3,7,7,10,11,11]
输出: 10
注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 * @author liang
 *
 */
public class SingleElementinaSortedArray_540 {
	/**
	 * 二分查找，判断该位置是否与前后都不同，还要依靠当前位置是偶数还是奇数，判断向左还是向右移动
	 * @param nums
	 * @return
	 */
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left<right) {
        	mid = (left+right)/2;
        	//找到了
        	if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) {
        		return nums[mid];
        	}//第一个条件表示mid处在偶数位置 mid之前都是两个两个一样的，单个数字在后面.第二个条件同理
        	else if((nums[mid] == nums[mid+1] && mid%2==0) || (nums[mid] == nums[mid-1] &&mid%2==1)) {
        		left = mid+1;
        	}else {
        		right = mid-1;
        	}
        }
        return nums[left];
    }
}
