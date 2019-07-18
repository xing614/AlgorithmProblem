package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例:

输入: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

输出: ["eat","oath"]
说明:
你可以假设所有输入都由小写字母 a-z 组成。

提示:

你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * @author liang
 *
 */
public class WordSearchII_212 {
	//使用set存储，为了避免board中重复字母导致重复的词
	Set<String> res=new HashSet<String>();
		
	/**
	 * 使用前缀树，当发现当前字符串不是要找任何字符串的前缀的时候，就可以结束搜索。这样可以大大降低搜索的复杂度
	 * @param board
	 * @param words
	 * @return
	 */
    public List<String> findWords(char[][] board, String[] words) {
    	//为了快速地检索单词，使用前缀树
    	Trie trie=new Trie();
    	for(String w:words)//在前缀树中保存所有要搜索的单词
    	{
    		trie.insert(w);
    	}
    	int m=board.length;
    	if(m<1) return new ArrayList<String>(res);
    	int n=board[0].length;
    	boolean[][] visited=new boolean[m][n];
    	for(int i=0;i<m;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			findWords(board,visited,"",i,j,trie);
    		}
    	}
       
    	return new ArrayList<String>(res);

    }
    
    /**递归的查找单词 dfs*/
    public void findWords(char[][] board,boolean[][] visited,String str,int x,int y ,Trie trie)
    {
    	if(x<0||x>=board.length||y<0||y>=board[0].length)
    		return;
    	if(visited[x][y]) return;
    	String newstr=str+board[x][y];
    	if(!trie.startsWith(newstr))
    		return;
    	if(trie.search(newstr))
    	{
    		res.add(newstr);
    	}
    	visited[x][y]=true;
    	findWords(board,visited,newstr,x-1,y,trie);
    	findWords(board,visited,newstr,x+1,y,trie);
    	findWords(board,visited,newstr,x,y-1,trie);
    	findWords(board,visited,newstr,x,y+1,trie);
    	visited[x][y]=false;//注意回溯
    }

    
    
    class TrieNode {
    	//存储子节点
    	TrieNode[]  children=new TrieNode[26];
    	//存储一条记录，即对应一个单词
    	String item="";
        // Initialize your data structure here.
        public TrieNode() {
            
        }
    }
     
    /**
     * 前缀树
     * @author liang
     *
     */
    public class Trie {
        private TrieNode root;
     
        public Trie() {
            root = new TrieNode();
        }
     
        // Inserts a word into the trie.
        public void insert(String word) {
           TrieNode node=this.root;
           for(char c:word.toCharArray())
           {
        	   if(node.children[c-'a']==null)
        	   {
        		   node.children[c-'a']=new TrieNode();
        	   }
        	   node=node.children[c-'a'];
           }
           node.item=word;
            
        }
     
        // Returns if the word is in the trie.
        public boolean search(String word) {
        	TrieNode node=this.root;
            for(char c:word.toCharArray())
            {
         	   if(node.children[c-'a']==null)
         	   {
         		   return false;
         	   }
         	   node=node.children[c-'a'];
            }
            //注意需要判断搜索截止位置是前缀还是一个单词
            return node.item.equals(word);
        }
     
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
        	TrieNode node=this.root;
            for(char c:prefix.toCharArray())
            {
         	   if(node.children[c-'a']==null)
         	   {
         		   return false;
         	   }
         	   node=node.children[c-'a'];
            }
            return true;
        }
     
    }
}
