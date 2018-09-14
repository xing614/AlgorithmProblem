package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 211. 添加与搜索单词 - 数据结构设计
题目描述提示帮助提交记录社区讨论阅读解答
设计一个支持以下两种操作的数据结构：

void addWord(word)
bool search(word)
search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。

示例:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
说明:

你可以假设所有单词都是由小写字母 a-z 组成的。
 * @author liang
 *
 */
public class AddAndSearchWord_DataStructureDesign_211 {

	/**
	 * 使用字典树
	 */
	//字典树的变形，每个节点保存一个字符，以及子节点集合：list，和标记是否是尾节点的isEnd布尔值
    //add和search方法都利用递归进行实现
	static class Node{
		public Character val;
		public List<Node> children;
		public boolean isEnd;
		public Node(Character val) {
			this.val = val;
			children = new ArrayList<Node>();
			isEnd = false;
		}
	}
	
	private Node root;
	
	
    /** Initialize your data structure here. */
    public AddAndSearchWord_DataStructureDesign_211() {
        root = new Node('/');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        addWord(word,root);
    }
    
    private void addWord(String word, Node root) {
    	if(word.length() == 0) {
    		root.isEnd = true;
    		return;
    	}
    	Node cur = null;//代表匹配的新节点
    	if(root.children.size()>0) {
    		for(Node node:root.children) {
    			if(node.val == word.charAt(0)) {
    				cur = node;
    				break;
    			}
    		}
    	}
    	
    	if(cur!=null)//root没有符合的字符
    		addWord(word.substring(1),cur);//从word下一个位置查
    	else {
    		cur = new Node(word.charAt(0));
    		root.children.add(cur);//孩子列表添加这个节点
    		addWord(word.substring(1), cur);//然后节点遍历
    	}
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word,root);
    }
    
	private boolean search(String word, Node root) {
		
		if(word.length() == 0)
			return root.isEnd == true;
		if(root.children == null)
			return false;
		if(word.charAt(0) == '.') {//第一位是.
			for(Node node:root.children) {
				boolean ret = search(word.substring(1),node);
				if(ret) 
					return true;
			}
			return false;
		}else {
			for(Node node : root.children) {
				if(node.val == word.charAt(0)) {
					return search(word.substring(1),node);
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
