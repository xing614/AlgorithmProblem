package medium;
/**
 * 116. 填充同一层的兄弟节点
给定一个二叉树

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

说明:

你只能使用额外常数空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。
示例:

给定完美二叉树，

     1
   /  \
  2    3
 / \  / \
4  5  6  7
调用你的函数后，该完美二叉树变为：

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
 * @author liang
 *
 */
public class PopulatingNextRightPointersInEachNode_116 {

	/**
	 * 遍历，利用根节点子树Next变量保存它旁边的节点
	 * @param root
	 */
    public void connect(TreeLinkNode root) {
        if(root == null)
        	return ;
        TreeLinkNode cur;
        while(root.left != null) {//不是叶子节点，就用它来设置它的左右子节点的next
        	cur = root;
        	while(cur != null) {//遍历cur所在的行所有节点
        		cur.left.next = cur.right;//设置根节点左子树next为其右子树 例如4->5
        		if(cur.next!=null) {
        			cur.right.next = cur.next.left;//该节点右子树的next为该节点的下一个节点左子树  例如5->6
        		}
        		cur = cur.next;//该行下一个节点
        	}
        	root = root.left;//下一行
        	
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left, right, next;
	    TreeLinkNode(int x) { val = x; }
	}
	 
}
