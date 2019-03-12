package easy;

import java.util.Stack;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 * @author liang
 *
 */
public class PathSum_112 {

	/**
	 * dfs+栈
	 * @param root
	 * @param sum
	 * @return
	 */
    public boolean hasPathSum(TreeNode root, int sum) {
    	if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> sums = new Stack<Integer>();
        stack.push(root);
        sums.push(sum);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int value = sums.pop();
            if (node.left == null && node.right == null && node.val == value) {
                return true;
            }
            if (node.left != null) {
                stack.push(node.left);
                sums.push(value - node.val);
            }
            if (node.right != null){
                stack.push(node.right);
                sums.push(value - node.val);
            }
        }
        return false;

    }
    
    /**
     * 递归
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
