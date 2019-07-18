package hard;
/**
 * 
123. 买卖股票的最佳时机 III
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1] 
输出: 0 
解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * @author liang
 *
 */
public class BestTimetoBuyandSellStockIII_123 {

	/**
	 * 使用四个变量，分别表示对于任意一天，
	 * fstBuy: 在该天第一次买入股票可获得的最大收益 
        fstSell: 在该天第一次卖出股票可获得的最大收益
        secBuy: 在该天第二次买入股票可获得的最大收益
        secSell: 在该天第二次卖出股票可获得的最大收益
        	分别对四个变量进行相应的更新, 最后secSell就是最大
        	收益值(secSell >= fstSell)
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        int fstBuy = Integer.MIN_VALUE,fstSell = 0;
        int secBuy = Integer.MIN_VALUE,secSell = 0;
        for(int i=0;i<prices.length;i++) {
        	fstBuy = Math.max(fstBuy, -prices[i]);//最初是0元，如果买了股票 就变成-prices[i]元
        	fstSell = Math.max(fstSell, fstBuy+prices[i]);//如果卖，就变成买入时手里的钱+卖出的股票价格
        	secBuy = Math.max(secBuy, fstSell - prices[i]);//如果卖,就当前第一个次卖完手里的收益-Prices[i]元
        	secSell = Math.max(secSell, secBuy+prices[i]);
        }
        return secSell;
    }
    /**
     * 方法2，从左到右找到第一次最大利润，从右到左找到第二次最大利润
     * 使用一个数组保存第一次遍历时每一步的最大利润，然后再进行反向遍历，找出第二次交易的利润
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
    	 int len = prices.length;
         if (len < 2)
             return 0;
         int [] maxBefore = new int[len];
         int min = prices[0];
         for(int i=1; i<len; i++){
             maxBefore[i] = Math.max(maxBefore[i-1], prices[i] - min);
             min = Math.min(min, prices[i]);
         }
         int max = prices[len - 1];
         int ret = 0;
         for(int i=len-2; i>=0; i--){
             //找到后面最大的价格
             max = Math.max(prices[i], max);
             //利润 = 最大价格 - 当前价格 + 此时交易时第一次的利润
             //取最大值
             ret = Math.max(ret, max - prices[i] + maxBefore[i]);
         }
         return ret;
    }
    /**
     * 方法3.动态规划。以第i天为分界线，计算第i天之前进行一次交易的最大收益preProfit[i]，和第i天之后进行一次交易的最大收益postProfit[i]，最后遍历一遍，max{preProfit[i] + postProfit[i]} (0≤i≤n-1)就是最大收益。第i天之前和第i天之后进行一次的最大收益求法同Best Time to Buy and Sell Stock I。
     * 
     * 第二种，[i][j]表示第i次交易中在j位置时产生的最大收益
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
    	 int n = prices.length;
         if(n == 0) return 0;

         int[][] dp = new int[3][n];
         for(int i = 1; i <= 2; i++) {
             int balance = -prices[0];
             for(int j = 1; j < n; j++) {
                 dp[i][j] = Math.max(dp[i][j - 1], balance + prices[j]);//当前位置 如果不交易则利润是dp[i][j - 1]，如果交易 就手里的钱+卖出价格
                 balance = Math.max(balance, dp[i - 1][j - 1] - prices[j]);//手里的钱 不交易就是当前价格 ，交易就是前一个位置前一次交易手里的价格-prices[] 就是买入后手里的钱变少了
             }
         }

         return dp[2][n - 1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
