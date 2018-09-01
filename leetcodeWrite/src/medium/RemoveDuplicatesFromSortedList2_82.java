package medium;


/**
 * 82. 删除排序链表中的重复元素 II
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3
 * @author liang
 *
 */
public class RemoveDuplicatesFromSortedList2_82 {

	/**
	 * 使用3个指针（prev，current，post）来遍历链表
	 * 最开始还是需要建立一个fakehead，让fakehead的next指向head。然后，使用3个指针方法来初始化3个指针，如下： 
	 * ListNode ptr0 = fakehead; //prev
	 * ListNode ptr1 = fakehead.next; //current
	 * ListNode ptr2 = fakehead.next.next; //post
	 * 同时还需要引入一个布尔型的判断flag，来帮助判断当前是否遇到有重复，这个flag能帮助识别是否需要删除重复。
	 * 当没有遇到重复值（flag为false）时，3个指针同时往后移动：
	 * ptr0 = ptr1;
	 * ptr1 = ptr2;
	 * ptr2 = ptr2.next; 
	 * 当遇到重复值时，设置flag为true，并让ptr2一直往后找找到第一个与ptr1值不等的位置时停止，
	 * 这时，ptr1指向的node的值是一个重复值，需要删除，所以这时就需要让ptr0的next连上当前的ptr2，这样就把所有重复值略过了。
	 * 然后，让ptr1和ptr2往后挪动继续查找。
	 * 这里还需要注意的是，当ptr2一直往后找的过程中，是有可能ptr2==null（这种情况就是list的最后几个元素是重复的，例如1->2->3->3->null)，
	 * 这时ptr1指向的值肯定是需要被删除的，所以要特殊处理，令ptr0的next等于null，把重复值删掉。其他情况说明最后几个元素不重复，不需要处理结尾，遍历就够了。
	 * @param head
	 * @return
	 */
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null) {
    		return head;
    	}
    	ListNode fakehead = new ListNode(0);
    	fakehead.next = head;
    	ListNode ptr0 = fakehead;//重复元素之前的那个元素
    	ListNode ptr1 = fakehead.next;//head,这个位置在之后表示可能重复（就是要判断的）元素
    	ListNode ptr2 = fakehead.next.next;
    	boolean flag = false;//判断重复值
    	while(ptr2!=null) {
    		if(ptr1.val == ptr2.val) {//重复，ptr2后移
    			flag = true;
    			ptr2 = ptr2.next;
    			if(ptr2 == null)
    				ptr0.next = null;//到末位了 ptr0后面都断掉
    		}else {
    			if(flag) {//前面重复的，这时Ptr2已经指向下一个和前面重复元素不一样的元素，直接让重复元素前一个元素指向下一个
    				ptr0.next = ptr2;
    				flag = false;
    			}else {//如果不重复且标记为false，ptr0后移
    				ptr0 = ptr1;
    			}
    			ptr1 = ptr2;
    			ptr2 = ptr2.next;
    		}
    	}
    	return fakehead.next;
    	
        
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
