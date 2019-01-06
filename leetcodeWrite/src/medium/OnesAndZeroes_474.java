package medium;
/**
 * 474. 一和零
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。

现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。

你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。

注意:

给定 0 和 1 的数量都不会超过 100。
给定字符串数组的长度不会超过 600。
示例 1:

输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
输出: 4

解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
示例 2:

输入: Array = {"10", "0", "1"}, m = 1, n = 1
输出: 2

解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 * @author liang
 *
 */
public class OnesAndZeroes_474 {

	/**
	 * 类似01背包
	 * dp[zero][one] = max(1 + dp[zero - n0][one - n1], dp[zero][one])
	 * 
	 * @param strs
	 * @param m
	 * @param n
	 * @return
	 */
    public static int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<len;i++) {
        	//计算这个字符串的0和1的数量
        	int n0 = 0,n1 = 0;
        	for(int j=0;j<strs[i].length();j++) {
        		if(strs[i].charAt(j) == '0')
        			n0++;
        	}
        	n1 = strs[i].length()-n0;
        	for(int zero = m;zero>=n0;zero--) {
        		for(int one = n;one>=n1;one--) {
        			System.out.println(zero+" "+one+" ");
        			dp[zero][one] = Math.max(dp[zero][one], 1+ dp[zero-n0][one-n1]);
        		}
        	}
        }
        return dp[m][n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dp = {"10", "0001", "111001", "1", "0"};
		findMaxForm(dp, 5, 3);
 	}

}
