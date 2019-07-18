package easy;

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 * @author liang
 *
 */
public class MergeTwoSortedLists_21 {
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode ln = new ListNode(0);
    	ListNode first = ln;
    	while(l1!=null &&l2!=null) {
    		if(l1.val<l2.val) {
    			ln.next = l1;
    			l1 = l1.next;
    		}else {
    			ln.next = l2;
    			l2 = l2.next;
    		}
    		ln = ln.next;
    	}
    	//之后是l1 或l2有一个已经为空了
    	while(l1!=null) {
    		ln.next = l1;
    		l1 = l1.next;
    		ln = ln.next;
    	}
    	while(l2!=null) {
    		ln.next = l2;
    		l2 = l2.next;
    		ln = ln.next;
    	}
		return first.next;
        
    }
    
	public static void main(String[] args) {

	}
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }