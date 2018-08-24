package easy;
/**
 * 67. 二进制求和
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"

 * @author liang
 *
 */
public class AddBinary_67 {

    public static String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i =a.length()-1;
        int j=b.length()-1;
        int cat = 0;//进位
        while(i>=0||j>=0||cat>0) {
        	int v = cat;//当前位的数字
        	System.out.println(i+" "+j+" "+cat);
        	if(i>=0) v+=a.charAt(i)-'0';
        	if(j>=0) v+=b.charAt(j)-'0';
        	cat = v/2;
        	v = v%2;
        	sb.append(v);
        	i--;
        	j--;
        }
        return sb.reverse().toString();//翻转
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11", "1"));
	}

}
