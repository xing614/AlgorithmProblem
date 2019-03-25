package easy;
/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
 * @author liang
 *
 */
public class SymmetricTree_101 {

	/**
	 * 使用递归判断 每个 r1左|r2右  和 r1右|r2左
	 * @param root
	 * @return
	 */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }
    
	private boolean isSymmetric(TreeNode r1, TreeNode r2) {
		// TODO Auto-generated method stub
		if(r1 == null && r2 == null){
            return true;
        }
        if(r1 == null || r2 == null){
            return false;
        }
        if(r1.val != r2.val){
            return false;
        }
        return isSymmetric(r1.right,r2.left) && isSymmetric(r1.left, r2.right);
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
