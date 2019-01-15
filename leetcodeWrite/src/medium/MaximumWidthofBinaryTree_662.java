package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 662.二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。

每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

示例 1:

输入: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
示例 2:

输入: 

          1
         /  
        3    
       / \       
      5   3     

输出: 2
解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
示例 3:

输入: 

          1
         / \
        3   2 
       /        
      5      

输出: 2
解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
示例 4:

输入: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
输出: 8
解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
注意: 答案在32位有符号整数的表示范围内。

 * @author liang
 *
 */
public class MaximumWidthofBinaryTree_662 {

	/**
	 * 使用队列，一个队列做树的广度优先遍历，一个队列记录前一个队列中树节点对应的位置标号
	 * @param root
	 * @return
	 */
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
        	return 0;
        Queue<TreeNode> queue = new LinkedList<>();//做树的广度优先遍历
        Queue<Integer> queueOs = new LinkedList<>();//记录前一个队列中树节点对应的位置标号，其实就是记录start-end
        queue.add(root);
        queueOs.add(1);
        int currentCount = 1;//正在遍历的当前层次的剩余数量
        int NextCount = 0;//下一层节点数量
        int max = currentCount;
        int start =1;//记录某层次结点的最左边的结点
        int end = 1;//记录某层次结点的最右边的结点
        while(!queue.isEmpty()) {
        	TreeNode current = queue.poll();
        	end = queueOs.poll();
        	if(current.left!=null) {
        		queue.add(current.left);
        		queueOs.add(2*end);//分配左孩子结点的序号
        		NextCount++;//记录下层结点的数量
        	}
        	if(current.right != null){
        		queue.add(current.right);
        		queueOs.add(2*end +1); //分配右孩子结点的序号
        		NextCount++;
        	}
        	
        	 //当前层次已遍历完毕，计算max,并且为下一层次的遍历准备。
            if(--currentCount == 0){
                // 目标比对。
        		if(max < end - start + 1){
        			max = end - start +1;
        		}
        		currentCount = NextCount;//设置下一层次剩余的数量
        		NextCount = 0;
                //设置下一层结点的start.
        		start = queueOs.isEmpty() ?  1 : queueOs.peek();
        		
        	}
        }
        return max;
        	
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
