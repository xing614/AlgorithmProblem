package medium;
/**
 * 516. 最长回文子序列
 * 定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。

示例 1:
输入:

"bbbab"
输出:

4
一个可能的最长回文子序列为 "bbbb"。

示例 2:
输入:

"cbbd"
输出:

2
一个可能的最长回文子序列为 "bb"。
 * @author liang
 *
 */
public class LongestPalindromicSubsequence_516 {

	/**
	 * 动态规划，dp[i][j]表示字符串i～j下标所构成的子串中最长回文子串的长度，返回dp[0][len-1]
	 * 首先i指针从尾到头遍历，j指针从i指针后面一个元素开始一直遍历到尾部
	 * 一开始dp[i][i]的值都为1，
	 * 如果当前i和j所指元素相等，说明能够加到i～j的回文子串的长度中，所以更新dp[i][j] = dp[i+1][j-1] + 2; 
	 * 如果当前元素不相等，那么说明这两个i、j所指元素对回文串无贡献，则dp[i][j]就是从dp[i+1][j]和dp[i][j-1]中选取较大的 一个值即可
	 * 
	 * @param s
	 * @return
	 */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i =s.length()-1;i>=0;i--) {
        	dp[i][i] = 1;
        	for(int j =i+1;j<s.length();j++) {
        		if(s.charAt(i) == s.charAt(j)) {
        			dp[i][j] =dp[i+1][j-1]+2;
        		}else {
        			dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        		}
        	}
        }
        return dp[0][s.length()-1];
    }
    
}
