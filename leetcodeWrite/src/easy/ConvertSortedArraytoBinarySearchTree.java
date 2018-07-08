package easy;
/**
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 * @author liang
 *
 */
public class ConvertSortedArraytoBinarySearchTree {

	/**
	 * 二分查找树问题
	 * 如果把一个数组看成一棵树（也就是以中点为根，左右为左右子树，依次下去）数组就等价于一个二分查找树。
	 * 如果要构造这棵树，那就是把中间元素转化为根，然后递归构造左右子树。
	 * 用二叉树递归的方法来实现，以根作为返回值，每层递归函数取中间元素，作为当前根和赋上结点值，然后左右结点接上左右区间的递归函数返回值。
	 * @param nums
	 * @return
	 */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return null;
        }
        return recursion(nums,0,nums.length-1);
    }
    
    public TreeNode recursion(int[] nums,int left,int right) {
    	if(left>right)
    		return null;
    	int mid = (left+right)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = recursion(nums,left,mid-1);
    	root.right = recursion(nums,mid+1,right);
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
