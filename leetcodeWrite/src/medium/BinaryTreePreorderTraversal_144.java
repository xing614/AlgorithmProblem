package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author liang
 *
 */
public class BinaryTreePreorderTraversal_144 {

	/**
	 * 先序 中序 后续遍历统一书写方式
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> ls = new ArrayList<Integer>();
		 Stack<TreeNode> stk = new Stack<TreeNode>();
		 while(root!=null || !stk.isEmpty()){
			 //先序，先加root
		     if(root != null){
		         ls.add(root.val);//先加root
		         stk.push(root);
		         root = root.left;//然后加left
		     }else{
		         root = stk.pop();
		         root = root.right;
		     }
		     
		     //中序
//		     if(root != null){//不为空就一直往left走
//		            stk.push(root);
//		            root = root.left;
//		        }else{
//		            TreeNode tn = stk.pop();
//		            ls.add(tn.val);//先加left
//		            root = tn.right;
//		      }
		     //后续
		     
		 }
		 return ls;
		
	}
	
	/**
	 * 迭代
	 * 先根遍历二叉树，就是说，对二叉树中的每一个节点，先访问该节点，再访问其左子树，最后访问其右子树。用迭代的方式先根遍历二叉树，需要借助栈。具体步骤如下： 
	 * （1）将根结点入栈 
	 * （2）进入循环。先弹出栈顶元素，访问它，然后将该元素的右子树入栈，最后将该元素的左子树入栈。左子树后于右子树入栈保证了左子树先于右子树被访问。
	 * @param root
	 * @return
	 */
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);//推入
        while(!stack.isEmpty()) {
        	TreeNode top = stack.pop();
        	if(top!=null) {
        		result.add(top.val);
        		stack.push(top.right);//先放right保证后进先出
        		stack.push(top.left);
        	}
        }
        return result;
        
    }
    
    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
    	List<Integer> ls = new ArrayList<Integer>();
    	preorderTraversal(root,ls);
    	return ls;
    }
    
    
	private void preorderTraversal(TreeNode root, List<Integer> ls) {
		// TODO Auto-generated method stub
		if(root == null){
		    return;
		}
		ls.add(root.val);
		preorderTraversal(root.left, ls);
		preorderTraversal(root.right, ls);
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
