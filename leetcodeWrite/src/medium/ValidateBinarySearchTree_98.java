package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
 * @author liang
 *
 */
public class ValidateBinarySearchTree_98 {

	/**
	 * 简单思路，先中序遍历，然后在检查数组是否有序和是否有重复
	 * @param root
	 * @return
	 */
    public boolean isValidBST(TreeNode root) {
        if(root==null)
        	return true;
        List<Integer> li = new ArrayList<Integer>();
        midOrderTraversal(root,li);
        for(int i=1;i<li.size();i++) {
        	if(li.get(i)<=li.get(i-1))
        		return false;
        }
        return true;
    }
    
	private void midOrderTraversal(TreeNode root, List li) {
		// TODO Auto-generated method stub
		if(root==null)return;
		midOrderTraversal(root.left, li);
		li.add(root.val);
		midOrderTraversal(root.right, li);
	}

	/**
	 * 第二种使用栈
	 * @param root
	 * @return
	 */
	public boolean isValidBST2(TreeNode root) {
		   if (root == null) return true;
		   Stack<TreeNode> stack = new Stack<>();
		   TreeNode pre = null;
		   while (root != null || !stack.isEmpty()) {
		      while (root != null) {
		         stack.push(root);
		         root = root.left;
		      }
		      root = stack.pop();
		      if(pre != null && root.val <= pre.val) return false;
		      pre = root;
		      root = root.right;
		   }
		   return true;
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
