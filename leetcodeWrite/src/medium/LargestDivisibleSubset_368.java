package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368.最大整除子集
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
如果有多个目标子集，返回其中任何一个均可。
示例 1:

输入: [1,2,3]
输出: [1,2] (当然, [1,3] 也正确)
示例 2:

输入: [1,2,4,8]
输出: [1,2,4,8]
 * @author liang
 *
 */
public class LargestDivisibleSubset_368 {

	/**
	 * 对于目前的位置i，在数组排序之后，需要遍历1~i的各个位置：因为有可能有“多串"subset,需要取出的是最大的。如果当前i位置的元素%j位置的元素为0，说明dp[i] = dp[j] + 1；否则dp[i] = 1，开始新的一个子集。
	 * 同时需要更新我们的位置数组，last[i] = j，说明i位置的上一个位置为j；如果不满足关系，last[i] = -1，说明这就是第一个元素了。
	 * @param nums
	 * @return
	 */
    public List<Integer> largestDivisibleSubset(int[] nums) {
       if(nums == null || nums.length == 0)
    	   return new ArrayList<>();
       Arrays.sort(nums);
       int n = nums.length;
       int[] dp = new int[n];//用于保存当前位置以前的串最长多有场
       int[] last = new int[n];//保存当前位置的前一个匹配位置
       int max = 0;
       int idx = 0;
       for(int i=0;i<n;i++) {
    	   dp[i] = 1;
    	   last[i] = -1;
    	   for(int j=0;j<i;j++) {
    		   if(nums[i] % nums[j] == 0 && dp[j] +1>dp[i]) {//j匹配i位置
    			   dp[i] = dp[j] +1;
    			   last[i] = j;
    		   }
    	   }
    	   if(max <dp[i]) {
    		   max =dp[i];
    		   idx = i;
    	   }
       }
       List<Integer> res = new ArrayList<>();
       do {
    	   res.add(nums[idx]);
    	   idx = last[idx];//它的前一个元素
       }while(idx !=-1);
       return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
