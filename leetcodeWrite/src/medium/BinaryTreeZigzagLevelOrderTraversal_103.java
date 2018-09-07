package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

 * @author liang
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	 List<List<Integer>> res = new ArrayList<List<Integer>>();
    	 if(root == null)
    		 return res;
    	 LinkedList<TreeNode> queue = new LinkedList<TreeNode>();//队列，先进先出一行
    	 queue.add(root);
    	 int num = 0;
    	 boolean reverse = false;//是否翻转
    	 while(!queue.isEmpty()) {
    		 num = queue.size();//每一行的数量
    		 List<Integer> lever = new ArrayList<Integer>();//临时存储一行,用来放入res
    		 for(int i = 0; i<num; i++){
    			 TreeNode node = queue.poll();//取出第一个
    			 lever.add(node.val);
    			 if(node.left!=null)
    				 queue.add(node.left);
    			 if(node.right!=null)
    				 queue.add(node.right);
    		 }
    		 if(reverse) {//lever要翻转
    			 Collections.reverse(lever);
    			 reverse = false;
    		 }else {
    			 reverse = true;
    		 }
    		 res.add(lever);
    	 }
		return res;
        
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
