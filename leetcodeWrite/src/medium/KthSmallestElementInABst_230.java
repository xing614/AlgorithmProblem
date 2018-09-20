package medium;

import java.util.Stack;

/**
 * 230. 二叉搜索树中第K小的元素
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
进阶：
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？


 * @author liang
 *
 */
public class KthSmallestElementInABst_230 {

	private TreeNode ts;
	private int count = 0;
	/**
	 * 中序遍历
	 * @param root
	 * @param k
	 * @return
	 */
    public int kthSmallest(TreeNode root, int k) {
    	
		inOrder(root,k);
		return ts.val;
    }
    
	private void inOrder(TreeNode node, int k) {
		if(node == null)
			return;
		inOrder(node.left,k);
		if(++count == k) {
			ts = node;
			return;
		}
		inOrder(node.right, k);
	}

	/**
	 * 可以使用迭代，栈
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest2(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		while(root != null && !stack.isEmpty()) {
			if(root!=null) {
				stack.push(root);//压栈root
				root = root.left;
			}else {
				root = stack.pop();
				if(--k == 0) {
					return root.val;
				}
				root = root.right;
			}
		}
		// 此题k输入合法，不会到达这里
		return Integer.MIN_VALUE;
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
