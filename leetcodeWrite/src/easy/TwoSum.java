package easy;

import java.util.HashMap;
/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
	你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
	
	给定 nums = [2, 7, 11, 15], target = 9
	因为 nums[0] + nums[1] = 2 + 7 = 9
	所以返回 [0, 1]
	
 * @param nums
 * @param target
 * @return
 */
public class TwoSum {

	/**
	 * 二次循环直接暴力破解
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int[] twoSum0(int[] nums, int target) {
    	int[] result = new int[2];
    	for(int i=0;i<nums.length;i++) {
    		for(int j=i+1;i<nums.length;i++) {
    			if(nums[i]+nums[j]==target) {
    				result[0] = i;
    				result[1] = j;
    			}
    		}
    	}
    	return result;
    }
	
	/**
	 * 先将整数数组值放入map中，key为值，value为数组下标
	 * 在map中找到target-nums[i]的值，如果找到了且这个值的下标不是i，就算找到了
	 * @param nums 整数数组
	 * @param target 目标答案
	 * @return  和为目标值的两个数
	 */
    public static int[] twoSum(int[] nums, int target) {
    	HashMap<Integer,Integer> hm = new HashMap();
    	int[] result = new int[2];
    	for(int i=0;i<nums.length;i++) {
    		hm.put(nums[i], i);
    	}
    	for(int i=0;i<nums.length;i++) {
    		int second = target - nums[i]; 
    		if(hm.containsKey(second)&& hm.get(second) != i) {
    			result[0] = i;
    			result[1] = hm.get(second);
    		}
    	}
		return result;
    }
    
    /**
     * 解法2，一次循环直接判断
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] var = {2,7,11,15};
		int[] result = twoSum(var,9);
		System.out.println(result[0]+" "+result[1]);
	}

}
