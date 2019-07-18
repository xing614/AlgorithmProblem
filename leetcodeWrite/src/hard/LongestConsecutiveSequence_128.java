package hard;

import java.util.HashMap;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @author liang
 *
 */
public class LongestConsecutiveSequence_128 {

	/**
	 * 使用哈希表hashMap,key为num value为这个num连续长度  初始为0。在表中设置当前num的值，该value由 value(num-1)+value(num+1)+1。最大值max = max|当前位置的值
	 * @param nums
	 * @return
	 */
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int max = 0;
        for(int num:nums) {
        	if(hm.containsKey(num))
        		continue;
        	int left = hm.containsKey(num-1)?hm.get(num-1):0;
        	int right = hm.containsKey(num+1)?hm.get(num+1):0;
        	int value = left+right+1;
        	max=max>value?max:value;
        	hm.put(num, value);
        	if(left>0)
        		hm.put(num-left, value);
        	if(right>0)
        		hm.put(num+right,value);
        }
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
