package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。

返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

示例 1：

输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
 

示例 2：

输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。
 

注意：

假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
输入的单词均由小写字母组成。
 

扩展练习：

尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 * @author liang
 *
 */
public class TopKFrequentWords_692 {
	/**
	 * 使用hashmap保存 word和出现的次数；使用优先队列比较器比较 word的顺序 根据出现次数和第一个字符；使用list依次保存优先队列的前k个key
	 * @param words
	 * @param k
	 * @return
	 */
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();//保存word 和出现次数
        for(String word:words) {
        	map.put(word, map.getOrDefault(word, 0)+1);
        }
        //使用一个优先队列 比较出现次数和字符串前后顺序
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
    		(a, b) -> (a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue())
		);
        for(Map.Entry<String,Integer> entry:map.entrySet()) {
        	pq.offer(entry);//放入每个entry
        }
        while(k--!=0)
        	res.add(pq.poll().getKey());//放入k个key
        return res;
    }
}
