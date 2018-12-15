package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
说明 :

数组的长度为 [1, 20,000]。
数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * @author liang
 *
 */
public class SubarraySumEqualsK_560 {

	/**
	 * sum[i,j] = sum[0,j]-sum[0,i-1]
k = sum - sum[0,i-1]
sum[0,i-1] = sum-k
对于每一个sum来说，前面的子序列中有多少个sum-k结果中就可以构成多少个sum[i,j].
	 * @param nums
	 * @param k
	 * @return
	 */
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<nums.length;i++) {
        	sum+=nums[i];
        	if(map.containsKey(sum-k)) {
        		res+=map.get(sum-k);
        	}
        	map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
