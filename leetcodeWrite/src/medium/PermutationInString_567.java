package medium;
/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").
 

示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False
 

注意：

输入的字符串只包含小写字母
两个字符串的长度都在 [1, 10,000] 之间
 * @author liang
 *
 */
public class PermutationInString_567 {

	/**
	 * 滑动窗口，统计S2一个区间的字符，是否与S1相符
	 * 使用两个数组分别保存S1和S2出现每个字符的次数
	 * @param s1
	 * @param s2
	 * @return
	 */
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
        	return false;
        int[] s1St = new int[26];
        int[] s2St = new int[26];
        for(int i=0;i<s1.length();i++) {
        	s1St[s1.charAt(i) - 'a']++;
        	s2St[s2.charAt(i) - 'a']++;
        }
        //滑动窗口遍历
        for(int i=0;i<s2.length()-s1.length();i++) {
        	if(match(s1St,s2St)) {
        		return true;
        	}
        	//不符合就右移
        	s2St[s2.charAt(i+s1.length()) - 'a']++;
        	s2St[s2.charAt(i) - 'a']--;
        }
        return match(s1St,s2St);
    }
    
	private boolean match(int[] s1St, int[] s2St) {
		// TODO Auto-generated method stub
		for(int i=0;i<26;i++) {
			if(s1St[i]!=s2St[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
