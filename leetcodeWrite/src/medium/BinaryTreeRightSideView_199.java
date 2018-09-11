package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
题目描述提示帮助提交记录社区讨论阅读解答
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 * @author liang
 *
 */
public class BinaryTreeRightSideView_199 {

	/**
	 * 可以用层次遍历，每次是最右节点
	 * 使用一个null放入队列作为每层节点的间隔符，null前一个节点就是最右节点
	 * @param root
	 * @return
	 */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list =  new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
        	return list;
        TreeNode current = root;
        queue.offer(current);//放入队列
        queue.offer(null);//每层之间的分隔符
        while(!queue.isEmpty()) {
        	current = queue.poll();//弹出第一个
        	if(current!=null) {
        		if(queue.peek() == null) {//队列下一个元素是null，说明该层便利完了
        			list.add(current.val);
        		}
        		if(current.left !=null)
        			queue.add(current.left);
        		if(current.right!=null)
        			queue.add(current.right);
        	}else {//当前位置为Null，要么是遍历结束，要么是这一层遍历结束
        		if(queue.isEmpty()) {//空了遍历完成
        			break;
        		}else {//这一层遍历结束，则这一层的left right都插入完成，该插入下一层的分隔符了
        			queue.add(null);
        		}
        	}
        }
        return list;
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
