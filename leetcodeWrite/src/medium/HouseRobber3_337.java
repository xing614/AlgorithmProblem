package medium;
/**
 * 337.打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

输出: 7 
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * @author liang
 *
 */
public class HouseRobber3_337 {

	/**
	 * 递归 dfs
	 * max[i] = Math.max(max[i-2]+val(a), max[i-1])
	 * 数组rob来存储。
	 * rob[1]存储的是从叶子节点到当前节点抢劫的最大值，
	 * rob[0]存储的是从叶子节点到当前节点的左右孩子层节点抢劫到的最大值：
	 * @param root
	 * @return
	 */
    public int rob(TreeNode root) {
        return dfs(root)[1];
    }
    
	private int[] dfs(TreeNode root) {
		int[] rob = {0,0};
		if(root!=null) {
			int[] robLeft = dfs(root.left);
			int[] robRight = dfs(root.right);
			rob[0] = robLeft[1]+robRight[1];
			rob[1] = Math.max(robLeft[0] + robRight[0] +root.val, rob[0]);
		}
		return rob;
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
