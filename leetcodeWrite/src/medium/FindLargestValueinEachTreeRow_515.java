package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。

示例：

输入: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

输出: [1, 3, 9]
 * @author liang
 *
 */
public class FindLargestValueinEachTreeRow_515 {
	/**
	 * bfs,记录当前层和下一层的节点数，记录最大值，使用队列
	 * @param root
	 * @return
	 */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
        	return res;
        bfs(root,res);
        return res;
    }
    
    private void bfs(TreeNode root, List<Integer> res) {
		// TODO Auto-generated method stub
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		int curNum = 1;//当前层节点数
		int nextNum = 0;//下一层节点数
		int max = Integer.MIN_VALUE;
		while(!que.isEmpty()) {
			TreeNode node = que.poll();
			curNum--;
			max = Math.max(max, node.val);
			if(node.left!=null) {
				que.offer(node.left);//左子树放入，下一层节点数+1
				nextNum++;
			}
			if(node.right!=null) {
				que.offer(node.right);
				nextNum++;
			}
			if(curNum == 0) {
				res.add(max);
				curNum = nextNum;
				nextNum = 0;
				max = Integer.MIN_VALUE;
			}
		}
	}

	public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
