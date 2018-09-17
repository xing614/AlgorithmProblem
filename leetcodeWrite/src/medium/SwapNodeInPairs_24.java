package medium;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
说明:

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author liang
 *
 */
public class SwapNodeInPairs_24 {

	/**
	 * 一组Group分A1和A2
	 * 记录当前节点的下一节点node = current.next（就是node指向A2）
	 * 将当前节点的下一个，指向node的下一个，current.next = node.next（就是A1指向下一个group）
	 * 将下一个节点指向当前节点，node.next = current（就是A2指向A1）
	 * 将上一个节点的下一个指向当前节点，las.next = current  就是Pre挪到A1（作为下一个的pre）
	 * @param head
	 * @return
	 */
    public static ListNode swapPairs(ListNode head) {
//        if(head == null)
//        	return head;
//        ListNode current = head;
//        while(current != null && current.next != null) {
//        	ListNode node = current.next;
//        	current.next = node.next;
//        	node.next = current;
//        	if(current.next!= null)
//        		current = current.next;
//        	else 
//        		break;
//        }
//        return head;
    	
    	
    	/**
    	 * 一个遍历指针current和两个辅助指针first、second，
    	 * first保存current指针所在结点的后继结点，
    	 * second保存current指针所在结点的后继的后继结点
    	 * 令first的后继指向second的后继，current的后继等于second，current后继的后继等于first，
    	 * current等于first
    	 * 就是说first和second是一组group，current是这组的前一个节点
    	 */
        ListNode headPointer = new ListNode(0);
        headPointer.next = head;
        ListNode current = headPointer;
 
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = first;
        }
 
 
        return headPointer.next;
    }
    
    public static void ss(ListNode head) {
    	while(head!=null) {
    		System.out.println(" ="+head.val);
    		head = head.next;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode head2 = swapPairs(head);
		ss(head2);
	}

}
