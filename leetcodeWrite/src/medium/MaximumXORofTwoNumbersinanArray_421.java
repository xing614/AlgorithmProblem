package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. 数组中两个数的最大异或值
 * 
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。

找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。

你能在O(n)的时间解决这个问题吗？

示例:

输入: [3, 10, 5, 25, 2, 8]

输出: 28

解释: 最大的结果是 5 ^ 25 = 28.
 * @author liang
 *
 */
public class MaximumXORofTwoNumbersinanArray_421 {

	/**
	 * 利用XOR的性质，a^b = c, 则有 a^c = b，且 b^c = a;
	 * 所以每次从高位开始，到某一位为止，所能获得的最大的数为mask（如从1000->1100->1110->1111）。每一次将mask和其他的num相与得到的值加入set，表示从最高位到当前这一位上，数组里有这么多prefix（如当mask为1110，set中最多可能出现以下的数1110,1100,1000,1010）
	 * 
	 * 假定在某一位上的任意两数xor能得到的最大值是tmp,那么他一定满足a(xor)b = tmp,其中set.contains(a) && set.contains(b). 所以，我们只需要判断b(xor)tmp的结果是不是在当前这一位下的set内，就可以知道这个tmp能不能又这个set中的任意两个数组成。
	 * @param nums
	 * @return
	 */
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        
        for(int i=31;i>=0;i--) {
        	// 每次都在之前的基础上更新mask
        	mask = mask | (1<<i);//就是再高一位变为1
        	Set<Integer> set = new HashSet<>();
        	for(int num : nums) {
        		set.add(num & mask);
        	}
        	
        	//假设当前所能达到的最大值是这个temp值
        	int tmp = max | (1<<i);
        	for(Integer prefix : set) {
        		//表示set中存在两个说 XOR后是最大值 tmp
        		if(set.contains(prefix ^ tmp)) {
        			// 如果能组成就直接break
        			max = tmp;
        			break;
        		}
        	}
        }
        return max;
    }
    
}
