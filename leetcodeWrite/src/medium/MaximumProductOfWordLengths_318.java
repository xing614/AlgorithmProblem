package medium;
/**
 * 318. 最大单词长度乘积
题目描述提示帮助提交记录社区讨论阅读解答
给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。

示例 1:

输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
输出: 16 
解释: 这两个单词为 "abcw", "xtfn"。
示例 2:

输入: ["a","ab","abc","d","cd","bcd","abcd"]
输出: 4 
解释: 这两个单词为 "ab", "cd"。
示例 3:

输入: ["a","aa","aaa","aaaa"]
输出: 0 
解释: 不存在这样的两个单词。
 * @author liang
 *
 */
public class MaximumProductOfWordLengths_318 {

	/**
	 * 怎么判断两个字符是否不含有相同的字符
	 * 用一个int，32位；而小写字母只有26个，后26位用来表示对应的字符是否存在。
	 * 最后两个int相与，如果结果为0，说明两个对应的字符串没有相同的字符！
	 * @param words
	 * @return
	 */
    public int maxProduct(String[] words) {
        int len = words.length;
        if(len<=1)
        	return 0;
        int[] mask = new int[len];
        for(int i=0;i<len;i++) {
        	for(int j=0;j<words[i].length();j++) {
        		//先讲words[i][j]位置字符转为数字，再将1左移这么多位。mask[i] 或 上这个数.mask[i]值类似1001000
        		mask[i] |= 1<<(words[i].charAt(j)-'a');
        	}
        }
        int max = 0;
        for(int i=0;i<len;i++) {
        	for(int j=i+1;j<len;j++) {
        		if((mask[i] & mask[j]) == 0) {//表示两个数与 结果为0，即没有重复的字符
        			max = Math.max(max, words[i].length() * words[j].length());
        		}
        	}
        }
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
