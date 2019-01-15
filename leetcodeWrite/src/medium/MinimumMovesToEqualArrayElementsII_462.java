package medium;

import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。

例如:

输入:
[1,2,3]

输出:
2

说明：
只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）： 

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 
 * @author liang
 *
 */
public class MinimumMovesToEqualArrayElementsII_462 {
	/**
	 * 找到中位数，然后看每个数字与中位数差几
	 * @param nums
	 * @return
	 */
    public int minMoves2(int[] nums) {
    	if(nums == null || nums.length == 0)
    		return 0;
    	Arrays.sort(nums);
    	int median = nums[nums.length/2];
    	int res = 0;
    	
    	for(int i=0;i<nums.length;i++) {
    		res += Math.abs(nums[i] - median);
    	}
    	return res;
    }
    
}
