package hard;

import java.util.Arrays;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [2,4,1], k = 2
输出: 2
解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2:

输入: [3,2,6,5,0,3], k = 2
输出: 7
解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * @author liang
 *
 */
public class BestTimetoBuyandSellStockIV_188 {

	/**
	 * 部分内容参见123题；如果k大于一半 就只要后一位>前一位 就+max；否则 动态规划buy[k] sell[k]
	 * @param k
	 * @param prices
	 * @return
	 */
    public int maxProfit(int k, int[] prices) {
    	if(k == 0 || prices.length == 0) return 0;
    	if(k > prices.length / 2){//k大于一半 就无脑一直加
            // 当 k 超过区间的一半，则退化为峰谷计算
            int max = 0;
            for(int i = 1 ; i < prices.length ; i ++){
                if(prices[i] > prices[i - 1])
                    max += prices[i] - prices[i - 1];
            }
            return max;
        }else{
        	k = Math.min(k,prices.length);
            int[] buy  = new int[k];
            int[] sell = new int[k];
            Arrays.fill(buy,Integer.MIN_VALUE);
            Arrays.fill(sell,0);
            for(int p : prices){
                for(int i = 0 ; i < k ; i ++){
                    buy[i]  = Math.max(buy[i],(( i == 0 ) ? 0 : sell[i - 1] ) - p);//买入的价格 如果第一次买就是0-p,如果是第n次  就是第n-1次卖出的价格-p
                    sell[i] = Math.max(sell[i],buy[i] + p);
                }
            }
            return sell[k - 1];
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
