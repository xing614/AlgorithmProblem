package medium;
/**
 * 86. 分隔链表
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

示例:

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
 * @author liang
 *
 */
public class PartitionList_86 {

	/**
	 * 给一个链表，将小于值x的结点放到所有大于等于值x的结点的前面，不要改变结点之间的顺序（例如1,4,3,2,5,2 将2结点提到至4的前面，但4,3,5的顺序不变）；
	 * 思路：设置一个变量，记录下链表中第一次出现大于等于值x结点的位置insertPos。之后遍历链表，将所有小于值x的结点提到这个位置上；
	 * 需要注意的是，提取结点时的操作：1.当前结点的上一个结点的next指向当前结点的next；
	 * 2.当前结点的next指向insertPos的next，insertPos的next指向当前结点；
	 * @param head
	 * @param x
	 * @return
	 */
    public ListNode partition(ListNode head, int x) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode cur = preHead.next;
        ListNode insertPos = null;
        while(cur!=null) {
        	//定位需要插入的位置;  大于x的节点之前一个节点
        	if(cur.val>=x && insertPos == null) {
        		insertPos = pre;//找到大于3的节点4的前一个节点1
        	}
        	//插入操作
        	if(cur.val<x && insertPos != null) {
        		pre.next = pre.next.next; //3-》2变成3-》5
        		cur.next = insertPos.next;//2-》5变成2-》4
        		insertPos.next = cur;//1-》4变成1-》2
        		insertPos = insertPos.next;//inser重新变成4的前一位，每次插入一个就往后错位一个
        		cur = pre.next;//cur当前数字插到前面了，所有现在再遍历时cur变成刚才那个数的后一个数
        	}
        	pre=pre.next;
            cur=cur.next;
        }
        return preHead.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
