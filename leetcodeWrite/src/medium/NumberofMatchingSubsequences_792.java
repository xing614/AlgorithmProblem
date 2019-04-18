package medium;

import java.util.Arrays;

/**
 * 792. 匹配子序列的单词数
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。

示例:
输入: 
S = "abcde"
words = ["a", "bb", "acd", "ace"]
输出: 3
解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
注意:

所有在words和 S 里的单词都只由小写字母组成。
S 的长度在 [1, 50000]。
words 的长度在 [1, 5000]。
words[i]的长度在[1, 50]。
 * @author liang
 *
 */
public class NumberofMatchingSubsequences_792 {

	//建立dp[i]['a' ~ 'z']表示在S[i]这个位置后，最先出现’a’ ~ ‘z’的下标
    public static int numMatchingSubseq(String S, String[] words) {
        int sLen = S.length();
        int[][] dp = new int[sLen+1][26];
        for(int i=0;i<sLen+1;i++)
        	Arrays.fill(dp[i], -1);
        for(int i=sLen-1;i>=0;i--)//在0位置最先出现 abc~z的位置
        	dp[0][S.charAt(i) - 'a'] = i+1;
        //保存每个位置的值
        for(int i=sLen-2;i>=0;i--) {
        	for(int j=0;j<26;j++) {
        		dp[i+1][j] = dp[i+2][j];
        	}
        	dp[i+1][S.charAt(i+1)-'a']=i+2;//只有新增的这个位置改变了某个字符的起始点
        }   
        int count = 0;
        for(String word:words) {
        	boolean ok = true;
        	int prv = 0;//当前字符扫描点
        	for(int j=0;j<word.length();j++) {
        		int next = dp[prv][word.charAt(j)-'a'];//可以知道的下一个起始位置
        		if(next!=-1) {
        			prv = next;
        		}
        		else ok = false;
        	}
        	if(ok)
        		count++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"a", "bb", "acd", "ace"};
		System.out.println(NumberofMatchingSubsequences_792.numMatchingSubseq("abcde", words));
	}

}
