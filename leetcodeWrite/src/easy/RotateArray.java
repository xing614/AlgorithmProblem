package easy;
/**
 * 189. 旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的原地算法。
 * @author liang
 *
 */
public class RotateArray {
	/**
	 * 类似RoateList_61
	 * 利用数组的length - k 把数组 分为两半；
	 * reverse 左边和右边的数组；
	 * reverse 总数组。
	 * @param nums
	 * @param k
	 */
    public void rotate(int[] nums, int k) {
        if(nums==null ||nums.length==0||k==0) {
        	return;
        }
        k = k%nums.length;//有可能k大于长度，所以取余
        int reverse = nums.length- k;//断点位置
        //例子 1234567 k=3
        reverse(nums,0,reverse-1);//将0到断点位置内的数据前后对调，0位置数据变到reverse-1位置之类,4321567
        reverse(nums,reverse,nums.length-1);//4321765
        reverse(nums,0,nums.length-1);//5671234
    }
    
	private void reverse(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		while(i<j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
