package medium;

/**
 * 143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * @author liang
 *
 */
public class ReorderList_143 {

	/**
	 * 先使用快慢指针找到中间节点，在中间把链表分为两半，然后后一半翻转，最后依次合并
	 * @param head
	 */
    public void reorderList(ListNode head) {
    	if (head == null 
    			|| head.next == null 
    			|| head.next.next == null)
    		return;
    	ListNode fast = head;
    	ListNode slow = head;
    	
    	//找到中间节点
    	while(fast.next!=null &&fast.next.next!=null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	ListNode second = slow.next;//中间节点
    	// 注意置空，分为两个链表
    	// 第一个链表的长度大于（+1）等于第二个链表长度
    	slow.next = null;
    	// 反转后半链表
    	second = reverseList(second);
    	
    	ListNode first = head;
    	// 合并两个链表,把第二个链表插在第一个链表中
    	while(second!=null) {
    		//每次循环 1->2->1
    		ListNode next = first.next;
    		first.next = second;//first-》second
    		second = second.next;//second->second.next;
    		first = first.next;//后移一位，就是移到的节点本来是second
    		first.next = next;//2->1
    		first = first.next;//后移一位，移到节点1的
    	}
    }
    
    
    // 就地翻转链表
    private ListNode reverseList(ListNode head) {
    	ListNode prev = null;
    	ListNode next = null;
    	while(head!=null) {
    		next = head.next;
    		head.next = prev;
    		prev = head;
    		head = next;
    	}
    	return prev;
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
