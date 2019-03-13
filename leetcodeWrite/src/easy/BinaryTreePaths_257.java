package easy;

import java.util.ArrayList;
import java.util.List;
/**
 * 257. 二叉树的所有路径
 * 	给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3	
 * @author liang
 *
 */
public class BinaryTreePaths_257 {
	/**
	 * dfs 保存每一个答案
	 * @param root
	 * @return
	 */
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res = new ArrayList<>();
        if(root == null)
        	return res;
        binaryTreePath(root,"",res);
        return res;
    }

    /**
     * 
     * @param root
     * @param item  每一组的中间值
     * @param res
     */
	private void binaryTreePath(TreeNode root, String item, List<String> res) {
		// TODO Auto-generated method stub
		if(root.left == null && root.right == null) {
			res.add(item+root.val);
			return;
		}
		if(root.left!=null)
			binaryTreePath(root.left, item+root.val+"->", res);
		if(root.right!=null)
			binaryTreePath(root.right, item+root.val+"->", res);
	}
}
