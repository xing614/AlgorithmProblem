package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 * @author liang
 *
 */
public class GroupAnagrams_49 {

	/**
	 * abc cba acb每个字符串重排序后会成为相同的字符串，将该字符串成为key，，将所有错位词都保存到字符串数组中，建立key和字符串数组之间的映射，最后再存入结果res中即可
	 * @param strs
	 * @return
	 */
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	HashMap<String,List<String>> hm = new HashMap<String,List<String>>();
    	for(int i=0;i<strs.length;i++) {
    		String so = sortString(strs[i]);
    		if(hm.containsKey(so)) {
    			hm.get(so).add(strs[i]);
    		}else {
    			List<String> li = new ArrayList<String>();
    			li.add(strs[i]);
    			hm.put(so, li);
    		}
    	}
    	for(List<String> li:hm.values()) {
    		res.add(li);
    	}
		return res;
        
    }
    
    public String sortString(String st) {
    	char[] charArray = st.toCharArray();
    	for(int i=0;i<charArray.length;i++) {
    		for(int j=i;j<charArray.length;j++) {
    			if(charArray[i]<charArray[j]) {
    				char tmp = charArray[i];
    				charArray[i] = charArray[j];
    				charArray[j] = tmp;
    			}
    		}
    	}
    	return new String(charArray);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupAnagrams_49 ga = new GroupAnagrams_49();
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		ga.groupAnagrams(strs);
	}

}
