package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 451.根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:

输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:

输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:

输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。
 * @author liang
 *
 */
public class SortCharactersByFrequency_451 {
	/**
	 * 设计一个类，用于存储每个字符出现的次数和保存的字符是什么
	 * @param s
	 * @return
	 */
    public String frequencySort(String s) {
    	Map<Character,Product> hm = new HashMap<Character,Product>();//key是字符
    	List<Product> li = new ArrayList<Product>();//用来存储Product，并对其进行排序
    	for(char item:s.toCharArray()) {
    		if(hm.containsKey(item)) {//在hm中已经保存，就+1
    			Product product = hm.get(item);
    			product.sb.append(item);
    			product.count++;
    		}else {
    			Product product = new Product();
    			product.count = 1;
    			product.sb.append(item);
    			li.add(product);
    			hm.put(item, product);
    		}
    	}
    	//进行比较
    	Collections.sort(li,new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return o2.count-o1.count;
			}
    		
    	});
    	StringBuffer sb = new StringBuffer();
    	for(Product pro:li) {
    		sb.append(pro.sb);
    	}
        return sb.toString();
    }
    
    class Product{
    	int count;
    	StringBuffer sb = new StringBuffer("");
    }
    /**
     * list数组按顺序构造
     * @param s
     * @return
     */
    public String frequencySort2(String s) {
    	int len = s.length();
    	List<String>[] sortList = new LinkedList[len+1];//在每个list数组中放LinkedList<String>()，存储当前位置出现次数对应的字符
    	Map<String,Integer> hash = new LinkedHashMap<>();//key 出现的字符，value出现几次
    	StringBuffer res = new StringBuffer();
    	//存储出现次数
    	for(int i=0;i<len;i++) {
    		String key = ""+s.charAt(i);
    		hash.put(key,hash.getOrDefault(key, 0)+1);
    	}
    	for(Map.Entry<String, Integer>  entry:hash.entrySet()) {
    		Integer value = entry.getValue();
    		if(sortList[value] == null) {
    			sortList[value] = new LinkedList<String>();
    		}
    		sortList[value].add(entry.getKey());//出现value次的字符 存储进
    	}
    	for(int i =len;i>0;i--) {
    		if(sortList[i] == null) {
    			continue;
    		}
    		int lenSort = sortList[i].size();
    		for(int j=0;j<len;j++) {
    			String val = sortList[i].get(j);
    			for(int k = 0; k < i;k++){
    				res.append(val);
                }
    		}
    	}
    	return res.toString();
    }
}
