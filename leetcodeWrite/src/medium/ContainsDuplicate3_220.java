package medium;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。

示例 1:

输入: nums = [1,2,3,1], k = 3, t = 0
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1, t = 2
输出: true
示例 3:

输入: nums = [1,5,9,1,5,9], k = 2, t = 3
输出: false
 * @author liang
 *
 */
public class ContainsDuplicate3_220 {

	/**
	 * 使用treeset
	 * 维持一个长度为k的window, 每次检查新的值是否与原来窗口中的所有值的差值有小于等于t的. 
	 * 如果用两个for循环会超时O(nk). 
	 * 使用treeset( backed by binary search tree) 的subSet函数,可以快速搜索. 复杂度为 O(n logk)
	 * @param nums
	 * @param k  	   i-j<k
	 * @param t		nums[i]-nums[j]<t
	 * @return
	 */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if(k<1 || t<0 || nums==null || nums.length<2) return false;
    	
    	SortedSet<Long> set = new TreeSet<Long>();
    	for(int j=0;j<nums.length;j++) {
    		//获取nums[j]+/-t内的元素
    		SortedSet<Long> subSet = set.subSet((long)nums[j]-t, (long)nums[j]+t+1);
    		if(!subSet.isEmpty())//说明存在符合条件的元素
    			return true;
    		if(j>=k) {//删除位置在超过范围的元素;//因为元素的坐标差不能超过k，所以在treeSet中最多只能有k个元素
    			set.remove((long)nums[j-k]);
    		}
    		set.add((long)nums[j]);
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
