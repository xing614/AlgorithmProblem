package medium;

/**
 * 522. 最长特殊序列 II
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。

子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。

输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。

 

示例：

输入: "aba", "cdc", "eae"
输出: 3
 

提示：

所有给定的字符串长度不会超过 10 。
给定字符串列表的长度将在 [2, 50 ] 之间。
 
 * @author liang
 *
 */
public class LongestUncommonSubsequenceII_522 {
	/**
	 * 找出所有可以称为非公共子串的字符串，然后在从中选出最长的，就是所需要的字符串。
	 * @param strs
	 * @return
	 */
    public int findLUSlength(String[] strs) {
        int longest = -1;
        for(int i=0;i<strs.length;i++) {
        	boolean isSub = true;
        	for(int j=0;j<strs.length;j++) {
        		if(i!=j && isSubsequence(strs[i], strs[j])) {
        			isSub = false;
        			break;
        		}
        	}
        	if(isSub)//说明这个子串没有与其他串公共
        		longest = Math.max(longest, strs[i].length());
        }
        return longest;
    }
    
    /**
     * 判断a是b的子串
     * @param a
     * @param b
     * @return
     */
    public boolean isSubsequence(String a,String b) {
    	if(a.length()>b.length())
    		return false;
    	if(a.equals(b))
    		return true;
    	int position = 0;
    	for(int i=0;i<b.length();i++) {
    		if(position == a.length())
    			break;
    		if(a.charAt(position) == b.charAt(i))
    			position++;
    	}
    	return position == a.length();
    }
}
