package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 * @author liang
 *
 */
public class CombinationSum2 {
	/**
	 * 回溯法
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
		
		for(int i =ind;i<candidates.length;i++) {
			int ci  = candidates[i];
			if(ci==target) {
				temp.add(ci);
				
				for(Integer attribute : temp) {
					  System.out.print(attribute);
				}
				res.add(new ArrayList<Integer>(temp));
				temp.remove(temp.size()-1);
			}else if(ci<target) {
				temp.add(ci);
				dfs(candidates,target-ci,i+1,temp,res);//这里是i+1 因为不能重复使用
				temp.remove(new Integer(ci));
				while(i < candidates.length-1 && candidates[i] == candidates[i+1]){//检查重复序列
					i++;
				}
			}else {
				break ;
			}
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = {10,1,2,7,6,1,5};
		List<List<Integer>> ls = combinationSum2(i,8);
		Iterator<List<Integer>> iterator = ls.iterator();
		while(iterator.hasNext()) {
			List<Integer> next = iterator.next();
			Iterator<Integer> iterator2 = next.iterator();
			System.out.println("{");
			while(iterator2.hasNext()) {
				System.out.println(iterator2.next());
			}
			System.out.println("}");
		}
	}


}
