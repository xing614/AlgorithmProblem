package medium;
/**
 * 375. 猜数字大小2
 * 我们正在玩一个猜数游戏，游戏规则如下：

我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。

每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。

然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。

示例:

n = 10, 我选择了8.

第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。

游戏结束。8 就是我选的数字。

你最终要支付 5 + 7 + 9 = 21 块钱。
给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。
 * @author liang
 *
 */
public class GuessNumberHigherOrLower2_375 {

	/**
	 *  在1-n个数里面，我们任意猜一个数(设为i)，保证获胜所花的钱应该为 i + max(w(1 ,i-1), w(i+1 ,n))，
	 *  这里w(x,y))表示猜范围在(x,y)的数保证能赢应花的钱，则我们依次遍历 1-n作为猜的数，求出其中的最小值即为答案
	 * @param n
	 * @return
	 */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return cost(dp,1,n);
    }

	private int cost(int[][] dp, int start, int end) {
		// TODO Auto-generated method stub
		int res= Integer.MAX_VALUE;
		if(start>=end) {
			return 0;
		}
		if(dp[start][end]!= 0) {
			return dp[start][end];
		}
		for(int i =start;i<end+1;i++) {
			int temp = i + Math.max(cost(dp,start,i-1),cost(dp,i+1,end));
			if(temp<res) {
				res = temp;
			}
		}
		dp[start][end] = res;
		return res;
	}
    
}
