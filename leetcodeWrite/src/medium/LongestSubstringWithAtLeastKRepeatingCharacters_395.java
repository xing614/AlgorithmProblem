package medium;
/**
 * 395. 至少有K个重复字符的最长子串
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。

示例 1:

输入:
s = "aaabb", k = 3

输出:
3

最长子串为 "aaa" ，其中 'a' 重复了 3 次。
示例 2:

输入:
s = "ababbc", k = 2

输出:
5

最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * @author liang
 *
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters_395 {

	/**
	 * 递归
	 * 建立一个数组来统计每个字母出现的次数
	 * 对于出现次数少于K次的，我们把它们当做间隔，
	 * 从而把原数列分为几段，要找的满足重复的最长的子序列一定在这几段其中。
	 * 对于分开的每段，又是一个同样性质的子问题。如果一段中没有小于K的间隔，那么直接返回这一段的长度，更新最大长度。
	 * @param s
	 * @param k
	 * @return
	 */
    public int longestSubstring(String s, int k) {
        return helper(s,k,0,s.length()-1);
    }
    
	private int helper(String s, int k, int left, int right) {
		// TODO Auto-generated method stub
		int len = right-left+1;
		if(len<=0)
			return 0;
		int i,j;
		int maxLen = 0;
		int[] count = new int[26];
		//left到right的s字符串每个字符个数计算
		for(i = left;i<=right ;i++) {
			count[s.charAt(i) - 'a']++;
		}
		for(i = left,j = left;i<=right;i++) {
			//该字符个数不到K的
			if(count[s.charAt(i) - 'a'] < k) {
				//当前位置字符不符合条件，则找该位置前一段的最长子串
				maxLen = Math.max(maxLen, helper(s,k,j,i-1));
				j = i+1;
			}
		}
		if(j == left)
			return len;//说明一直符合条件，直接返回最长值
		else
			return Math.max(maxLen, helper(s,k,j,i-1));//如果在原数列中出现了间隔，那么最后一个间隔到right之间这一段是没有参与计数
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
