package easy;
/**
 * 541. 反转字符串 II
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"
要求:

该字符串只包含小写的英文字母。
给定字符串的长度和 k 在[1, 10000]范围内。
 * @author liang
 *
 */
public class ReverseStringII_541 {

	/**
	 * 设置起点，中间k点，最后2k点，根据规律翻转
	 * @param s
	 * @param k
	 * @return
	 */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int start = 0,kIndex = k-1,k2Index = k<<1 - 1;//初始位置，左移一位-1
        while(start<s.length()) {
        	if(chars.length<k) {
        		reverse(chars,start,chars.length-1);
        		break;
        	}
        	int tmp =s.length()-start;//尾部到当前开始位的距离
        	if(tmp<k) {
        		reverse(chars,start,chars.length-1);
        	}
        	if(tmp< (k<<1) &&tmp>=k) {// k<tmp<2k
        		reverse(chars,start,kIndex);
        		break;
        	}
        	if(k2Index<s.length()) {
        		reverse(chars,start,kIndex);
        	}
        	start+=k<<1;
        	kIndex+=k<<1;
        	k2Index+=k<<1;
        }
        return new String(chars);
    }
    
	private void reverse(char[] s, int start, int end) {
		// TODO Auto-generated method stub
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
