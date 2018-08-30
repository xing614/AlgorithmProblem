package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

 * @author liang
 *
 */
public class PalindromePartitioning_131 {

	/**
	 * 回溯法
	 * 从下标0开始遍历字符串，一旦在下标 i 找到回文子字符串，那么就把下标从 0 到 i 的子字符串加入temp中，
	 * 继续从下标 i 接着往下找，一旦curIndex等于字符串长度，那么就把temp加入到result中。
	 * 如果一直到最后都没找到回文子字符串，那么就进行剪枝
	 * @param s
	 * @return
	 */
    public List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	List<String> temp = new ArrayList<String>();//保存每一组答案
    	dfs(s,0,temp,res);
		return null;
        
    }
    
	private void dfs(String s, int curIndex, List<String> temp, List<List<String>> res) {
		// TODO Auto-generated method stub
		if(curIndex == s.length()) {
			res.add(new ArrayList<String>(temp));
			return;
		}
		for(int i=curIndex+1;i<=s.length();i++) {
			String substring = s.substring(curIndex, i);
			if(!isPrlindrome(substring)) {//当前串不是回文串，就剪枝
				continue;
			}
			temp.add(substring);//当前串符合回文串
			dfs(s,i,temp,res);//然后再从i判断
			temp.remove(temp.size()-1);
		}
	}

	private boolean isPrlindrome(String s) {
		int left = 0;
		int right = s.length()-1;
		while(left<right) {
			if(s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
