package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]
 * @author liang
 *
 */
public class BinaryTreeLevelOrderTraversalII_107 {

	/**
	 * 与102题证号相反。使用队列 每次放一行，用两个变量设置当前行和下一行的节点数
	 * @param root
	 * @return
	 */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	 if(root == null)
    		 return res;
    	 Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
    	 queue.add(root);
    	 int curCnt = 1;//当前行有的个数
    	 int nextCnt = 0;//下一行有的个数
    	 
    	 ArrayList<Integer> levelres = new ArrayList<Integer>();  
    	 while(!queue.isEmpty()) {
    		 TreeNode cur = queue.poll();
    		 curCnt--;
    		 levelres.add(cur.val);
    		 if(cur.left!=null) {
    			 queue.add(cur.left);
    			 nextCnt++;
    		 }
    		 if(cur.right!=null) {
    			 queue.add(cur.right);
    			 nextCnt++;
    		 }
    		 if(curCnt  == 0) {
    			 curCnt = nextCnt;
    			 nextCnt = 0;
    			 res.add(0,levelres);//每回加在头部就是倒序了
    			 levelres= new ArrayList<Integer>(); 
    		 }
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
