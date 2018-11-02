package medium;
/**
 * 328.奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

示例 1:

输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
示例 2:

输入: 2->1->3->5->6->4->7->NULL 
输出: 2->3->6->7->1->5->4->NULL
说明:

应当保持奇数节点和偶数节点的相对顺序。
链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * @author liang
 *
 */
public class OddEvenLinkedList_328 {

	/**
	 * 设置两个指针，odd奇指针和even偶指针，循环 每次先odd指向even.next，odd后移，然后even指向odd.next，even后移
	 * 最后odd.next = even的第一个节点
	 * @param head
	 * @return
	 */
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
        	return head;
        ListNode oddHead = head,evenHead = head.next;
        ListNode prevOdd = oddHead,prevEven = evenHead;//奇 偶指针
        while(prevOdd.next!=null && prevEven.next!=null) {
        	//奇数的拼接
        	prevOdd.next = prevEven.next;
        	prevOdd = prevOdd.next;
        	
        	//偶数的拼接
        	prevEven.next = prevOdd.next;
        	prevEven = prevEven.next;
        }
        //中间位置拼接
        prevOdd.next = evenHead;
        return oddHead;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}
}
