package medium;

import java.util.Arrays;

/**
 * 摆动排序 II
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。

示例 1:

输入: nums = [1, 5, 1, 1, 6, 4]
输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
示例 2:

输入: nums = [1, 3, 2, 2, 3, 1]
输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
说明:
你可以假设所有输入都会得到有效的结果。

进阶:
你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * @author liang
 *
 */
public class WiggleSort2 {
	
	/**
	 * 先进行排序，以中间数为基准，前半段倒序填入奇数下标，后半段倒序填入偶数下标，
	 * 如果有解，则对于排好序的数组，间隔超过n/2的两个元素必不相等。
	 * 时间复杂度O(nlogn)，空间复杂度O(n)。
	 * @param nums
	 */
    public void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int mid = (nums.length-1)/2;
        for(int i=0,j=mid,k=nums.length-1;i<nums.length;i=i+2,j--,k--) {
        	nums[i]=sorted[j];
        	if(i+1<nums.length) nums[i+1]=sorted[k];
        }
    }

    /**
     * 思路2：这个思路有问题，在不重复元素数组情况下可以，但如果是1，1，1，2，3这样时答案不正确，交换没有用
     * 看题定义了：如果i为奇数，则nums[i]>nums[i-1]
     * 如果i为偶数，则nums[i]<nums[i-1]
     * 可以只遍历一次数组，将不符合情况的交换一下即可
     * O（n）
     * @param nums
     */
    public static void wiggleSort2(int[] nums) {
    	for(int i=1;i<nums.length;i++) {
    		if( (i%2==1 && nums[i]<nums[i-1]) || (i%2==0 && nums[i]>nums[i-1]) ) {//两个相反的条件
    			int tmp = nums[i-1];
    			nums[i-1] = nums[i];
    			nums[i] = tmp;
    		}
    	}
    	for(int i=0;i<nums.length;i++) {
    		System.out.print(nums[i]);
    	}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tt = {1,2,2,1,2,1,1,1,1,2,2,2};
		wiggleSort2(tt);
	}

}
