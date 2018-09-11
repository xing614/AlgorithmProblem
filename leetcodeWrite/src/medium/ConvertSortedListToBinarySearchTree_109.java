package medium;

import medium.ConstructBinaryTreeFromPreorderAndInorderTraversal_105.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 * @author liang
 *
 */
public class ConvertSortedListToBinarySearchTree_109 {

	/**
	 * 解法一：将单链表中的值存入一个数组中，通过数组来构建二叉树，算法时间复杂度是：O(n)，空间复杂度是：O(n) 
	 * 解法二：采用递归的方式， 
	 * （一）找中间结点，构建根结点，
	 * （二）中间结点左半部分构建左子树， 
	 * （三）中间结点的右部分构建右子树 
	 * 采用第二种解法　 
	 * @param head
	 * @return
	 */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        	return null;
        if(head.next == null)//链表只有一个元素
        	return new TreeNode(head.val);
        //双指针快速找中间节点
        // 快速移动结点，每次移动两个位置
        ListNode fast = head.next.next;
        //记录中间结点
        ListNode mid = head;
        // 找中间结点
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        // 以中间结点的下一个结点作为根结点
        TreeNode root = new TreeNode(mid.next.val);
        root.right = sortedListToBST(mid.next.next);
        // 记录链表要断开的点
        ListNode midNext = mid.next;
        // 断开单链表（会破坏原来单链表的结构）
        mid.next = null;
        //断开链表是为了建立左子树遍历时，只遍历到中间节点
        // 构建左子树
        root.left = sortedListToBST(head);
        // 重新将链表接好
        mid.next = midNext;
        // 返回结果
        return root;
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
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
}
