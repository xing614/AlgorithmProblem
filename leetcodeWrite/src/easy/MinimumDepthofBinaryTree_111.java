package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 *111. 二叉树的最小深度、
 *给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.
 * @author liang
 *
 */
public class MinimumDepthofBinaryTree_111 {

	/**
	 * 方法有两种。1是递归，每次找min，如果root为空 返回0，左子树为空，则确定右子树最小深度，反之求左子树最小深度，都不为空则看两个子树哪个最浅。方法2 使用队列，找到第一个叶子节点
	 * @param root
	 * @return
	 */
    public int minDepth(TreeNode root) {
        if(root == null )
        	return 0;
        if(root.left == null)
        	return minDepth(root.right);
        if(root.right == null)
        	return minDepth(root.left);
        return 1+Math.min(minDepth(root.left), minDepth(root.right));
    }
    
    public int minDepth2(TreeNode root) {
    	if(root ==null)
    		return 0;
    	int res = 0;
    	LinkedList<TreeNode> que = new LinkedList<>();
    	que.add(root);
    	while(!que.isEmpty()) {
    		++res;
    		int size = que.size();
    		for(int i=0;i<size;i++) {
    			TreeNode tn = que.poll();
        		if(tn.left == null && tn.right == null) {
        			return res;
        		}
        		if(tn.left !=null) {
        			que.add(tn.left);
        		}
        		if(tn.right != null) {
        			que.add(tn.right);
        		}
    		}
    	}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
