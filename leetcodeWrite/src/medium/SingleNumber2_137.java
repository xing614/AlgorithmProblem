package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
题目描述提示帮助提交记录社区讨论阅读解答
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,3,2]
输出: 3
示例 2:

输入: [0,1,0,1,0,1,99]
输出: 99
 * @author liang
 *
 */
public class SingleNumber2_137 {
	/**
	 * 使用map存储出现的次数
	 * @param nums
	 * @return
	 */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        int result = 0;
        for(int i=0;i<len;i++) {
        	if(!map.containsKey(nums[i])) {
        		map.put(nums[i], 1);
        	}else {
        		map.put(nums[i], map.get(nums[i])+1);
        	}
        }
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
        	if(entry.getValue()!=3) {
        		result = entry.getKey();
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
