package easy;
/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * java超出最大值后会成最小值开始加
 * @author liang
 *
 */
public class ReverseInteger {
    public static int reverse(int x) {
		 if(x==Integer.MIN_VALUE)//超出范围时取值为0
		         return 0;
	     int num = Math.abs(x);
	     int res = 0;
	     while(num!=0){
	         if(res>(Integer.MAX_VALUE-num%10)/10)//判断越界问题，就是再向前一位就越界了
	        	 return 0;
		     res = res*10+num%10;//从最小值开始翻转
		     num /= 10;
		 }
		 return x>0?res:-res;
    }
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(2147483647+4);
		System.out.println(Math.pow(2, 30));
		System.out.println(reverse(1253647457));
	}

}
