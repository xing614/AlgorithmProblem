package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 * @author liang
 *
 */
public class PathSum2_113 {
	
	/**
	 * dfs
	 * @param root
	 * @param sum
	 * @return
	 */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	getResults(res, list, root, sum);
    	return res;
    }
    
	private List<List<Integer>> getResults(List<List<Integer>> res, ArrayList<Integer> list, TreeNode root, int sum) {
		// TODO Auto-generated method stub
		 if(root == null){
			 return res;
		 }
		 list.add(root.val);
		 if(root.left == null && root.right == null && root.val == sum){
			 res.add(list);
		 }
		 if(root.left != null) {
			 //完全复制了一份  然后传递到下一轮调用
			 //复制放进去不会对原list存在的数据造成影响
			 ArrayList<Integer> newLikeStack = new ArrayList<Integer>();
			 for(int i = 0; i < list.size(); i++){
				 newLikeStack.add(list.get(i));
			 }
			 getResults(res,newLikeStack,root.left,sum-root.val);
		 }	
		 if(root.right != null) {
			 ArrayList<Integer> newLikeStack = new ArrayList<Integer>();
			 for(int i = 0; i < list.size(); i++){
				 newLikeStack.add(list.get(i));
			 }
			 getResults(res,newLikeStack,root.right,sum-root.val);
		 }
		 return res;
		 
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
