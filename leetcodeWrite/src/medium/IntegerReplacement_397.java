package medium;
/**
 * 397. 整数替换
 * 给定一个正整数 n，你可以做如下操作：

1. 如果 n 是偶数，则用 n / 2替换 n。
2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
n 变为 1 所需的最小替换次数是多少？

示例 1:

输入:
8

输出:
3

解释:
8 -> 4 -> 2 -> 1
示例 2:

输入:
7

输出:
4

解释:
7 -> 8 -> 4 -> 2 -> 1
或
7 -> 6 -> 3 -> 2 -> 1
 * @author liang
 *
 */
public class IntegerReplacement_397 {

	/**
	 * 利用bit位的操作。如果这个数偶数，那么末位的bit位一定是0。如果一个数是奇数，那么末位的bit位一定是1。对于偶数，操作是直接除以2。
		对于奇数的操作:
		如果倒数第二位是0，那么n-1的操作比n+1的操作能消掉更多的1。
		1001 + 1 = 1010
		1001 - 1 = 1000
		如果倒数第二位是1，那么n+1的操作能比n-1的操作消掉更多的1。
		1011 + 1 = 1100
		1111 + 1 = 10000
		
		为了防止integer越界，可以将n先转换成long
	 * @param n
	 * @return
	 */
    public int integerReplacement(int n) {
        long N =n;
        int count = 0;
        while(N!=1) {
        	if(N % 2 == 0) {
        		N = N>>1;//右移一位，去掉末位的0
        	}else {
        		if(N == 3) {//两步结束
        			count += 2;
        			break;
        		}
        		N = ( N & 2) == 2? N+1 : N-1;//判断倒数第二位是否是1，是1则N+1
        	}
        	count++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
