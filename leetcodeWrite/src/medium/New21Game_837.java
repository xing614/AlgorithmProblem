package medium;
/**
 * 837. 新21点
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：

爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。

当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？

示例 1：

输入：N = 10, K = 1, W = 10
输出：1.00000
说明：爱丽丝得到一张卡，然后停止。
示例 2：

输入：N = 6, K = 1, W = 10
输出：0.60000
说明：爱丽丝得到一张卡，然后停止。
在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
示例 3：

输入：N = 21, K = 17, W = 10
输出：0.73278
提示：

0 <= K <= N <= 10000
1 <= W <= 10000
如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
此问题的判断限制时间已经减少。
 * @author liang
 *
 */
public class New21Game_837 {
111
	/**
	 * dp[i]得到i点的概率。
	 * @param N
	 * @param K
	 * @param W
	 * @return
	 */
	public double new21Game(int N, int K, int W) {
		if (K == 0 || N >= K - 1 + W){
            return 1.0;
        }
		
		double[] dp = new double[N + 1];
        double wSum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; i++){
        	
        	dp[i] = wSum / W;
            if (i < K){//在i<k之前，dp[i] = sum(dp[1,i-1])/w+1/w = dp[1]*1/w+dp[2]*1/w+1/w。。。
                wSum += dp[i];
            }
            else{//sum(dp[k:n])
                res += dp[i];
            }
            if (i - W >= 0){
                wSum -= dp[i - W];
            }

        }
        return res;
        
        
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
