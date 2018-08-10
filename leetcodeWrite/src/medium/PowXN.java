package medium;
/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * @author liang
 *
 */
public class PowXN {

	/**
	 * 可以使用二分法
	 * 用递归来解，把x的n次方划分成两个x的n/2次方相乘，然后递归求解子问题，
	 * 结束条件是n为0返回1。因为是对n进行二分 O(logn)
	 * @param x
	 * @param n
	 * @return
	 */
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        double half = myPow(x,n/2);
        if(n%2==0) {
        	return half*half;
        }else if(n>0) {
        	return half*half*x;
        }else {//<0 就是除x
        	return half/x*half;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int half = 10;
		int x= 2;
		System.out.println(half/x*half);
	}

}
