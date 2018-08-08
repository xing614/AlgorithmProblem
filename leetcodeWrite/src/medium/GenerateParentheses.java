package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 * @author liang
 *
 */
public class GenerateParentheses {
	
	/**
	 * 二叉树，递归
	 * 二叉树表现形式是所有左分支就添加左括号，右分支添加右括号
	 * 最多可以添加n个左括号，在递归调用的时候，在能传递到最底层的共用字符串中先添加”(“，然后left-1，递归调用就可以。
	 * 当左括号个数大于右括号的个数时添加右括号
	 * 先加左括号还是右括号无所谓
	 * @param n
	 * @return
	 */
    public List<String> generateParenthesis(int n) {
    	List<String> res = new ArrayList<String>();
        if(n==0)
        	return res;
        dfs(n,n,"",res);
		return res;
    }
    /**
     * 如果Left和right都为0，表示所有括号使用完，生成字符串
     * 
     * @param left 表示左括号还有几个
     * @param right 表示右括号还有几个
     * @param tmp
     * @param res
     */
	private void dfs(int left, int right, String tmp, List<String> res) {
		// TODO Auto-generated method stub
		if(left==0 && right==0) {
			res.add(tmp);
		}
		else if(left>0)
			dfs(left-1,right,tmp+'(',res);
		if(left<right)
			dfs(left,right-1,tmp+')',res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
