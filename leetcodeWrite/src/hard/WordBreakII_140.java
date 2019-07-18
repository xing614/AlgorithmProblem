package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：

分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]
示例 2：

输入:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
输出:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
解释: 注意你可以重复使用字典中的单词。
示例 3：

输入:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
输出:
[]
 * @author liang
 *
 */
public class WordBreakII_140 {

	
	/**
	 * dfs:从start开始 找到符合的字符串就dfs,用一个变量保存当前dfs的用空格拆分的串，直到字符串结尾后保存到res中
	 * @param s
	 * @param wordDict
	 * @return
	 */
    public List<String> wordBreak(String s, List<String> wordDict) {
    	List<String> res = new ArrayList<>();
        if(s.length() == 0 ||s == null) {
        	return res;
        }
        if(checkWord(s,wordDict)) {//检查是否存在符合的拆分方式
        	dfs(s,wordDict,0,"",res);//找到所有拆分方式
        }
        return res;
    }
    /**
     * 
     * @param s
     * @param wordDict
     * @param start   每轮dfs开始的位置
     * @param it  这一次总的dfs之前已经用空格分割好的字符串 
     * @param res
     */
	private void dfs(String s, List<String> wordDict, int start, String it, List<String> res) {
		// TODO Auto-generated method stub
		if(start>=s.length())//dfs到头了 说明 拆分成功  最后it就是结果
			res.add(it);
		StringBuilder sb = new StringBuilder();
		for(int i = start;i<s.length();i++) {
			sb.append(s.charAt(i));
			if(wordDict.contains(sb.toString())) {//如果符合条件，就通过空格 组合这个前部分的子串
				String newItem = new String();
				if(it!="") {
					newItem = it + " "+sb.toString();
				}else {
					newItem = sb.toString();
				}
				dfs(s,wordDict,i+1,newItem,res);
			}
		}
	}

	/**
	 * 动态规划检查 dp[i]表示从0~i是可以被拆分的
	 * @param s
	 * @param wordDict 
	 * @return
	 */
	private boolean checkWord(String s, List<String> wordDict) {
		// TODO Auto-generated method stub
		if(s.length() == 0 || s == null)
			return true;
		boolean[] dp =new boolean[s.length()];
		for(int i=0;i<s.length();i++) {
			if(wordDict.contains(s.substring(0, i+1))) {
				dp[i] = true;
				continue;
			}
			for(int j=0;j<i;j++) {
				if(dp[j] && wordDict.contains(s.substring(j+1,i+1))) {//j位置之前可被拆分 且 j~i位置包含
					dp[i] = true;
				}
			}
		}
		return dp[s.length()-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		WordBreakII_140 ww = new WordBreakII_140();
		System.out.println(ww.wordBreak("catsanddog", wordDict));
	}

}
