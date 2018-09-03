package medium;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
	
	示例 1：
	
	输入: "babad"
	输出: "bab"
	注意: "aba"也是一个有效答案。
	示例 2：
	
	输入: "cbbd"
	输出: "bb"
 * @author liang
 *
 */
public class LongestPalindromicSubstring_5 {
	/**
	 * 暴力破解：遍历所有子串，判断每个子串是否是回文串 O(n)
	 * 从最长(0~n)字符串开始判断，不为回文则判断(0~(n-1)),(1~n),(0~(n-2)),(1~(n-1))，这样最先 找到的是最长的
	 * @param s
	 * @return
	 */
    public static String longestPalindrome(String s) {
    	for(int i=s.length();i>0;i--) {
    		for(int left=0,right=(i-1);right<s.length();left++,right++) {
    			if(isLongest(s,left,right)) {
    				return s.substring(left,right+1);
    			}
    		}
    	}
		return s;
    }
    //判断是否是回文子串
    public static boolean isLongest(String s,int left,int right) {
    	while(left<right) {
    		if(s.charAt(left) == s.charAt(right)) {
    			left++;
    			right--;
    		}else {
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * 从中心点向两边扩散寻找最长回文串
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
    	String resu = "";
    	String check = "";
    	if(s.length() == 1) return s;
    	for(int i=0;i<s.length();i++) {
    		check = checkLongest(s,i,i);//寻找以i为中心的最长子串
    		if(check.length()>resu.length()) {
    			resu = check;
    		}
    		check = checkLongest(s,i,i+1);//寻找以i和i+1对称的最长子串
    		if(check.length()>resu.length()) {
    			resu = check;
    		}
    	}
    	return resu;
    }
    
	private static String checkLongest(String s, int left, int right) {
		String result = "";
		while(left>=0 && right<s.length()) {
			if(s.charAt(left) == s.charAt(right)) {
				result = s.substring(left, right+1);
				left--;
				right++;				
			}else {
				return result;
			}

		}
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome2("babad"));
	}

}
