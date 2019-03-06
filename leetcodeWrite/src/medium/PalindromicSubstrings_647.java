package medium;
/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

示例 1:

输入: "abc"
输出: 3
解释: 三个回文子串: "a", "b", "c".
示例 2:

输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
注意:

输入的字符串长度不会超过1000。
 * @author liang
 *
 */
public class PalindromicSubstrings_647 {
	/**
	 * 以每个位置为中心，从这个中心向两侧扩大，得到回文个数。要考虑奇数子串 s[i-j,...,i+j] 中,i是回文中心；偶数子串 s[i-1-j,...,i+j]中，(i-1,i)是回文中心
	 * @param s
	 * @return
	 */
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        for(int i=0;i<n;i++) {
        	for(int j=0;i-j>=0 && i+j<n && s.charAt(i-j) == s.charAt(i+j);j++) {
        		res++;//[ i - j , ...,  i + j ]
        	}
        	for(int j=0;i-1-j>=0 && i+j<n && s.charAt(i-1-j) == s.charAt(i+j);j++) {
        		res++;//
        	}
        }
        return res;
    }
    /**
     * 动态规划dp[i]=dp[i-1]+tmpNum，保存从0~i的回文数，tmpNum为新加进一个字符后新增加的回文子串的个数。当遍历到index=i时，只要看看在i之前的index j，能否构成substring(j,i+1)的回文子串。最后结果是dp[len-1]+len，其中len为字符串的长度，因为字符串每个字符都为回文子串
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        int len=s.length();
        int[] dp=new int[len];
        for(int i=1;i<len;i++){
            int tmpNum=0;
            for(int j=0;j<i;j++)
                if(s.charAt(i)==s.charAt(j)){
                    String subStr=s.substring(j,i+1);
                    if(isPalindromic(subStr))
                        tmpNum++;
                }
            dp[i]=dp[i-1]+tmpNum;
        }
        return dp[len-1]+len;
    }
    public boolean isPalindromic(String s){
        for(int i=0;i<(s.length()/2);i++)
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        return true;
    }
    
}
