package easy;
/**
 * 28. 实现strStr()
 * 实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @author liang
 *
 */
public class ImplementStrStr {
	/**
	 * 假设原串的长度是n，匹配串的长度是m。思路很简单，就是对原串的每一个长度为m的字串都判断是否跟匹配串一致。
	 * 总共有n-m+1个子串，所以算法时间复杂度为O((n-m+1)*m)=O(n*m)，空间复杂度是O(1)
	 * @param haystack
	 * @param needle
	 * @return
	 */
    public int strStr(String haystack, String needle) {

        if(haystack==null || needle == null || needle.length()==0)
            return 0;
        if(needle.length()>haystack.length())
            return -1;
        for(int i =0;i<=haystack.length()-needle.length();i++) {//这里是i<=
        	boolean suFlag =true;
        	for(int j=0;j<needle.length();j++) {
            	if(haystack.charAt(i+j)!=needle.charAt(j)) {
            		suFlag = false;
            		break;
            	}
        	}
        	if(suFlag == true) {
        		return i;
        	}
        }
        return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
