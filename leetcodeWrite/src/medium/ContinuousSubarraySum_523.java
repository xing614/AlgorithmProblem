package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。

示例 1:

输入: [23,2,4,6,7], k = 6
输出: True
解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
示例 2:

输入: [23,2,6,4,7], k = 6
输出: True
解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
说明:

数组的长度不会超过10,000。
你可以认为所有数字总和在 32 位有符号整数范围内。
 * @author liang
 *
 */
public class ContinuousSubarraySum_523 {

	/**
	 * 遍历数组一个一个加，每次加一个就记录mod k的结果，如果出现两个相同的值，说明这两个位置中间值的和是k的倍数
	 * @param nums
	 * @param k
	 * @return
	 */
    public boolean checkSubarraySum(int[] nums, int k) {
    	Map<Integer,Integer> map = new HashMap<>();
    	map.put(0, -1);//防止0的问题
        int runSum = 0;
        for(int i =0;i<nums.length;i++) {
        	runSum+=nums[i];
        	if(k!=0)
        		runSum%=k;
        	if(map.containsKey(runSum)) {
        		Integer prev = map.get(runSum);
        		if(i-prev>1)
        			return true;
        	}
        	else {
        		map.put(runSum, i);
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContinuousSubarraySum_523 cc = new ContinuousSubarraySum_523();
		int[] a = new int[] {0,0};
		System.out.println(cc.checkSubarraySum(a,0));
		
	}
}
