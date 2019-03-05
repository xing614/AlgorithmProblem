package medium;
/**
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。

例如, 

给定二叉搜索树:

        4
       / \
      2   7
     / \
    1   3

和 插入的值: 5
你可以返回这个二叉搜索树:

         4
       /   \
      2     7
     / \   /
    1   3 5
或者这个树也是有效的:

         5
       /   \
      2     7
     / \   
    1   3
         \
          4
 * @author liang
 *
 */
public class InsertintoaBinarySearchTree_701 {

	/**
	 * 直接从左/右往下找就找到位置即可
	 * @param root
	 * @param val
	 * @return
	 */
    public TreeNode insertIntoBST(TreeNode root, int val) {
    	if(root == null)
    		return new TreeNode(val);
    	if(root.val>val)
    		root.left = insertIntoBST(root.left, val);
    	else
    		root.right = insertIntoBST(root.right, val);
		return root;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}