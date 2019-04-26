package medium;
/**
 * 866. 回文素数
 * 求出大于或等于 N 的最小回文素数。

回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。

例如，2，3，5，7，11 以及 13 是素数。

回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。

例如，12321 是回文数。

 

示例 1：

输入：6
输出：7
示例 2：

输入：8
输出：11
示例 3：

输入：13
输出：101
 

提示：

1 <= N <= 10^8
答案肯定存在，且小于 2 * 10^8。
 * @author liang
 *
 */
public class PrimePalindrome_866 {

	/**
	 * 偶数位的回文数都能被11整除 所以不是素数
	 * @param N
	 * @return
	 */
    public int primePalindrome(int N) {
        while(!isPrime(N) || !isPalindrome(N)) {//如果不是素数 或者不是回文
        	++N;
        	//跳过偶数位数  
        	if(N>Math.pow(10, 1) && N<Math.pow(10, 2) && N!=11) N=(int) Math.pow(10, 2);//>10且<100且！=11
        	if (N > Math.pow(10, 3) && N < Math.pow(10, 4)) N = (int) Math.pow(10, 4);
            if (N > Math.pow(10, 5) && N < Math.pow(10, 6)) N = (int) Math.pow(10, 6);
            if (N > Math.pow(10, 7) && N < Math.pow(10, 8)) N = (int) Math.pow(10, 8);
        }
        return N;
    }
    //判断是否是回文数,数字翻转后判断与之前是否相同
	private boolean isPalindrome(int num) {
		// TODO Auto-generated method stub
		int a=num,b=0,c=0;
		while(num>0) {
			c=num%10;
			num/=10;
			b=b*10+c;
		}
		if(a==b)
			return true;
		return false;
	}
	//判断是否是素数
	private boolean isPrime(int num) {
		// TODO Auto-generated method stub
		if(num<2) {
			return false;
		}
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i == 0)//整除说明不是素数
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
