package medium;

/**
 * 105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 * @author liang
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

	/**
	 * 先序遍历的每个值表示的结点都是接下来的若干结点的父结点。
	 * 对中序遍历来说根结点一定在中间位置，中间左边是左子树，右边是右子树。
	 * 因为中序遍历中根节点左边为左子树，所以可以记录左子树的长度并在先序遍历中依据这个长度找到左子树的区间，用同样方法可以找到右子树的区间。 
	 * 递归
	 * @param preorder
	 * @param inorder
	 * @return
	 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder ==null || preorder.length == 0)
        	return null;
        if(inorder == null || inorder.length == 0)
        	return null;
        if(preorder.length != inorder.length)
        	return null;
        return build(preorder,inorder,0,0,preorder.length-1);
    }
    
    
	private TreeNode build(int[] preorder, int[] inorder, int preIndex, int startInIndex, int endInIndex) {

		if(endInIndex < startInIndex)
			return null;
		TreeNode node = new TreeNode(preorder[preIndex]);
	
		
		int index = getIndexInInorder(inorder, preorder[preIndex]);//获取每次的中间跟节点在Inorder位置
		int lenL = index - startInIndex;//该节点左子树长度
		int lenR = endInIndex - startInIndex - lenL;
		
		if (lenL > 0) {
		    node.left = build(preorder, inorder, preIndex + 1, startInIndex,index - 1);
		    //preorder当前点的左子树是inorder中从start到index-1，就再从preIndex + 1找起，因为这个左子树在先序遍历的左侧
		}
		if (lenR > 0) {
		    node.right = build(preorder, inorder, preIndex + lenL + 1,index + 1, endInIndex);
		    //preorder当前点的右子树是inorder中从index + 1到endInIndex，就再从preIndex + lenL+ 1找起，因为这个右子树在先序遍历的右侧
		}
	
	    return node;
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
