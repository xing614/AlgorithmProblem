package easy;
/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @author liang
 *
 */
public class PalindromeLinkedList_234 {

	/**
	 * 1快慢指针找中间点，2后半段链表翻转， 3 比较是否回文
	 * @param head
	 * @return
	 */
    public boolean isPalindrome(ListNode head) {
        ListNode quick = head,slow =head,prev=null;
        while(quick.next!=null ||quick.next.next!=null) {
        	quick = quick.next!=null?quick.next.next:quick.next;
        	slow = slow.next;
        }
        //翻转 四步  1得到next，2当前的next指向前一个 3前一个变成当前元素  4 当前元素变成下一个元素
        while(slow!=null) {
        	ListNode next = slow.next;
        	slow.next = prev;
        	prev = slow;
        	slow = next;
        }
        while(head!=null && prev != null) {
        	if(head.val == prev.val ) {
        		head = head.next;
        		prev = prev.next;
        	}else {
        		return false;
        	}
        }
        return true;
    }


    
}
