package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 与所有单词相关联的字串
 * 
 * 给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。

注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

示例 1:

输入:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出: [0,9]
解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
示例 2:

输入:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
输出: []
 * @author liang
 *
 */
public class SubStringWithConcatenationOfAllWords {

	/**
	 * 维护保存一个字典，使用滑动窗口式
	 * words每个单词长度一样，外层循序只许循环words.length次，每次指针挪一次，每一次循环遍历整个字符串
	 * 内层循环每次遍历一个单词，把整个S字符串遍历检查
	 * 需要在每次大循环维护一个count，看是不是达到了给的字典字符串数量，
	 * 同时维护一个index，是每个符合条件的字符串的起始index，需要存到返回结果中
	 * 为了能够检查是不是合格字符串，在这里维护一个curDict的HashMap
	 * 
	 * 
	 * 首先检查一个单词是不是在原始字典中出现，没出现的话说明这个单词肯定不符合标准，index指针指向下一个单词的起始点，计数器和curDict都要清零。
	 * 如果这个单词在原始字典里出现过，用更新原始字典的方法更新curDict，如果这个单词出现的次数没有超过原始字典里记录的次数，那么count++，如果超过了，就需要挪动指针，并把超过的从curDict删掉。
	 * 最后，如果count达到了L的length，说明找到了一个合格的字符串，那么将index存入返回结果res中，再把index挪到下一个单词处，更新curDict即可
	 * 
	 *******重点这句话： 维护一个字典，然后保证目前的串包含字典里面的单词有且仅有一次。思路仍然是维护一个窗口，如果当前单词在字典中，则继续移动窗口右 端，否则窗口左端可以跳到字符串下一个单词了
	 * @param s
	 * @param words
	 * @return
	 */
    public static List<Integer> findSubstring(String s, String[] words) {
    	ArrayList<Integer> res = new ArrayList<Integer>();//用于保存返回结果
    	if(s == null || words == null || s.length() == 0 || words.length == 0) {
    		return null;
    	}
    	int wordLen = words[0].length();//每个单词的长度一样，
    	
    	HashMap<String,Integer> dict = new HashMap<String,Integer>();//字典，用于保存每个单词和其对应在words中出现的次数
    	for(String word:words) {
    		if(!dict.containsKey(word)) {
    			dict.put(word, 1);
    		}else {
    			dict.put(word, dict.get(word)+1);
    		}
    	}
    	
    	for(int i=0;i<wordLen;i++) {//外层循环，每次循环遍历整个字符串
    		int count = 0;//保存选定字符串中已经出现的单词的个数，如果与words.length相同，表示字符串包含了所有单词，就可以返回index了
    		int index = i;//符合条件的字符串的起始位置
    		HashMap<String,Integer> curdict = new HashMap<String,Integer>();//当前字典，用于保存当前选定字符串包含的word和出现的次数
    		//如最初数据是123456789，单词长度为2；则第一次从1开始，判断12是不是，不是的话再从3开始判断34是不是；第二次大循环从2开始，判断23是不是，不是的话判断45是不是
    		for(int j=i;j<=s.length()-wordLen;j+=wordLen) {
    			String curword = s.substring(j, j+wordLen);//长度为wordlen的word
    			if(!dict.containsKey(curword)) {//表示这个选定的word不在字典dict中，则移动窗口左端
    				curdict.clear();
    				count = 0;
    				index = j+wordLen;//指向下一个单词的起点
    			}else {//表示选定的word在字典中，则可以判断然后移动窗口右端
    				//在curdict装载curword
    				if(!curdict.containsKey(curword)) {
    					curdict.put(curword, 1);
    				}else {
    					curdict.put(curword, curdict.get(curword)+1);
    				}
    				//判断选定的curword出现次数是否超过dict中记录的次数
    				if(curdict.get(curword)<=dict.get(curword)) {
    					count++;
    				}else {//如果超过了，就需要挪动指针，并把超过的从curDict删掉。
    					//相当于在s中选中的字符串index前移了，直到多余重复的word被去掉，
    					//比如s为123245，word为234。本身左右窗口内的数据为23，右窗口移动是变成232，这是index前移，窗口内变为32
    					while(curdict.get(curword)>dict.get(curword)) {
    						String temp = s.substring(index,index+wordLen);
    						curdict.put(temp, curdict.get(temp)-1);//curdict去掉左窗口右移后弹出的左侧数据-1
    						index = index +wordLen;//左窗口右移wordLen
    					}
    				}
    				
    				if(count==words.length) {//表示words所有数据都在选定的字符串中出现了
    					res.add(index);
    					//准备左窗口右移动，寻找下一个符合条件的字符串
    					String temp = s.substring(index, index + wordLen);
    					curdict.put(temp, curdict.get(temp)-1);
    					index = index + wordLen;
    					count--;
    				}
    				
    			}
    		}
    		
    	}
		return res;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "barfoothefoobarman";
		String[] words = new String[]{"word","good","best","word"};
		System.out.println(findSubstring(s,words));
	}

}
