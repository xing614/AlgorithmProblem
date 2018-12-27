package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。

添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。

将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。

如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。

示例 1:

输入: 
二叉树如下所示:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

输出: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   

示例 2:

输入: 
二叉树如下所示:
      4
     /   
    2    
   / \   
  3   1    

v = 1

d = 3

输出: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1
注意:

输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。
输入的二叉树至少有一个节点。
 * @author liang
 *
 */
public class AddOneRowtoTree_623 {
	/**
	 * 使用队列每次压入一个节点的左子树，循环，直到找到第d-1层，然后加入v节点
	 * @param root
	 * @param v
	 * @param d
	 * @return
	 */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d ==1) {
        	TreeNode tn = new TreeNode(v);
        	tn.left = root;
        	return tn;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int cur = 1;
        while(que.size() !=0) {
        	if(cur == d-1) {
        		for(TreeNode p:que) {
            		TreeNode pleft = new TreeNode(v);
            		TreeNode pright = new TreeNode(v);
            		pleft.left = p.left;
            		p.left = pleft;
            		pright.right = p.right;
            		p.right = pright;
        		}
        		return root;
        	}else {//没到d-1层 就队列压入
        		int size = que.size();
        		for(int i=0;i<size;i++) {
        			TreeNode poll = que.poll();
        			if(poll.left!=null) {
        				que.add(poll.left);
        			}
        			if(poll.right!=null) {
        				que.add(poll.right);
        			}
        		}
        		cur++;
        	}
        }
        return root;
    }
    
    public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
