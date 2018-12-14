package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。

示例 1:

输入:

    2
   / \
  1   3

输出:
1
 

示例 2:

输入:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

输出:
7
 

注意: 您可以假设树（即给定的根节点）不为 NULL。
 * @author liang
 *
 */
public class FindBottomLeftTreeValue_513 {
	/**
	 * bfs
	 * 使用队列，
	 * 先推入根节点，然后每次先推右子树再推左子树，最后剩下最后一个元素
	 * @param root
	 * @return
	 */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
        	root = que.poll();
        	if(root.right!=null)
        		que.add(root.right);
        	if(root.left!=null)
        		que.add(root.left);
        }
        return root.val;
    }
    
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
