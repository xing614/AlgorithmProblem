package easy;
/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * @author liang
 *
 */
public class InvertBinaryTree_226 {
	/**
	 * 遇到树 就直接想递归
	 * @param root
	 * @return
	 */
    public TreeNode invertTree(TreeNode root) {
        if(root ==null)
        	return root;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        //交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}
