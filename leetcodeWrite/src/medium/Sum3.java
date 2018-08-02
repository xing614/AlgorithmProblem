package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * @author liang
 *
 */
public class Sum3 {

	List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	/**
	 * 普通办法就是三层循环O（n^3）
	 * 
	 * 这里用O(n^2)方法，先讲数组排序，从小到大取first，从剩下的数中取和等于0-first的数即可
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-2;i++) {
    		twoSum(nums,i+1,0-nums[i]);//用于判断有没有两值求和=0-nums[i]
    		while((i<nums.length-2) &&nums[i] == nums[i+1]) {//如果i和i+1相等，则i++往后移
    			i++;
    		}
    	}
		return res;
        
    }
    
    /**
     * 找到两值相加为value的
     * @param nums
     * @param i
     * @param j
     */
	private void twoSum(int[] nums, int start, int value) {
		// TODO Auto-generated method stub
		int left = start;
		int right = nums.length-1;
		while(left<right) {
			if(nums[left]+nums[right] == value) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[start-1]);
				list.add(nums[left]);
				list.add(nums[right]);
				res.add(list);
				while(left<right && nums[left+1] == nums[left])//下一个相等
					left++;
				while(left<right && nums[right-1] == nums[right])
					right--;
				left++;
				right--;
			}
			else if(nums[left]+nums[right] > value) {
				right--;
			}
			else {
				left++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
