package medium;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @author liang
 *
 */
public class Sum3Closest {

	/**
	 * 与Sum3题类似
	 * 先排序，固定一个值，使用left和right指针遍历数组
	 * 维护一个变量diff用于保存差的绝对值
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        int diff = Math.abs(target-closest);
        for(int i=0;i<nums.length-2;i++) {
        	int left = i+1;
        	int right = nums.length-1;
        	while(left<right) {
        		int sum = nums[i]+nums[left]+nums[right];
        		int newDiff = Math.abs(target-sum);
        		System.out.println(left+" "+right+" "+newDiff);
        		if(newDiff<diff) {
        			diff = newDiff;
        			closest = sum;
        		}
        		if(sum<target)//说明当前和小于target，left右移变大
        			left++;
        		else
        			right--;
        	}
        }
        return closest;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-3,-2,-5,3,-4};
		System.out.println(threeSumClosest(nums, -1));
	}

}
