package medium;
/**
 * 147. 对链表进行插入排序
对链表进行插入排序。


插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

 

插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
 

示例 1：

输入: 4->2->1->3
输出: 1->2->3->4
示例 2：

输入: -1->5->3->4->0
输出: -1->0->3->4->5
 * @author liang
 *
 */
public class InsertionSortList_147 {

    public  ListNode insertionSortList(ListNode head) {
    	if(head == null)
    		return head;
    	ListNode helper = new ListNode(0);//最初是空，然后一个一个通过pre往上加
    	ListNode cur = head;//将被插入的节点
    	ListNode pre = helper;//pre和pre.next
    	ListNode next = null;//将被插入的下一个节点
    	while(cur != null) {
    		next = cur.next;
    		//找到合适的插入位置,下一个值要大于要被插入的cur值
    		while(pre.next!=null && pre.next.val<cur.val) {
    			pre = pre.next;
    		}
    		//找到了要插入的位置pre之后,进行插入操作
    		cur.next = pre.next;
    		pre.next = cur;
    		pre = helper;//前置位归零
    		cur = next;//确立下一个要插入的数据
    	}
    	
    	
		return helper.next;
        
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
