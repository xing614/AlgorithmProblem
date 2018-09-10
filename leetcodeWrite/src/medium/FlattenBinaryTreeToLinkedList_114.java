package medium;

import java.util.Stack;

/**
 * 114. 二叉树展开为链表
给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 * @author liang
 *
 */
public class FlattenBinaryTreeToLinkedList_114 {

	/**
	 * 就是先序遍历变成链表
	 * 可以使用栈
	 * 对整棵树一直向右子树方向遍历。
	 * 当遍历的节点有右孩子时，就将其入栈。
	 * 有左孩子时，将其更新为当前节点的右孩子，左孩子置空。
	 * 当左孩子为空时而栈不空时，就弹出栈，作为右孩子。
	 * @param root
	 */
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p!=null || !stack.empty()) {
        	//先将每个当前节点的right放入栈，当当前节点左子树是空时，再弹出这栈里的数据，塞到右子树中
        	if(p.right!=null) {
        		stack.push(p.right);
        	}
        	if(p.left!=null) {//左子树不为空就将左子树接到右子树位置，让左子树之后都为空
        		p.right = p.left;
        		p.left = null;
        	}else if(!stack.empty()) {
        		TreeNode tmp = stack.pop();
        		p.right = tmp;
        	}
        	p = p.right;
        }
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

}
