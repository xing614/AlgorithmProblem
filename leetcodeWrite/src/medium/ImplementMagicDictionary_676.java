package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 676. 实现一个魔法字典
 * 实现一个带有buildDict, 以及 search方法的魔法字典。

对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。

对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。

示例 1:

Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
注意:

你可以假设所有输入都是小写字母 a-z。
为了便于竞赛，测试所用的数据量很小。你可以在竞赛结束后，考虑更高效的算法。
请记住重置MagicDictionary类中声明的类变量，因为静态/类变量会在多个测试用例中保留。 请参阅这里了解更多详情。
 * @author liang
 *
 */
public class ImplementMagicDictionary_676 {
	
	Map<String,List<int[]>> map = new HashMap<>();
	/**
	 * 定义Map<String , list<int []>>
	 * key为s.substring(0, i) + s.substring(i + 1); 即将出去i位置元素的前后字符串合在一起当key
	 * value为{[2,'o'],[3,'i']}这样 ，2表示位置i，'o'表示第2位置的字符是o
	 * 搜索的时候也是for扫描word的每个位置，然后根据位置前后字符合起来从map中key判断是否包含，包含的话遍历int[]判断是否符合存在i位置且 字符不为int[i]位置字符 这样就返回true
	 */
    /** Initialize your data structure here. */
    public ImplementMagicDictionary_676() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s:dict) {
        	for(int i=0;i<s.length();i++) {
        		String key = s.substring(0, i)+s.substring(i+1);
        		int[] pair = new int[] {i,s.charAt(i)};
        		List<int[]> val = map.getOrDefault(key, new ArrayList<int[]>());//从map获取list,没有就新建
        		val.add(pair);
        		map.put(key, val);
        	}
        	
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(int i=0;i<word.length();i++) {
        	String key = word.substring(0, i)+word.substring(i+1);
        	if(map.containsKey(key)) {
        		for(int[] pair:map.get(key)) {
        			if(pair[0] == i && pair[1]!=word.charAt(i))//说明除了i位置的字符串都一样，且i位置字符不一样
        				return true;
        		}
        	}
        }
        return false;
    }
}
