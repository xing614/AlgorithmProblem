package medium;
/**
 * 313. 超级丑数
编写一段程序来查找第 n 个超级丑数。

超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。

示例:

输入: n = 12, primes = [2,7,13,19]
输出: 32 
解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
说明:

1 是任何给定 primes 的超级丑数。
 给定 primes 中的数字以升序排列。
0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
第 n 个超级丑数确保在 32 位有符整数范围内。
 * @author liang
 *
 */
public class SuperUglyNumber_313 {

	/**
	 * 就是说丑数序列是由primes中数组成的
	 * 
	 * 质数集合可以任意给定，由于我们不知道质数的个数，我们可以用一个idx数组来保存当前的位置，
	 * 然后我们从每个子链中取出一个数，找出其中最小值，然后更新idx数组对应位置，注意有可能最小值不止一个，要更新所有最小值的位置
	 * @param n
	 * @param primes
	 * @return
	 */
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];//超级丑数序列
        dp[0] = 1;//第一个数为1
        int[] idxPrimes = new int[primes.length];
        int count =1;
        while(count < n) {
        	int min = Integer.MAX_VALUE;
        	//找出最小值
        	for(int i =0;i<primes.length;i++) {
        		// idxPrimes[i]代表每个丑数的个数，
				// 比如丑数2题目的2，3，5，
				// idxPrimes[0]代表2的下标
				// idxPrimes[1]代表3的下标
				// idxPrimes[2]代表5的下标
        		int temp = dp[idxPrimes[i]] * primes[i];
        		System.out.println( idxPrimes[i]+"---"+temp);
        		min = min<temp?min:temp;
        	}
        	System.out.println(min+"======");
        	// 如果min和 dp[idxPrimes[i]] * primes[i]相等，
        	// 则其对应的下标++
        	for(int i=0;i<primes.length;i++) {
        		if(min == dp[idxPrimes[i]] * primes[i]) {
        			idxPrimes[i]++;
        		}
        	}
        	dp[count] = min;
        	count++;
        }
        return dp[n - 1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = {2,7,13,19};
		System.out.println(nthSuperUglyNumber(12,pre));
	}

}
