package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层次遍历
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 * @author liang
 *
 */
public class BinaryTreeLevelOrderTraversal_102 {

	List<List<Integer>> list=new ArrayList<List<Integer>>();
	
	/**
	 * 使用LinkedList queue=new LinkedList()。因为LinkedList具有队列的性质，即先进先出规则。
	 * 然后统计每一层的节点个数，然后在每层从左到右输出节点。
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null)
        {
            return list;
        }

        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();  
        queue.offer(root);  //首先把根进入队列中
        while(!queue.isEmpty())  //队列不为空的
        {
            int num=queue.size();  //队列的长度；
            List<Integer> templist=new ArrayList<Integer>();   //定义一个ArrayList集合

            while(num>0)//首先判断num是否大于0先获取每一层的结点个数。
            {
                TreeNode node=queue.peek(); //查看队头元素，但是不删除队头的元素，队列是先进先出的规则
                if(node.left!=null) //该节点的左孩子不为空
                {
                    queue.offer(node.left); //将左孩子进入队尾
                }
                if(node.right!=null)   //如果该节点的右孩子不为空
                {
                    queue.offer(node.right);  //将右孩子进入队尾。
                }

                int data=queue.poll().val;  //将节点从队头出队// 。
                templist.add(data); //将出的节点加入到tempList集中
                num--;  //然后每次减1.
            }
            list.add(templist);
        }

        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class TreeNode{   //节点的构造
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x)
	    {
	        val=x;
	    }
	}

}
