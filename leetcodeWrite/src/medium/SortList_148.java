package medium;

import medium.InsertionSortList_147.ListNode;

/**
 * 148. 排序链表
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5

 * @author liang
 *
 */
public class SortList_148 {

	/**
	 * 就是对一个链表进行归并排序。
	 * 主要考察3个知识点，
	 * 知识点1：归并排序的整体思想
	 * 知识点2：找到一个链表的中间节点的方法
	 * 知识点3：合并两个已排好序的链表为一个新的有序链表
	 * 
	 * 归并排序的基本思想是：找到链表的middle节点，然后递归对前半部分和后半部分分别进行归并排序，最后对两个以排好序的链表进行Merge。
	 * @param head
	 * @return
	 */
    public ListNode sortList(ListNode head) {
        if(head ==null||head.next == null)//递归出口  当只有一个节点时就不再递归
        	return head;
        ListNode middle=getMiddleOfList(head);
        ListNode next = middle.next;
        middle.next=null;//把两个链表断开分为左边（包括middle）一半和右边一半
		return mergeTwoList(sortList(head), sortList(next));
    }
    /**
     * 合并两个链表
     * @param sortList
     * @param sortList2
     * @return
     */
	private ListNode mergeTwoList(ListNode headA, ListNode headB) {
		// TODO Auto-generated method stub
		ListNode newhead = new ListNode(-1);
		ListNode cur = newhead;
		while(headA!=null && headB!=null) {//依次从第一个位置比较，小的那个后移
			if(headA.val<=headB.val) {
				cur.next = headA;
				headA = headA.next;
			}else {
				cur.next = headB;
				headB = headB.next;
			}
			cur = cur.next;//cur后移
		}
		cur.next = headA==null?headB:headA;//最后一个位置，那个链表剩下，接下来就是它
		
		return newhead.next;
	}

	/**
	 * 寻找中间节点，使用快慢指针，就是一个移动两位，一个移动一位
	 * @param head
	 * @return
	 */
	private ListNode getMiddleOfList(ListNode head) {
		// TODO Auto-generated method stub
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next !=null && fast.next.next !=null	) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
}
