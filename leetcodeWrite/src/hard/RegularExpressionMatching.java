package hard;
/**
 * 正则表达式匹配
 * 
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符。
'*' 匹配零个或多个前面的元素。
匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
 * @author liang
 *
 */
public class RegularExpressionMatching {
	/**
	 * 递归
	 * 1判断P的下一个字符是*，如果p和s当前字符相同或者p是‘.’,则一直向右移动直到p没有‘.*’或‘x*’这种情况，递归判断（x是指跟s相同的字符）
	 * 2P的下一个字符不是*，如果p和s当前字符相同或者p是‘.’，则p和s向右移动一个字符，递归判断
	 * @param s
	 * @param p
	 * @return
	 */
    public static boolean isMatch(String s, String p) {
    	int slen = s.length();
    	int plen = p.length();
    	
    	if(plen == 0) return slen == 0;
    	if(plen == 1) {//匹配字符串长度为1，则要么s == p;p为.时s长度为1
    		if(p.equals(s)||p.equals('.')&&s.length()==1) return true;
    		else return false;
    	}
    	if(p.charAt(1)=='*') {//从[1]开始判断是不是*
    		//下一个字符 为*时，判断第一个字符s和p是否匹配，匹配就一直向右移动
    		while(s.length()>0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
    			if(isMatch(s,p.substring(2))) return true;//看后面S不变p后移 是不是也匹配
    			s.substring(1);//右移
    		}
    		return isMatch(s,p.substring(2));//发现s右移不匹配了，开始右移P递归判断
    	}else {
    		//下一个字符不为*时，判断第一个字符s和p相同或者p当前字符是‘.’，匹配就s和P一直向右移动
    		if(s.length()>0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
    			return isMatch(s.substring(1),p.substring(1));
    		}
    		return false;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isMatch("aab","c*a*b");
	}

}
