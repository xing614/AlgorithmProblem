package easy;
/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * @author liang
 *
 */
public class LongestPalindrome_409 {

	/**
	 * 计算数字成对出现的字母数量。出现一次 则次数变为1，出现第二次 就变为0 同时长度+2
	 * @param s
	 * @return
	 */
    public int longestPalindrome(String s) {
    	//无序列表字母ASCII码A~Za~z区间为（65～122）
        int[] tmp = new int[128];
        int len = 0;
        for(int i=0;i<s.length();i++) {
        	int charAt = s.charAt(i);
        	tmp[charAt] = ~tmp[charAt];//取反， 没出现次数时 默认值为00000，出现一次后取反变为11111，再出现第二次又变成0000
        	if(tmp[charAt] == 0) {
        		len+=2;
        	}
        }
        return len<s.length()? len+1:len;//如果 长度小于s,说明存在奇数个数的字母，所以长度+1
    }
    
}
