package medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。

示例 1:

输入:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

输出: 
"apple"
示例 2:

输入:
s = "abpcplea", d = ["a","b","c"]

输出: 
"a"
说明:

所有输入的字符串只包含小写字母。
字典的大小不会超过 1000。
所有输入的字符串长度不会超过 1000。
 * @author liang
 *
 */
public class LongestWordinDictionarythroughDeleting_524 {
	/**
	 * 返回最长或长度一样时返回字母表中最前的。
	 * 那么可以对字典中的字符串按照这两个要求排序：长度降序、长度相同时字母表升序。
	 * 这样遍历字典字符串列表，第一个能被输入字符串去掉某些字符表示出的字典字符串即为所求。 
	 * @param s
	 * @param d
	 * @return
	 */
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length()!=o2.length()?(o2.length()-o1.length()):o1.compareTo(o2);
			}
        	
        });
        for(String st :d ) {
        	int i =0;
        	for(char c:s.toCharArray()) {
        		if(i<st.length() && c == st.charAt(i)) {
        			i++;
        		}
        	}
        	if(i == st.length()) {//说明找到最大的长度的串
        		return st;
        	}
        }
        return "";
    }
}
