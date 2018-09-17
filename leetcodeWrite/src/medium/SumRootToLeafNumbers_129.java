package medium;
/**
 * 129. 求根到叶子节点数字之和
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

示例 1:

输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
示例 2:

输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.
 * @author liang
 *
 */
public class SumRootToLeafNumbers_129 {

	/**
	 * 递归
	 * 节点可能出现的情况: 
	 * (1)左孩子或者右孩子两个都为NULL(叶节点)，此时递归返回。
	 * (2)左孩子或者右孩子某一个为NULL，此时继续推进下一层调用，只是在下一层中，会发现有一个为NULL节点，走到NULL节点当然应该返回了。
	 * (3)左孩子或者右孩子都不为NULL，此时继续推进下一层的调用。
	 * 虽然(2)和(3)都是继续推进下一层的调用，但是由于(2)会遇到NULL节点，对于这个特殊情况，需要写句话处理一下。
	 * @param root
	 * @return
	 */
    public int sumNumbers(TreeNode root) {
        return _sum(root,0);
    }
    
	private int _sum(TreeNode root, int sum) {
		// TODO Auto-generated method stub
		if(root == null)
			return 0;
		sum = sum*10+root.val;
		if(root.left == null && root.right == null)
			return sum;
		return _sum(root.left,sum)+_sum(root.right,sum);
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
