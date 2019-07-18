package medium;

import java.util.List;

/**
 * 两种方法  dfs和动态规划
 * 这是典型的动态规划问题
 */

/**
 * 139. 单词拆分
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 * @author liang
 *
 */
public class WordBreak_139 {
	/**
	 * dfs，使用一个二维数组维护，该数组保存字符串从i到j的子串在字典中是否有，有就为true
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public static boolean wordBreak(String s,List<String> wordDict) {
		int n = s.length();
		boolean[][] mtru = new boolean[n+1][n+1];
		return dfs(s,0,wordDict,mtru);
		
	}
	/**
	 * 
	 * @param s 原串
	 * @param i 从第i个位置开始判断是否存在
	 * @param wordDict
	 * @param mtru 保存子串是否存在
	 * @return
	 */
	private static boolean dfs(String s, int i, List<String> wordDict, boolean[][] mtru) {
		if(s == null ||s.length() == 0 ||i>=s.length()) {//s为空 或者 i到头了
			return true;
		}
		int n = s.length();
		for(int j =i+1;j<=n;j++) {//从每个i开头开始到j搜索是否包含，包含换下一个开头，不包含j++
			if(mtru[i][j]) {//如果i到j子串包含 ，则dfs从j开始
				return dfs(s,j,wordDict,mtru);
			}
			if(wordDict.contains(s.substring(i, j))) {//包含
				mtru[i][j] = true;
				if(dfs(s,j,wordDict,mtru)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 动态规划解答 dp
	 * 定义一个数组mtru[]为s字符串0-i子串是否可以被字典分解
	 * 当s[0,i]在字典中时，mtru[i]=true;
	 * 当mtru[k]==true且s[k+1,i]在字典里，mtru[i]=true
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public  static boolean wordBreak2(String s,List<String> wordDict) {
		int n = s.length();
		boolean[] mtru = new boolean[n];//用于保存s子串从0到i是否可以被字典完美划分
		for(int i = 0;i<n;i++) {
			if(wordDict.contains(s.substring(0, i+1))) {//第一个为true的条件
				mtru[i] = true;
				continue;
			}
			for(int j=0;j<i;j++) {
				if(mtru[j] && wordDict.contains(s.substring(j+1,i+1))) {//第二个为true的条件
					mtru[i] = true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] mtru = new boolean[1][1];
		System.out.println(mtru[0][0]);
	}

}
