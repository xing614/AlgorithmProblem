package medium;
/**
 * 208. 实现 Trie (前缀树)
题目描述提示帮助提交记录社区讨论阅读解答
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
 * @author liang
 *
 */
public class ImplementTree_208 {

	/**
	 * 标准 Trie树的查找：

       对于英文单词的查找，我们完全可以在内部结点中建立26个元素组成的指针数组。如果要查找a，只需要在内部节点的指针数组中找第0个指针即可(b=第1个指针，随机定位)。时间复杂度为O(1)。

      查找过程：假如我们要在上面那棵Trie中查找字符串bull (b-u-l-l)。

      (1) 在root结点中查找第('b'-'a'=1)号孩子指针，发现该指针不为空，则定位到第1号孩子结点处——b结点。

      (2) 在b结点中查找第('u'-'a'=20)号孩子指针，发现该指针不为空，则定位到第20号孩子结点处——u结点。

      (3) ... 一直查找到叶子结点出现特殊字符'$'位置，表示找到了bull字符串

      如果在查找过程中终止于内部结点，则表示没有找到待查找字符串。
	 */
	
	private TrieNode root;
	
    /** Initialize your data structure here. */
    public ImplementTree_208() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = this.root;
        for(char c:word.toCharArray()) {
        	if(node.children[c-'a']==null) {//说明这个节点之前没有过数据
        		node.children[c-'a']=new TrieNode();
        	}
        	node = node.children[c-'a'];
        }
        node.item = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = this.root;
        for(char c:word.toCharArray())
        {
     	   if(node.children[c-'a']==null)
     	   {
     		   return false;
     	   }
     	   node=node.children[c-'a'];
        }
        return node.item.equals(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
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
    
    class TrieNode {
    	//存储子节点
    	TrieNode[]  children=new TrieNode[26];
    	//存储一条记录，即对应一个单词
    	String item="";
        // Initialize your data structure here.
        public TrieNode() {
            
        }
    }
    


}
