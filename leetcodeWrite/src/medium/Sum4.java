package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 * @author liang
 *
 */
public class Sum4 {
	
	
	/**
	 * 最初方法，先设定i j 然后left和right
	 * @param nums
	 * @param target
	 * @return
	 */
	public  List<List<Integer>> fourSum2(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length-3;i++) {
			for(int j=i+1;j<nums.length-2;j++) {
				if(j>i+1 && nums[j]==nums[j-1]) {
					continue;
				}
				int left=j+1;
				int right= nums.length-1;
				while(left<right) {
					int sum = nums[i]+nums[j]+nums[left]+nums[right];
					if(sum == target) {
						List<Integer> out = new ArrayList<Integer>();
						out.add(nums[i]);
						out.add(nums[j]);
						out.add(nums[left]);
						out.add(nums[right]);
						res.add(out);
						left++;
						right--;
					}
					else if(sum<target)
						left++;
					else 
						right--;
				}
			}
		}
		return res;
		
	}
	
	
	/**
	 * 可以使用深度遍历 而不是用先排序后选俩数字遍历的方法，但是这种方法容易超出时间限制
	 * 
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	Arrays.sort(nums);
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	dfs(res,new ArrayList<Integer>(),nums,0,target);
		return res;


    }
    /**
     * 
     * @param res
     * @param condidate 已经选定的元素
     * @param nums
     * @param curIndex 当前位置
     * @param target
     */
	private void dfs(List<List<Integer>> res, ArrayList<Integer> condidate, int[] nums, int curIndex, int target) {
		// TODO Auto-generated method stub
		
		//四数之和就是4  五叔之和就是5
		if(condidate.size() == 4) {
			int total = getSum(condidate);
			if(total == target) {
				res.add(new ArrayList<>(condidate));
			}
			return;
		}
		//遍历完了
		if(curIndex>nums.length-1) {
			return;
		}
		for(int i = curIndex;i<nums.length;i++) {
			if(i!=curIndex && nums[i]==nums[i-1]) {
				continue;// 如果是一样的数字，直接忽略，否则会有重复的答案
			}
			condidate.add(nums[i]);
			// 如果已经大于target，并且当前数字大于0，再循环加下去已经没有意义了，因为只会更大，直接return
			if(getSum(condidate)>target && nums[i]>0) {
				if (!condidate.isEmpty()) {
					condidate.remove(condidate.size() - 1);
				}
				return;
			}
			
			dfs(res,condidate,nums,i+1,target);//深度
			if (!condidate.isEmpty()) {//深度之后去掉最后一个
				condidate.remove(condidate.size() - 1);
			}
		}
	}
	
	/**
	 * 返回已选定元素的和
	 * @param condidate
	 * @return
	 */
	private int getSum(ArrayList<Integer> condidate) {
		int total = 0;
		for (Integer num : condidate) {
			total += num;
		}
		return total;
	}
	
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
