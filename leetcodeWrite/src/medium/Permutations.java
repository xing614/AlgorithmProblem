package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 46. 全排列
 * 
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * @author liang
 *
 */
public class Permutations {
	/**
	 * DFS 每次交换num里面的两个数字，经过递归可以生成所有的排列情况
	 * @param nums
	 * @return
	 */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(nums,0,res);
        return res;
    }
    
    
    
	private static void dfs(int[] nums, int start, List<List<Integer>> res) {
		// TODO Auto-generated method stub
		if(start==nums.length) {
			List<Integer> te = new ArrayList<Integer>();
			for(int num:nums) {
				te.add(num);
			}
			res.add(te);
		}
		for(int i=start;i<nums.length;i++) {
			swap(nums,start,i);
			dfs(nums,start+1,res);//这里是start+1,进入当前层的下一层
			swap(nums,start,i);
		}
	}



	private static void swap(int[] nums, int start, int i) {
		// TODO Auto-generated method stub
		int temp = nums[i];
		nums[i] = nums[start];
		nums[start] = temp;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		permute(nums);
	}

}
