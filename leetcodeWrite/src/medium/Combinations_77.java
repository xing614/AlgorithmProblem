package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author liang
 *
 */
public class Combinations_77 {
	/**
	 * 回溯法
	 * @param n
	 * @param k
	 * @return
	 */
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	dfs(res,tmp,n,k,1);
    	return res;
    }
    
	private void dfs(List<List<Integer>> res, List<Integer> tmp, int n, int k, int start) {
		// TODO Auto-generated method stub
		if(tmp.size() == k) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i=start;i<=n;i++) {
			//i <= (n - (k - tmp.size()) + 1) 剪枝，当可选的数已经不够时，直接剪枝
			tmp.add(i);
			dfs(res,tmp,n,k,i+1);//i+1，别老忘写+1
			tmp.remove(tmp.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
