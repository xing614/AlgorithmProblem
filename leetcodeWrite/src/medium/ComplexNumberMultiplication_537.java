package medium;
/**
 * 537. 复数乘法
 * 给定两个表示复数的字符串。

返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。

示例 1:

输入: "1+1i", "1+1i"
输出: "0+2i"
解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
示例 2:

输入: "1+-1i", "1+-1i"
输出: "0+-2i"
解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
注意:

输入字符串不包含额外的空格。
输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。
 * @author liang
 *
 */
public class ComplexNumberMultiplication_537 {

	/**
	 * 使用split拆分再计算再合并
	 * @param a
	 * @param b
	 * @return
	 */
    public String complexNumberMultiply(String a, String b) {
    	//例子"1+1i", "1+1i"
        int[] aq = new int[2];//第一位保存第一个串 的1，第二位保存第一个串的+1
        int[] bq = new int[2];//第一位保存第二个串 的1，第二位保存第二个串的+1
        
        String[] as;//做拆分串
        String[] bs;
        
        int shi,xu;

        as = a.split("[+]");
        bs = b.split("[+]");
        
        aq[0] = Integer.parseInt(as[0]);
        aq[1] = Integer.parseInt(as[1].split("i")[0]);
        bq[0] = Integer.parseInt(bs[0]);
        bq[1] = Integer.parseInt(bs[1].split("i")[0]);
        
        shi = aq[0]*bq[0] - aq[1]*bq[1];
        xu = aq[0]*bq[1] + aq[1]*bq[0];
        
        return shi+"+"+xu+"i";
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
