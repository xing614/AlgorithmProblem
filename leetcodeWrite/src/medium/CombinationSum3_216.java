package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
 * @author liang
 *
 */
public class CombinationSum3_216 {

	/**
	 * dfs
	 * @param k
	 * @param n
	 * @return
	 */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        dfs(res,tmp,k,n,1);
        return res;
    }
    
	private void dfs(List<List<Integer>> res, List<Integer> tmp, int k, int n, int start) {
		if(tmp.size() == k) {
			if(sum(tmp) == n) {
				res.add(new ArrayList<Integer>(tmp));
			}
		}
		for(int i=start;i<10;i++) {
			tmp.add(i);
			dfs(res,tmp,k,n,i+1);
			tmp.remove(tmp.size()-1);
		}
	}

	private int sum(List<Integer> tmp) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i =0;i<tmp.size();i++)
			sum += tmp.get(i);
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
