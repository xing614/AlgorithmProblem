package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author liang
 *
 */
public class BinaryTreeInorderTraversal_94 {

	/**
	 * 中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。
	 * 
	 * 先用递归方法
	 * 算法的时间复杂度是O(n), 而空间复杂度则是递归栈的大小，即O(logn)
	 * @param root
	 * @return
	 */
    public List<Integer> inorderTraversal1(TreeNode root) {
    	List<Integer> res = new ArrayList();
    	helper(root,res);
		return res;
        
    }
    
	private void helper(TreeNode root, List<Integer> res) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		helper(root.left,res);
		res.add(root.val);
		helper(root.right,res);
	}

	/**
	 * 迭代
	 * 用一个栈来模拟递归的过程。算法时间复杂度是O(n)，空间复杂度是栈的大小O(logn)。过程中维护一个node表示当前走到的结点（不是中序遍历的那个结点）
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
		   ArrayList<Integer> res = new ArrayList<Integer>();
		    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		    while(root!=null || !stack.isEmpty())
		    {
		        if(root!=null)
		        {
		            stack.push(root);
		            root = root.left;
		        }
		        else
		        {
		            root = stack.pop();
		            res.add(root.val);
		            root = root.right;
		        }
		    }
		    return res;

        
    }
	/**
	 * 用来保证空间复杂度是O（1）
	 * 想用O(1)空间进行遍历，因为不能用栈作为辅助空间来保存付节点的信息，
	 * 重点在于当访问到子节点的时候如何重新回到父节点（当然这里是指没有父节点指针，如果有其实就比较好办，一直找遍历的后驱结点即可）。
	 * Morris遍历方法用了线索二叉树，这个方法不需要为每个节点额外分配指针指向其前驱和后继结点，而是利用叶子节点中的右空指针指向中序遍历下的后继节点就可以了。

算法具体分情况如下：
1. 如果当前结点的左孩子为空，则输出当前结点并将其当前节点赋值为右孩子。
2. 如果当前节点的左孩子不为空，则寻找当前节点在中序遍历下的前驱节点（也就是当前结点左子树的最右孩子）。接下来分两种情况：
 a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点（做线索使得稍后可以重新返回父结点）。然后将当前节点更新为当前节点的左孩子。
 b) 如果前驱节点的右孩子为当前节点，表明左子树已经访问完，可以访问当前节点。将它的右孩子重新设为空（恢复树的结构）。输出当前节点。当前节点更新为当前节点的右孩子
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal3(TreeNode root) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    TreeNode cur = root;
	    TreeNode pre = null;
	    while(cur != null)
	    {
	        if(cur.left == null)
	        {
	            res.add(cur.val);
	            cur = cur.right;
	        }
	        else
	        {
	            pre = cur.left;
	            while(pre.right!=null && pre.right!=cur)
	                pre = pre.right;
	            if(pre.right==null)
	            {
	                pre.right = cur;
	                cur = cur.left;
	            }
	            else
	            {
	                pre.right = null;
	                res.add(cur.val);
	                cur = cur.right;
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
