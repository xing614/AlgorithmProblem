package medium;
/**
 * 92. 反转链表 II
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
 * @author liang
 *
 */
public class ReverseLinkedList2_92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head == null)
    		return null;
    	ListNode q = null;//用于判断mn之前是空节点
    	ListNode p = head;
    	for(int i=0;i<m-1;i++) {
    		q = p;
    		p = p.next;
    	}
    	ListNode end = p;//要转变第一个节点
    	ListNode pPre = p;
    	p = p.next;
    	for(int i=m+1;i<=n;i++) {
    		ListNode pNext = p.next;
    		p.next = pPre;//设置p指向p的前一个节点
    		//后移p和pre
    		pPre = p;
    		p = pNext;
    	}
    	end.next = p;//设置m节点前一个指向n节点
    	if(q!=null)//判断m之前是否是空
    		q.next = pPre;
    	else
    		head =pPre;
		return head;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
