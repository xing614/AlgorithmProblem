package medium;
/**
 * 309. 最佳买卖股票时机含冷冻期
题目描述提示帮助提交记录社区讨论阅读解答
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * @author liang
 *
 */
public class BestTimeToBuyAndSellStockWithCoolDown_309 {

	/**
	 * 动态规划
	 * 维护两个数组，一个是未持有股票状态selldp[]，一种是持有股票状态buydp[]
	 * 未持有股票状态最大利润,一，和昨天一样保持未持有；二，昨天持有股票今天卖掉：
	 * selldp[i] = max(selldp[i-1],buydp[i-1]+prices[i]) 
	 * 持有股票最大利润，一，和昨天一样持有股票不卖；二，两天前未持有（休息一天）今天购买
	 *  buydp[i] = max(buydp[i-1],selldp[i-2]-prices[i])
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
        	return 0;
        }
        int[] selldp = new int[prices.length];
        int[] buydp = new int[prices.length];
        selldp[0] = 0;
        buydp[0] = -prices[0];
        for(int i=1;i<prices.length;i++) {
        	selldp[i] = Math.max(selldp[i-1], buydp[i-1]+prices[i]);
        	if(i>=2) {
        		buydp[i] = Math.max(buydp[i-1], selldp[i-2]-prices[i]);	
        	}else {
        		buydp[i] = Math.max(buydp[i-1], -prices[i]);
        	}
        }
        return selldp[prices.length-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
