package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 442. 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

找到所有出现两次的元素。

你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

示例：

输入:
[4,3,2,7,8,2,3,1]

输出:
[2,3]	
 * @author liang
 *
 */
public class FindAllDuplicatesInAnArray_442 {

	/**
	 * 每个元素数值都小于n,可以利用它，
	 * 遍历到某个a[i]元素，查看 a[a[i]-1]位置元素，
	 * 如果是正数说明之前a[i]这个数值没有出现过，就把 a[a[i]-1]取反，
	 * 如果是负数说明a[i]这个数值出现过两次，记录它，
	 * @param nums
	 * @return
	 */
    public List<Integer> findDuplicates(int[] nums) {
    	List<Integer> res = new ArrayList<>();
    	for(int i=0;i<nums.length;i++) {
    		int index = Math.abs(nums[i])-1;
    		if(nums[index]<0)//记录
    			res.add(Math.abs(index+1));
    		nums[index] = - nums[index];//取反
    	}
    	return res;
    }
    
}
