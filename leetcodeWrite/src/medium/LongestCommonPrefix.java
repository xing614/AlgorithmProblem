package medium;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 * @author liang
 *
 */
public class LongestCommonPrefix {

	/**
	 * 思路一：
	 * 设变量i、j,i为遍历字符串中的字符，j为遍历字符集[]中的字符串
	 * 依次判断，
	 * 如果到达某一字符串尾部，说明判断最长公共前缀结束
	 * @param strs
	 * @return
	 */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String res = "";
        for(int i = 0;i<strs[0].length();i++) {
        	char ch = strs[0].charAt(i);
        	for(int j = 1;j<strs.length;j++) {
        		if(i>=strs[j].length() || strs[j].charAt(i) !=ch) {//strs[0]当前扫描位置大于j字符串长度  或者 j字符串j位置不为ch
        			return res;
        		}
        	}
        	res += Character.toString(ch);
        }
        return res;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
		
	}

}
