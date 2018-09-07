package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author liang
 *
 */
public class BinaryTreePostorderTraversal_145 {

	/**
	 * 要先访问左右节点,同样还是以左节点作为主线,
	 * 不过这里要增加一个栈记录每个节点的右节点是否已经被访问过,只有当左右节点都被访问的前提下才能访问根节点
	 * @param root
	 * @return
	 */
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res=new ArrayList<>();	
    	Stack<TreeNode> nodeStack=new Stack<>();//当栈	
    	Stack<Integer> nodeState=new Stack<>();//记录右节点是否已经访问过,1表示已经访问了,0表示未访问 
    	if(root==null)	
    		return res;	
    	else {	
    		nodeStack.push(root);	
    		nodeState.push(0);	
    		root=root.left;	
    	}	
    	while(!nodeStack.isEmpty())	{	
    		while(root!=null) {	
    			nodeStack.push(root);	
    			nodeState.push(0);	
    			root=root.left;	
    		}//当这个循环跳出的时候 说明nodeStak栈顶的那个节点没有左节点 
    		if(nodeState.peek()==1)//如果这时候已经访问过右节点了 这时候就可以访问根节点	
    		{	
    			res.add(nodeStack.pop().val);	
    			nodeState.pop();//把根节点对应的状态值去除	
    		}else {//访问右节点	
    			root=nodeStack.peek().right;	
    			nodeState.pop();//移除最后一个 
    			nodeState.push(1);//放入1，表示已访问
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
