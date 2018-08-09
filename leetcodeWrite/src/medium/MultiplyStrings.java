package medium;
/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @author liang
 *
 */
public class MultiplyStrings {
	/**
	 * 假设两个整数的长度分别为了l1和l2，则其最后结果长度为l1+l2（最后有进位）或者l1+l2-1（最后没有有进位）。
	 * 因此，可以先用长度为l1+l2的数组记录结果，最后再转成字符串。
	 * 进行乘法的时候，先把各个位的相乘结果对应累加起来，
	 * 即第1个整数的第i位（低位到高位）和第2个整数的第j位（低位到高位）相乘的结果应该存放在数组的i+j位。然后再统一处理进位。
	 * @param num1
	 * @param num2
	 * @return
	 */
    public static String multiply(String num1, String num2) {
    	int[] v = new int[num1.length()+num2.length()];
    	for(int i=0;i<num1.length();i++) {
    		for(int j=0;j<num2.length();j++) {
    			v[i+j] +=(num1.charAt(num1.length()-i-1)-'0')*(num2.charAt(num2.length()-j-1)-'0');//数组中数据是倒序 从最后开始计算，所以是-i 
    		}
    	}
    	
    	//c是进位
    	for(int i=0,c=0;i<v.length;i++) {
    		int num = v[i]+c;
    		v[i] = num%10;
    		c = num/10; 
    	}
    	System.out.println(v[0]+" "+v[1]);
    	
    	StringBuffer sb = new StringBuffer();
    	int i = v.length;
    	while(--i>0 &&v[i]==0);//去零
    	if(i<0)
    		sb.append("0");
    	else 
    		for(;i>=0;i--) {
    			sb.append(v[i]);
    		}
		return sb.toString();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("2","3"));
	}

}
