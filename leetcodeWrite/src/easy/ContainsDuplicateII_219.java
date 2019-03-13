package easy;

import java.util.HashSet;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false
 * @author liang
 *
 */
public class ContainsDuplicateII_219 {

	/**
	 * 使用set保存  ，滑动窗口 set只保存范围k的数据，如果大于k就剔除左边 ，如果值在set里找到了 说明满足相等 且距离差<k
	 * @param nums
	 * @param k
	 * @return
	 */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
        	if(hs.contains(nums[i])) {//说明存在
        		return true;
        	}
        	hs.add(nums[i]);
        	//控制查找表（窗口）大小，移除窗口最左边元素
        	if(hs.size() == k+1) {
        		hs.remove(nums[i-k]);
        	}
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
