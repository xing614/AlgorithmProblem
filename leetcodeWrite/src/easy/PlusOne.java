package easy;
/**
 * 加一
 * 
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 * @author liang
 *
 */
public class PlusOne {

	/**
	 * 思路：维护一个进位，对每一位进行加一，然后判断进位，如果有继续到下一位，否则就可以返回了
	 * 有一个小细节就是如果到了最高位进位仍然存在，那么我们必须重新new一个数组，然后把第一个为赋成1（因为只是加一操作，其余位一定是0，否则不会进最高位）
	 * @param digits
	 * @return
	 */
    public int[] plusOne(int[] digits) {
    	if(digits == null || digits.length == 0) {
    		return digits;
    	}
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--) {
        	int digit = (digits[i]+carry)%10;
        	carry = (digits[i]+carry)/10;
        	digits[i] = digit;
        	if(carry == 0) {
        		return digits;
        	}
        }
        //如果到了最高位还进位，就new新数组，第一个数为1
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;//因为其余位肯定是0，不然不会进位
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
