package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 126. 单词接龙 II
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回一个空列表。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: []

解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * @author liang
 *
 */
public class WordLadderII_126 {

	List<List<String>> res = new ArrayList<List<String>>();
	
	//保存一条结果
	List<String> tmp = new ArrayList<>();//一轮的结果
	/**
	 * 与127的区别时 返回所有最短可能，127是找到最短路径
	 * 为了找到每个单词的所有可用相邻单词组map<String,Set<String>>,从这里dfs找结果
	 * 思路：首先使用bfs广度搜索，Map<String,Set<String>>保存每一个单词的相邻单词，用一个Set<String> current存储当前层要bfs，一个Set<String> nextstep存储下一层bfs的数据，两个轮流替换，直到找到endword。一个Set<String>  unvisited存储未被使用的wordlist。最后使用dfs从endword搜索到beginword，翻转保存结果
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	//不在的元素不能算
        if(!wordList.contains(endWord)){
            return res;
        }
        
    	//用来保存每个单词的所有可用相邻单词
    	Map<String,Set<String>> map = new HashMap<>();
    	//保存当前层的单词
    	Set<String> current = new HashSet<>();
    	//还没有被使用的单词
    	Set<String> unvisited = new HashSet<>(wordList);
    	//移除begin
    	if(unvisited.contains(beginWord)) {
    		unvisited.remove(beginWord);
    	}
    	//unvisited.add(endWord);
    	//当前层加入起点
    	current.add(beginWord);
    	//如果当前层不包括尾节点且未被使用的不为空
    	while(!current.contains(endWord) && unvisited.size()>0) {
    		Set<String> nextStep = new HashSet<>();//下一层的所有节点
    		//遍历当前层所有节点，找到所有的下一层
    		for(String node:current) {
    			for(int i=0;i<node.length();i++) {
    				char[] nodeStr = node.toCharArray();//放在这是为了保证nodeStr[i] = (char)j;后 这个位置恢复成原来的字符
        			for(int j=(int)'a';j<(int)'z';j++) {
        				if(nodeStr[i] ==(char)j)
        					continue;
        				nodeStr[i] = (char)j;
        				String newStr = new String(nodeStr);
        				if(unvisited.contains(newStr)) {
        					nextStep.add(newStr);
        					//这里这里注意！！！！！！！！！！！！
        					//因为后面是反向搜索路径，所以这里应该在找到下一个相邻单词后，将当前单词存储在后一个单词的set中
        					if(map.containsKey(newStr)) {//如果map中包含newStr的相邻单词，则取出来set然后add然后再放回去
        						Set<String> set = map.get(newStr);//所以这里应该找newStr的
        						set.add(node);//然后存储的应该是当前层这个单词
        						map.put(newStr, set);
        					}else {
        						Set<String> set = new HashSet();
        						set.add(node);
        						map.put(newStr, set);
        					}
        				}
        			}
    			}
    		}
    		//下一层是空，则没有答案
    		if(nextStep.size() == 0)
    			return res;
    		//将下一层节点都在unvisited中删除
    		for(String node:nextStep) {
    			unvisited.remove(node);
    		}
    		current = nextStep;
    	}
    	
    	Set<Entry<String, Set<String>>> entrySet = map.entrySet();
    	Iterator<Entry<String, Set<String>>> iterator = entrySet.iterator();
    	while(iterator.hasNext()) {
    		Entry<String, Set<String>> next = iterator.next();
    		System.out.print(next.getKey()+"==");
    		for(String ne:next.getValue()) {
    			System.out.print(ne);
    		}
    		System.out.println();
    	}
    	//遍历完成该找路径了,使用dfs,倒序查找  保证一轮直接能找到路径
    	SearchPath(map,endWord,beginWord);
    	return res;
    }
    
    
    
    /**
     * 倒序 dfs找结果  最后翻转结果。根据反向邻接表寻找遍历路径
     * @param map
     * @param endWord
     * @param beginWord
     */
    private void SearchPath(Map<String, Set<String>> map, String start, String end) {
		// TODO Auto-generated method stub
		tmp.add(start);
		if(start.equals(end)) {
			List<String> re = new ArrayList<>(tmp);//这一轮的结果
			Collections.reverse(re);
			res.add(re);
			return;
		}else {
				Set<String> set = map.get(start);
				for(String node:set) {
					SearchPath(map,node,end);
					tmp.remove(tmp.size()-1);//也就是移除最后一个start
				}				

		}
	}




	/**
     * 判断两个字符串是否只有一个字符不一样
     * @param strA
     * @param strB
     * @return
     */
    public boolean isOneDiff(String strA,String strB) {
    	int count =0;
    	for(int i=0;i<strA.length();i++) {
    		if(strA.charAt(i)!=strB.charAt(i)) {
    			count++;
    			if(count>1)
    				return false;
    		}
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadderII_126 w = new WordLadderII_126();
		
		List<String> wordList  = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		//wordList.add("cog");
		System.out.println(w.findLadders("hit","cog" , wordList));
	}

}
