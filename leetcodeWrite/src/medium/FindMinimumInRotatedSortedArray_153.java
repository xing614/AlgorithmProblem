package medium;
/**
 * 153. 寻找旋转排序数组中的最小值
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0
 * @author liang
 *
 */
public class FindMinimumInRotatedSortedArray_153 {

	/**
	 * 想考验二分查找
	 * @param nums
	 * @return
	 */
    public int findMin(int[] nums) {
        int i=0,j=nums.length-1,mid;
        while(i<j)
        {
            mid = i+(j-i)/2;
            if (nums[mid]>nums[j])
                i = mid+1;
            else j= mid;
        }
        return nums[j];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
