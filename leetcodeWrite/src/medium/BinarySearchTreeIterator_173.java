package medium;

import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
题目描述提示帮助提交记录社区讨论阅读解答
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

调用 next() 将返回二叉搜索树中的下一个最小的数。

注意: next() 和hasNext() 操作的时间复杂度是O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * @author liang
 *
 */
public class BinarySearchTreeIterator_173 {

	/**
	 * 一个非常简单的解决办法是遍历这棵二叉树，把二叉树的元素以从大到小的方式放到一个栈里，
	 * 这样next()从栈顶获取元素，hasNext()调用栈不为空的判定方法。
	 * 这种方法能满足题目中的时间复杂度要求，但是O(n)的空间复杂度无法满足题目中O(h)空间复杂度要求。
	 * 维护一个栈，暂且称之为最小元素栈，栈中存放的是结点指针，
	 * 向栈中添加元素发生在两种情况下：1.初始化迭代器时；2.调用next()从栈中弹出一个元素时。
	 * 
	 * 最后
	 * 维护一个栈，先将根结点的左子树全部压栈，每次弹出栈顶元素，若某次弹出的栈顶元素有右子树，
	 * 此时需要将以该节点的右子树为根的子树的左子节点全部压栈
	 */
	
	
	Stack<TreeNode> stack = new Stack<TreeNode>();
	
    public BinarySearchTreeIterator_173(TreeNode root) {
        while(root !=null) {//放入根节点及其左子树 一直到最小节点
        	stack.push(root);
        	root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();//栈顶不为空，就有next
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
		if(top!=null) {
			TreeNode rightNode = top.right;
			while(rightNode!=null) {//放入右节点和它的左子树
				stack.push(rightNode);
				rightNode = rightNode.left;
			}
        }
		return top.val;
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
