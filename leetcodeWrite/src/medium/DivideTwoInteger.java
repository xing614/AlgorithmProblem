package medium;
/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
说明:

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * @author liang
 *
 */
public class DivideTwoInteger {

	/**
	 * 一般方法就是被除数一直减去除数，O（N）
	 * 
	 * 下面这个方法是使用位运算，
	 * 任何一个整数可以表示成以2的幂为底的一组基的线性组合，即num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n。
	 * 基于以上这个公式以及左移一位相当于乘以2，
	 * 我们先让除数左移直到大于被除数之前得到一个最大的基。
	 * 然后接下来我们每次尝试减去这个基，如果可以则结果增加加2^k,然后基继续右移迭代，直到基为0为止。
	 * 因为这个方法的迭代次数是按2的幂直到超过结果，所以时间复杂度为O(logn)
	 * @param dividend
	 * @param divisor
	 * @return
	 */
    public static int divide(int dividend, int divisor) {
        if(divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int result = 0;
        boolean isNeg = ((dividend ^ divisor) >> 31)!=0? true : false;//判断是否都是正数
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digits = 0;//代表divisor左移多少位
        while(divisor <= (dividend >> 1)) {//dividend右移一位，除数是否小于被除数？
           digits++;
           divisor <<= 1;//小于的话divisor左移一位
       }
       while(digits >= 0) {
           if(dividend >= divisor) {
               dividend -= divisor;
               result += 1 << digits;//result加上左移位数
           }
           divisor >>= 1;//除以2
           digits--;
       }
       return isNeg ? -result : result;

    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483647,-1));
	}

}
