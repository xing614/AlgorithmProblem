package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。
 * @author liang
 *
 */
public class WordLadder_127 {

	
	/**
	 * 思路：
	 * 题目要求从beginWord开始，每次改变一个字母后的单词在字典wordList中，改变数次后变成endWord
	 * 使用广度优先搜索，维持两个集合visited（用来保存广度搜索到的元素）和wordset（用来保存还未搜索的元素）
	 * 例如最初为hit->改变一个元素成hot->改变一个元素成lot或dot(这时visited保存的是hit hot lot dot)->改变一个成log或dog(这时visited保存的是hit hot lot dot log dog)-》改变一个成cog
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		
		Set<String> wordset = new HashSet<String>(wordList);
		Set<String> visited = new HashSet<String>();//保存遍历到的数据
		visited.add(beginWord);
		int dist = 1;
		while(!visited.contains(endWord)) {
			Set<String> temp = new HashSet<String>();//中间保存
			for(String word:visited) {
				for(int i = 0;i<word.length();i++) {
					char[] wordString = word.toCharArray();
					for(int j = (int)'a';j<(int)'z';j++) {
						wordString[i] = (char)j;
						String ws = new String(wordString);
						if(wordset.contains(ws)) {
							temp.add(ws);
							wordset.remove(ws);
						}
					}
				}
			}
			if(temp.size() == 0)
				return 0;
			dist++;
			visited = temp;
		}
		return dist;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ls = new ArrayList<String>();
		ls.add("hot");
		ls.add("dot");
		ls.add("dog");
		ls.add("lot");
		ls.add("log");
		ls.add("cog");
		System.out.println(ladderLength("hit","cog",ls));
	}

}
