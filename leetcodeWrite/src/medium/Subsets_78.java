package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author liang
 *
 */
public class Subsets_78 {

	/**
	 * 回溯法
	 * 基于DFS（深度优先探索）的递归方法。
	 * 原数组中每一个元素在子集中有两种状态：要么存在、要么不存在。
	 * 这样构造子集的过程中每个元素就有两种选择方法：选择、不选择，
	 * 因此可以构造一颗二叉树来表示所有的选择状态：二叉树中的第i+1层第0层无节点表示子集中加入或不加入第i个元素，
	 * 左子树表示加入，右子树表示不加入。所有叶节点即为所求子集。因此可以采用DFS的递归思想求得所有叶节点。
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> subsets(int[] nums) {
    	int len = nums.length;
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	if(len == 0)
    		return res;
    	dfs(nums,tmp,res,0,len);
    	return res;
    }
    //[[],[3],[2],[2,3],[1],[1,3],[1,2],[1,2,3]]
	private void dfs(int[] nums, List<Integer> tmp, List<List<Integer>> res, int level, int len) {
		// TODO Auto-generated method stub
		if(level == len) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
//		for(int i=level;i<=len;i++) {
//			tmp.add(nums[i]);
//			dfs(nums,tmp,res,i+1,len);
//			tmp.remove(tmp.size()-1);
//		}
		dfs(nums,tmp,res,level+1,len);
		tmp.add(nums[level]);
		dfs(nums,tmp,res,level+1,len);
		tmp.remove(tmp.size()-1);
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
