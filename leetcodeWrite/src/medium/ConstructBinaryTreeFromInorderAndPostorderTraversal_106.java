package medium;
/**
 * 106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

 * @author liang
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {

	/**
	 * 后序遍历的最后一个元素就是树的根结点(值为r)，在中序遍历的序列中找值为r的位置idx，idx将中序遍历序列分为左右两个子树，对应可以将后序遍历的序列分在两个子树，递归对其进行求解
	 * @param inorder
	 * @param postorder
	 * @return
	 */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	// 参数检验
        if (inorder == null || postorder == null || inorder.length == 0
                || inorder.length != postorder.length) {
            return null;
        }

        // 构建二叉树
        return solve(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    /**
     * 
     * @param inorder 中序遍历结果
     * @param x	中序遍历开始位置
     * @param y	中序遍历结束位置
     * @param postorder后续遍历
     * @param i	后序遍历开始位置
     * @param j 后序遍历结束位置
     * @return
     */
	private TreeNode solve(int[] inorder, int x, int y, int[] postorder, int i, int j) {
		if(x>=0&&x<=y&&i>=0&&i<=j) {
			if(x == y) {//只有一个元素，或j==i
				return new TreeNode(postorder[j]);
			}else if(x<y) {
				//根节点
				TreeNode root = new TreeNode(postorder[j]);
				
				//在中序遍历中查找根节点位置
				int index = getIndexInInorder(inorder, root.val);
				//左子树非空创建左子树
				int lenL = index -x;
				if(lenL>0) {
					root.left = solve(inorder, x, index-1, postorder, i, i+lenL-1);
				}
				int lenR = y-index;
				if(lenR>0) {
					root.right = solve(inorder, index+1, y, postorder, i+lenL, j-1);
				}
				return root;
			}else {
				return null;
			}
		}
		return null;
	}

	//获得val值在inorder中的下标
	public int getIndexInInorder(int[] inorder, int val) {
		for(int i=0;i<inorder.length;i++) {
			if(val == inorder[i])
				return i;
		}
		return -1;
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
