package medium;
/**
 * 264. 丑数 II
编写一个程序，找出第 n 个丑数。

丑数就是只包含质因数 2, 3, 5 的正整数。

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:  

1 是丑数。
n 不超过1690。
 * @author liang
 *
 */
public class UglyNumber2_264 {

	/**
	 * 动态规划
	 * 直接从上次结束的位置搜索即可，因为那个位置以前都肯定小于cur.
	 * 每次判断当前235为底的丑数哪个最小，这样当前循环用于重置此数
	 * 将该位置的2/3/5与对应最小值相乘取代这丑数
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        // 2, 3, 5最小丑数
        int f2 = 2,f3 = 3,f5 = 5;
        // f2, f3, f5对应最小值的下标
     	int ix2 = 0, ix3 = 0, ix5 = 0;
     	for(int i=1;i<n;i++) {
     		int min = Math.min(Math.min(f2, f3), f5);
     		// dp[i]设置为最小值
     		dp[i] = min;
     		// 下方if只能执行一个，求出下一个丑数可能为最小值，
			// 用于和其他未改变两个的值大小
			// 同时更新对应的下标
			// 注意ix2，3，5是从下标0开始
			// 若为1，则是后++
     		if(min == f2) {
     			f2 = 2* dp[++ix2];
     		}
     		if(min == f3) {
     			f3 = 3*dp[++ix3];
     		}
     		if(min == f5) {
     			f5 = 5*dp[++ix5];
     		}
     	}
     	return dp[n-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
