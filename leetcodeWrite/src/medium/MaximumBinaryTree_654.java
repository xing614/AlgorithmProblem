package medium;
/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。

Example 1:

输入: [3,2,1,6,0,5]
输入: 返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
注意:

给定的数组的大小在 [1, 1000] 之间。
 * @author liang
 *
 */
public class MaximumBinaryTree_654 {

	/**
	 * dfs 每次找到范围内最大值，然后其left和right深度遍历组合
	 * @param nums
	 * @return
	 */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length);
    }
    
	private TreeNode helper(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
		if(left==right)
			return null;
		int max_index =  maxIndex(nums,left,right);
		TreeNode root = new TreeNode(nums[max_index]);
		root.left = helper(nums,left,max_index);
		root.right = helper(nums,max_index+1,right);
		return root;
	}

	/**
	 * 获取范围内最大值的index下标
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	private int maxIndex(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
		int max_index = left;
		for(int i=left;i<right;i++) {
			if(nums[max_index]<nums[i])
				max_index = i;
		}
		return max_index;
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
