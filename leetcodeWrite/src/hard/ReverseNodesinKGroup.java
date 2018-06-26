package hard;
/**
 * k个一组翻转链表	
 * 
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

示例 :

给定这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

说明 :

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author liang
 *
 */

public class ReverseNodesinKGroup {

	
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode nodeH = new ListNode(-1);
        nodeH.next = head;
        ListNode ins = nodeH;
        ListNode current = head;
        int reverseTimes = getLength(head)/k;
        while((reverseTimes--)>0) {//反转几处
        	//最初是ins->cur->move->move.next，变成ins->move->cur->move.next
        	//相当于每次current向后移动一次，current的下一个被塞到了ins后面（也就是这一组的头部）
        	//如果k=3，数组为12345，则第一次移动成21345，第二次移动为32145，ins每次都指向头部1、2、3
        	for(int i=0;i<(k-1);i++) {//每组翻转的个数
        		//交换current和current.next
        		ListNode move = current.next;
        		current.next = move.next;
        		move.next = ins.next;
        		ins.next = move;//ins.next最初指向current，变成指向current.next
        	}
        	ins = current;//此时current在这一组最后一个位置，ins指向最后一个
        	current = ins.next;//current就会指向下一组的第一个
        }
        return nodeH.next;
    }

	private static int getLength(ListNode head) {
		int result = 0;
		while(head!=null) {
			result++;
			head = head.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode aa = reverseKGroup(l1,2);

	}

	
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

