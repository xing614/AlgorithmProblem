package medium;

import java.util.Arrays;

/**
 * 260. 只出现一次的数字 III
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

示例 :

输入: [1,2,1,3,2,5]
输出: [3,5]
注意：

结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * @author liang
 *
 */
public class SingleNumber3_260 {

	/**
	 * 先排序，创建有2个元素的数组，对源数组判断相邻元素是否相同
	 * @param nums
	 * @return
	 */
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] array = new int[2];
        int count =0;
        for(int i=0;i<nums.length-1;i+=2) {
        	if(nums[i]!=nums[i+1]) {//不等
        		array[count++] = nums[i];//插入
        		i-=1;//后移一位，再前进两位，就是找到下一个不等的
        	}	
        }
        if(count == 1) {
        	array[1] = nums[nums.length-1];
        }
        return array;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
