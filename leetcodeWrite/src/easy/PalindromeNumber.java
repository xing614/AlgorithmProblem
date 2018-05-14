package easy;
/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *  输入: 121
	输出: true
	
	示例 2:
	输入: -121
	输出: false
	解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * @author liang
 *
 */
public class PalindromeNumber {
	/**
	 * 方法1。将x值翻转过来
	 * @param x
	 * @return
	 */
    public static boolean isPalindrome(int x) {
    	if(x<0) {
    		return false;
    	}else if(x==0) {
    		return true;
    	}else {
    		int tem = x;
    		int y = 0;
    		while(x!=0) {
    			y = y*10 + x%10;//x%10获取当前x的最后一位数字，下一步y*10会将数字向高位移动
    			x = x/10;//去掉最低位
     		}
    		if(y==tem)
    			return true;
    		else 
    			return false;
    	}
    }

    /**
     * 方法二，依次将最高位和最低位比较，出现不同就false
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
    	if(x<0) {
    		return false;
    	}else if(x==0) {
    		return true;
    	}else {
    		int num = 1;//如果数是2121，则num为1000
    		while(x/num >=10)
    			num *= 10;
    		while(x!=0) {
    			//最高位
    			int left = x/num;
    			//最低位
    			int right = x%10;
    			if(left!=right)//存在不等就为false
    				return false;
    			x = (x % num) / 10;//x%num表示去掉x的最高位，/10表示去掉最低位
    			num /=100; //表示当前x长度
    		}
    		return true;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome2(123321));
	}

}
