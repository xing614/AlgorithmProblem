package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * @author liang
 *
 */
public class Subsets2_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res, nums, list, 0);
    	return res;
    }
	private void backtracking(List<List<Integer>> result, int[] nums, List<Integer> list, int start) {
		// TODO Auto-generated method stub
		result.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]) continue;//跳过重复的
            list.add(nums[i]);
            backtracking(result, nums, list, i+1);
            list.remove(list.size()-1);
             
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
