package easy;
/**
 * 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
示例 2:

输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
示例 3:

输入:       1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

输出: false
 * @author liang
 *
 */
public class SameTree_100 {

	/**
	 * 递归 判断当前结点值是否相等平；如果相等就再比较其左右子树，只有当所有的结点都相等才相等
	 * @param p
	 * @param q
	 * @return
	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        	return true;
        if((p!= null && q == null)||(p == null && q!= null))
        	return false;
        return p.val == q.val &&isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
