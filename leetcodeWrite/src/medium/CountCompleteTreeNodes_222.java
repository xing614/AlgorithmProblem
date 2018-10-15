package medium;
/**
 * 222. 完全二叉树的节点个数
给出一个完全二叉树，求出该树的节点个数。

说明：

完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

示例:

输入: 
    1
   / \
  2   3
 / \  /
4  5 6

输出: 6
 * @author liang
 *
 */
public class CountCompleteTreeNodes_222 {

	/**
	 * 如果直接return countNodes(root.left) + countNodes(root.right) + 1;会时间超时
	 * 满二叉树有一个性质是节点数等于2^h-1,h为高度，所以可以这样判断节点的左右高度是不是一样，
	 * 如果是一样说明是满二叉树，就可以用刚才的公式，如果左右不相等就递归计算左右节点
	 * @param root
	 * @return
	 */
    public int countNodes(TreeNode root) {
        if(root == null)
        	return 0;
        else {
        	int left = getLeftHeight(root);
        	int right = getRightHeight(root);
        	if(left == right) {
        		return (1<<left)-1;//2^h-1
        	}else {
        		return countNodes(root.left)+countNodes(root.right)+1;
        	}
        }
    }
    
	private int getRightHeight(TreeNode root) {
		int count = 0;
		while(root!=null) {
			count++;
			root = root.right;
		}
		return count;
	}

	private int getLeftHeight(TreeNode root) {
		int count = 0;
		while(root!=null) {
			count++;
			root = root.left;
		}
		return count;
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
