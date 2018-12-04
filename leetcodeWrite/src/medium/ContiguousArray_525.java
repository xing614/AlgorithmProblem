package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组。

示例 1:

输入: [0,1]
输出: 2
说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
示例 2:

输入: [0,1,0]
输出: 2
说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
注意: 给定的二进制数组的长度不会超过50000。
 * @author liang
 *
 */
public class ContiguousArray_525 {

	/**
	 * 将数组中的0变为-1，这样[i,j]的和为0，在map中存储从0~i的和 value为i的值。返回值res = max(res,i-map.get(sum))
	 * @param nums
	 * @return
	 */
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++)
        	if(nums[i]==0)
        		nums[i]=-1;
        int res = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);//用来判断nums为【0，1】的
        for(int i=0;i<nums.length;i++) {
        	sum+=nums[i];
        	if(map.containsKey(sum)) {//当存在重复时，说明这两个位置中间的和为0
        		res = Math.max(res, i-map.get(sum));
        	}else
        		map.put(sum, i);
        }
        return res;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
