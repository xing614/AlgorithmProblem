package medium;
/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 * @author liang
 *
 */
public class RemoveNthNodeFromEndOfList_19 {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	
	/**
	 * 维护slower和faster两个指针，
	 * faster先向后走n步，然后slower和faster一块向后走直到faster为null，这是slower位置为倒数第n个
	 * 为了方便删除，让faster先向后走n步，之后一起走，faster.next==null时slower在倒数n+1位置，
	 * 这时slower可以充当prev，删除就是slower.next = slower.next.next了
	 * @param head
	 * @param n
	 * @return
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head==null ||head.next==null)return null;
    	ListNode slower = head;
    	ListNode faster = head;
    	for(int i=0;i<n;i++) {
    		faster = faster.next;
    	}
    	if(faster == null) {//如果是删除头结点
    		head = head.next;
    		return head;
    	}
    	while(faster.next !=null) {//直到next为null，这是slower.next为倒数n
    		faster = faster.next;
    		slower = slower.next;
    	}
    	slower.next = slower.next.next;//删除倒数第n个
    	
		return head;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
