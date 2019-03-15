package easy;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

示例 1:

输入: "abab"

输出: True

解释: 可由子字符串 "ab" 重复两次构成。
示例 2:

输入: "aba"

输出: False
示例 3:

输入: "abcabcabcabc"

输出: True

解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * @author liang
 *
 */
public class RepeatedSubstringPattern_459 {
	
	/**
	 * 暴力破解，找到下一个与第一位置相同的字母的位置，然后由他之前的字符串 进行多次重复 看能不能与原字符串重合
	 * @param s
	 * @return
	 */
    public boolean repeatedSubstringPattern(String s) {

        for(int i=1;i<=s.length()/2;i++) {
        	if(s.length()%i != 0 ||s.charAt(i-1)!=s.charAt(s.length()-1)) {//不能整取余  或者最后一位不相同
        		continue;
        	}
        	if(s.charAt(i) == s.charAt(0)) {
            	if(valid(s,i)) {
            		return true;
            	}       		
        	}
        }
        return false;
    }

	private boolean valid(String s, int i) {
		// TODO Auto-generated method stub
		String str = s.substring(0, i);
		System.out.println("str == "+str+"   i="+i);
		for(int j=1;j<(s.length()/i);j++) {
			String str2 = s.substring(j*i,(j+1)*i);
			System.out.println("str2 =="+str2);
			if(!str.equals(str2))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		RepeatedSubstringPattern_459 pr =new RepeatedSubstringPattern_459();
		System.out.println(pr.repeatedSubstringPattern("bb"));
		
	}
}
