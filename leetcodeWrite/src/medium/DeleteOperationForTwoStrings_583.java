package medium;
/**
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。

示例 1:

输入: "sea", "eat"
输出: 2
解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
说明:

给定单词的长度不超过500。
给定单词中的字符只含有小写字母。
 * @author liang
 *
 */
public class DeleteOperationForTwoStrings_583 {

	/**
	 * 动态规划dp[i][j]可以表示为word1的前i个字符和word2的前j个字符的最长公共子序列长度；或者word1的前i个字符和word2的前j个字符组成的两个单词，能使其变相同的最小的步数
	 * 公共串：ij位置相同dp[i][j]=dp[i-1][j-1]+1;不同dp[i][j]=max(dp[i-1][j],dp[i][j-1])
	 * 最小步数：i=j,dp[i][j] = dp[i - 1][j - 1];i!=j,dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1]);
	 * @param word1
	 * @param word2
	 * @return
	 */
    public int minDistance(String word1, String word2) {
    	if(word1.length() == 0 || word1 == null || word2.length() == 0 ||word2 == null)
    		return word1.length() == 0? word2.length():word1.length();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        
        for(int i=0;i<=word1.length();i++) {
        	for(int j=0;j<=word2.length();j++) {
        		if(i == 0 || j==0)
        			dp[i][j] = 0;
        		else if(word1.charAt(i-1) == word2.charAt(j-1)) {
        			dp[i][j] = dp[i-1][j-1]+1;
        		}else {
        			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        		}
        	}
        }
        return word1.length()+word2.length()- 2*dp[word1.length()][word2.length()];//返回的是最小步数
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
