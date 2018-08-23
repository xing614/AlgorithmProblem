package hard;
/**
 * 72. 编辑距离
给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
示例 1:

输入: word1 = "horse", word2 = "ros"
输出: 3
解释: 
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2:

输入: word1 = "intention", word2 = "execution"
输出: 5
解释: 
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 * @author liang
 *
 */
public class EditDistance_72 {

	/**
	 * 动态规划
	 * D(i,j) 表示从第1个单词的第0位至第i位形成的子串 和 第2个单词的第0位至第j位形成的子串的编辑距离。
	 * D(i,0) = i
	 * D(0,j) = j
	 * D(i,j) = D(i-1, j) + 1 		(D(i-1, j)的操作完成之后删除一个字符(第1个单词的第i个字符))
	 * 		  = D(i, j-1) + 1  		(D(i, j-1)的操作完成之后增加一个字符(第2个单词的第j个字符))
	 * 		  = D(i-1, j-1) +  1 	(if  X(i) != Y(j))
	 * 		  = D(i-1, j-1) +  0  	(if  X(i) == Y(j)) 
	 * @param word1
	 * @param word2
	 * @return
	 */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // 注意长度，字符有0长度
     	//dp[i][j] 代表最小操作数（步骤），从 word1[0..i-1]转化为 word2[0..j-1].
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++)
			dp[i][0] = i;
		for (int i = 0; i <= len2; i++)
			dp[0][i] = i;
		for(int i=1;i<=len1;i++) {
			for(int j=1;j<=len2;j++) {
				if(word1.charAt(i-1)==word2.charAt(j-1))//如果相等，就等于i-1,j-1不变 
					dp[i][j] = dp[i-1][j-1];
				else//不想等，找最小值+1
					dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
			}
		}
		return dp[len1][len2];
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
