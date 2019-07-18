package medium;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 833. 字符串中的查找与替换
 * 对于某些字符串 S，我们将执行一些替换操作，用新的字母组替换原有的字母组（不一定大小相同）。

每个替换操作具有 3 个参数：起始索引 i，源字 x 和目标字 y。规则是如果 x 从原始字符串 S 中的位置 i 开始，那么我们将用 y 替换出现的 x。如果没有，我们什么都不做。

举个例子，如果我们有 S = “abcd” 并且我们有一些替换操作 i = 2，x = “cd”，y = “ffff”，那么因为 “cd” 从原始字符串 S 中的位置 2 开始，我们将用 “ffff” 替换它。

再来看 S = “abcd” 上的另一个例子，如果我们有替换操作 i = 0，x = “ab”，y = “eee”，以及另一个替换操作 i = 2，x = “ec”，y = “ffff”，那么第二个操作将不执行任何操作，因为原始字符串中 S[2] = 'c'，与 x[0] = 'e' 不匹配。

所有这些操作同时发生。保证在替换时不会有任何重叠： S = "abc", indexes = [0, 1], sources = ["ab","bc"] 不是有效的测试用例。

 

示例 1：

输入：S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
输出："eeebffff"
解释：
"a" 从 S 中的索引 0 开始，所以它被替换为 "eee"。
"cd" 从 S 中的索引 2 开始，所以它被替换为 "ffff"。
示例 2：

输入：S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
输出："eeecd"
解释：
"ab" 从 S 中的索引 0 开始，所以它被替换为 "eee"。
"ec" 没有从原始的 S 中的索引 2 开始，所以它没有被替换。
 

提示：

0 <= indexes.length = sources.length = targets.length <= 100
0 < indexes[i] < S.length <= 1000
给定输入中的所有字符都是小写字母。
 
 * @author liang
 *
 */
public class FindAndReplaceinString_833 {

	/**
	 * 有点问题， 长度太长出现StringIndexOutOfBoundsException
	 * @param S
	 * @param indexes
	 * @param sources
	 * @param targets
	 * @return
	 */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    	StringBuffer
    	//存储indexes[i]  i  排序
    	TreeMap<Integer,Integer> tm = new TreeMap<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
    		111
    	});
    	for(int i=0;i<indexes.length;i++) {
    		tm.put(indexes[i], i);
    	}
    	Iterator<Entry<Integer, Integer>> iterator = tm.entrySet().iterator();
    	String str = S;
    	int num = 0;//每次修改字符串后的偏移量
    	while(iterator.hasNext()) {
    		Entry<Integer, Integer> next = iterator.next();
    		int key = next.getKey();
    		int value = next.getValue();
    		if(S.indexOf(sources[value], key) == key) {
    			String start = str.substring(0, key+num);
    			String end = str.substring(key+num,str.length());
    			str = start+end.replace(sources[value], targets[value]);//替换
    			num = targets[value].length() - sources[value].length()+num;
    		}
    	}
    	System.out.println(str);
    	return str;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAndReplaceinString_833 ff = new FindAndReplaceinString_833();
		String S = "abcd";
		int[] indexes = {0,2};
		String[] sources = {"a","cd"};
		String[] targets = {"eee","fff"};
		ff.findReplaceString(S, indexes, sources, targets);
	}

}
