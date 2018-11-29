package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
说明:

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 * @author liang
 *
 */
public class IncreasingSubsequences_491 {

	/**
	 * 递归dfs
	 * 用递归的方式暴力搜索。从当前节点起往后找比自己大的点，找到了，就存起来，然后进入下一层递归。
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        Set<List<Integer>> ans = new HashSet<List<Integer>>();//防止添加的子序列是重复的
        dfs(nums,0,ans,list);
        return (new ArrayList(ans));
    }
    
	private void dfs(int[] nums, int start, Set<List<Integer>> ans, List<Integer> list) {
		// TODO Auto-generated method stub
		for(int i = start;i<nums.length;i++) {
			if(list.size() == 0 || list.get(list.size()-1)<=nums[i]) {
				list.add(nums[i]);
				if(list.size()>=2)
					ans.add(new ArrayList(list));//new保证每次存入的arraylist不受之后修改影响
				dfs(nums,i+1,ans,list);
				list.remove(list.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
