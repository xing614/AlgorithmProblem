package medium;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
	
	示例：
	
	给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
	
	给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
	
	给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 * @author liang
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * 二次循环
	 * @param s
	 * @return
	 */
    public static int lengthOfLongestSubstring(String s) {
    	if(s.length() == 0) {
    		return 0;
    	}
    	if(s.length() == 1) {
    		return 1;
    	}
    	int max = 0;
    	int result = 0;
    	for(int i=0;i<s.length();i++) {
    		HashSet hs = new HashSet();
    		for(int j=i;j<s.length();j++) {
    			if(hs.contains(s.charAt(j))) {
    				if(result>max) {
    					max = result;    			
    				}
    				result = 0;
    				break;

    			}else {
    				hs.add(s.charAt(j));
    				result++;
    				if(j==(s.length()-1)) {
    					if(result>max) {
        					max = result;
    					}
    					result = 0;
    				}
    			}
    		}
    	}
		return max;
        
    }
	
    /**
     * 字符串常用方法：
     * 有左右两个指针，关注中间字符串，每次判断中选择左/右一个指针向前移动，维护一个HashSet, 
     * 正常情况下移动右窗口，如果没有出现重复则继续移动右窗口，
     * 如果发现重复字符，则说明当前窗口中的串已经不满足要求，继续移动有窗口不可能得到更好的结果，
     * 此时移动左窗口，直到不再有重复字符为止，中间跳过的这些串中不会有更好的结果，因为他们不是重复就是更短。
     * 因为左窗口和右窗口都只向前，所以两个窗口都对每个元素访问不超过一遍，因此时间复杂度为O(2*n)=O(n),是线性算法。空间复杂度为HashSet的size,也是O(n). 
     * O(n)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if(s==null || s.length()==0)  
            return 0;  
        HashSet<Character> set = new HashSet<Character>();  
        int max = 0;  
        int walker = 0;  //左
        int runner = 0;  //右
        while(runner<s.length())  //右没到头
        {  
            if(set.contains(s.charAt(runner)))  //有重复数据
            {  
                if(max<runner-walker)  
                {  
                    max = runner-walker;  
                }  
                while(s.charAt(walker)!=s.charAt(runner))  //如果左数据！=右数据，说明重复的字符在左右之间的字符串中，则左指针前移，同时把这个数据删掉
                {  
                    set.remove(s.charAt(walker));  
                    walker++;  
                }  
                walker++;  //找到重复数据，左指针前移一位去掉重复数据，下一次搜寻，应该跨过出现重复的地方进行，，否则找出来的候选串依然有重复字符，且长度还不如上次的搜索
            }  
            else  
            {  
                set.add(s.charAt(runner));  
            }  
            runner++;  
        }  
        max = Math.max(max,runner-walker);  //因为可能最后一次检查的时候，runner直到走到字符串末尾都没有遇到重复字符。而while循环体中找到的最长不重复子串只是在runner遇到重复字符时才进行的。
        return max;  
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("au"));
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

}
