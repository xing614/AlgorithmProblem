package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 142. 环形链表 II
题目描述提示帮助提交记录社区讨论阅读解答
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

说明：不允许修改给定的链表。

进阶：
你是否可以不用额外空间解决此题？
 * @author liang
 *
 */
public class LinkedListCycle2_142 {

	/**
	 * 使用map记录访问过的节点，如访问过返回该节点
	 * @param head
	 * @return
	 */
    public ListNode detectCycle(ListNode head) {
        Map<ListNode,Boolean> maps = new HashMap<>();
        while(head!=null) {
        	if(maps.containsKey(head)) {
        		return head;
        	}
        	maps.put(head, true);
        	head = head.next;
        }
        return null;
    }
    /**
     * 方法二，使用快慢指针，如果是环总会碰上
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next ==null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && slow != fast) {
            // if (slow == fast) {
            //     temp = slow;
            //     break;
            // }
            slow = slow.next;
            fast = fast.next == null ? fast.next : fast.next.next;
        }
        if (slow == fast) {
            slow = head;
            fast = fast.next;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
}
