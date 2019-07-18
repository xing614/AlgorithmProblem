package easy;
/**
 * 83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3
 * @author liang
 *
 */
public class RemoveDuplicatesFromSortedList_83 {
	/**
	 * 因为是有序链表，所以去重只需要比较新来的节点和前面一个节点是否相同，如果相同直接删除就可以了。
	 * 思考一个问题，因为在链表不为空的情况下，第一个节点是不可能会被删除的，所以我们不需要向前面那样，在第一个节点之前创建一个节点，我们直接从第二个节点开始比较。
	 * @param head
	 * @return
	 */
    public ListNode deleteDuplicates(ListNode head) {	
        if(head == null || head.next == null)
        	return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null) {
        	if(cur.val == pre.val) {//相同就前的next = 后的next，然后后指针再后移
        		pre.next = cur.next;//删除重复的节点
        	}else {//不同就前指针和后指针都后移
        		pre = pre.next;
        	}
        	cur = cur.next;
        }
        return head;
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
