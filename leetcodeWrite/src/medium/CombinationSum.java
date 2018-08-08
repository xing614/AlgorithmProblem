package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 * @author liang
 *
 */
public class CombinationSum {

	/**
	 * 回溯法
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	dfs(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }
    /**
     * 
     * @param candidates
     * @param target 目标数。回溯法没走入一层。该值或加或减该层的数，往下走就减，往回走就加
     * @param index dfs到第i个位置，就是第几层
     * @param temp 用于保存回溯用的数据
     * @param res
     */
	private static void dfs(int[] candidates, int target, int ind, ArrayList<Integer> temp, List<List<Integer>> res) {
		// TODO Auto-generated method stub
		if(target==0) {
			res.add(new ArrayList<Integer>(temp));		
			return ;
		}
		if(target<0) {
			return;
		}
		for(int i =ind;i<candidates.length;i++) {
			if(candidates[i] > target) return;
			temp.add(candidates[i]);
			dfs(candidates,target-candidates[i],i,temp,res);
			temp.remove(temp.size()-1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = {2,3,6,7};
		combinationSum(i,7);
	}

}
