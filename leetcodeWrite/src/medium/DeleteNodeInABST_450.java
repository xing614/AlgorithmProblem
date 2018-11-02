package medium;
/**
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

示例:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。

    5
   / \
  2   6
   \   \
    4   7
 * @author liang
 *
 */
public class DeleteNodeInABST_450 {
	/**
	 * 递归
	 * 因为递归是可以回溯的, 所以不需要记录父节点. 然后考虑删除以后节点的替换. 有四种替换方式:
	 * 1. 如果要删除的节点有左孩子, 则可以直接让左孩子替换其位置, 并且让左孩子的右子树连接到要删除节点的右孩子的最左端
	 * 2. 如果要删除的节点有右孩子, 则可以让右孩子替换其位置, 并且让右孩子的左子树连接到要删除节点的左孩子的最右端
	 * 3. 如果要删除的节点有左孩子, 则可以取左孩子的最右节点替换要删除的节点
	 * 4. 如果要删除的节点有右孩子, 则可以去右孩子的最左节点替换要删除的节点.
	 * 
	 * 用了方案三
	 * @param root
	 * @param key
	 * @return
	 */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        	return root;
        if(root.val > key) {
        	root.left = deleteNode(root.left, key);
        }
        else if(root.val < key) {
        	root.right = deleteNode(root.right,key);
        }else {
        	if(root.left == null)
        		return root.right;
        	if(root.right == null)
        		return root.left;
        	TreeNode tp = findLeftMax(root.left);//获取它左子树的最右子树 ，即左子树最大值
        	root.val = tp.val;//该位置值替换为左子树最大值
        	root.left = deleteNode(root.left, root.val);
        }
        return root;
    }
    
    private TreeNode findLeftMax(TreeNode root) {
		// TODO Auto-generated method stub
    	while(root.right !=null)
    		root = root.right;
		return root;
	}

	public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
