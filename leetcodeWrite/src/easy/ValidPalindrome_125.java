package easy;
/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
 * @author liang
 *
 */
public class ValidPalindrome_125 {

	/**
	 * 从前从后做对比
	 * @param s
	 * @return
	 */
    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j) {
        	if(!Character.isLetterOrDigit(charArray[i])) {//判断是否是数字和英文字符
        		i++;
        	}else if(!Character.isLetterOrDigit(charArray[j])) {
        		j--;
        	}else {
        		if(Character.toLowerCase(charArray[i]) == Character.toLowerCase(charArray[j])) {
        			i++;
        			j--;
        		}else {
        			return false;
        		}
        	}
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
