package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

示例:

输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author liang
 *
 */
public class UniqueBinarySearchTrees2_95 {

	/**
	 * 对于i在[1,n]区间内, 以i为root时, 生成BST的left child 是由1到i-1生成的, BST的right child 是由i+1 到n生成的.
	 * recursive call先得到左右子树分别的所有结果.
	 * 然后从左右子树的返回结果中依次取点，接到有 i 生成的root上，一共有m*n种接法。构造好后当前root加到res里.
	 * recursive call的 stop condition是l>r. 此时没有i能存在[l, r]这个区间内. 加上null节点.
	 * @param n
	 * @return
	 */
    public List<TreeNode> generateTrees(int n) {
    	List<TreeNode> res = new ArrayList<TreeNode>();
        if(n<1){
            return res;
        }
        return helper(1,n);
    }
    
	private List<TreeNode> helper(int left, int right) {
		// TODO Auto-generated method stub
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(left>right) {
			res.add(null);
			return res;
		}
		for(int i=left;i<=right;i++) {//依次作为每一个子树的父节点
			List<TreeNode> leftRes = helper(left,i-1);
			List<TreeNode> rightRes = helper(i+1, right);
			for(int m=0;m<leftRes.size();m++) {//前1~i-1可以组成m个样式
				for(int n=0;n<rightRes.size();n++) {
					TreeNode root = new TreeNode(i);
					root.left = leftRes.get(m);
					root.right = rightRes.get(n);
					res.add(root);
				}
			}
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
