package easy;
/**
 * 206. 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author liang
 *
 */
public class ReverseLinkedList_206 {

	/**
	 * iterative 解法 迭代
	 * 得到下一个节点，更改当前节点指向，将指针往下移动，直到过完整个linkedlist.
	 * @param head
	 * @return
	 */
    public ListNode reverseList1(ListNode head) {
    	ListNode prev = null;
    	ListNode cur = head;//cur作为当前位置，每次让cur.next = prev，prev变成cur,cur再后移 ，就从1-》2变成2-》1-》null
    	while(cur!=null) {
    		ListNode next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
		return prev;
        
    }
    /**
     * recursive 递归
     * 传给helper method两个节点，cur和pre（最开始是head和null), 
     * 先用n1存当前节点的next，然后把当前节点的next指向pre，然后一直recursively call help method直到过完整个linkedlist.
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
    	if(head == null||head.next== null)
            return head;
        return getReverse(head, null);

        
    }
	private ListNode getReverse(ListNode cur, ListNode prev) {
		// TODO Auto-generated method stub
		if(cur.next == null) {//到头了，就让cur指向前一个
			cur.next = prev;
			return cur;
		}
    	ListNode n1 = cur.next;
    	cur.next = prev;
    	return getReverse(n1,cur);//这里设置了prev为cur
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
