package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 117. 填充同一层的兄弟节点 II
给定一个二叉树

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

说明:

你只能使用额外常数空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
示例:

给定二叉树，

     1
   /  \
  2    3
 / \    \
4   5    7
调用你的函数后，该二叉树变为：

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
 * @author liang
 *
 */
public class PopulatingNextRightPointersInEachNode2_117 {
	/**
	 * 类似使用队列，front用于保存每行的所有节点，next用于存储front下一行的所有节点，然后每一行的前一个节点Next=下一个节点
	 * @param root
	 */
    public void connect(TreeLinkNode root) {
    	List<TreeLinkNode> front = new LinkedList<TreeLinkNode>(); 
    	if(root == null) return; 
    	front.add(root); 
    	while(front.size() != 0){ 
    		List<TreeLinkNode> next = new LinkedList<TreeLinkNode>(); 
    		TreeLinkNode node = null; /*相当于把数组变成链表*/ 
    		for(int i = 1; i < front.size(); i++){ 
    			front.get(i - 1).next = front.get(i); 
    		} 
    		front.get(front.size() - 1).next = null; 
    		for(TreeLinkNode current: front){ 
    			if(current.left != null) 
    				next.add(current.left); 
    			if(current.right != null) 
    				next.add(current.right); 
    		} 
    		front = next;/*交接*/ 
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left, right, next;
	    TreeLinkNode(int x) { val = x; }
	}

}
