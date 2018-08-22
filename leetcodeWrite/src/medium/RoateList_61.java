package medium;
/**
 * 61. 旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
 * @author liang
 *
 */
public class RoateList_61 {

	/**
	 * 先遍历一遍，得出链表长度 len，注意 k 可能大于 len，因此令 k% = len。
	 * 将尾节点 next 指针指向首节点，形成一个环，接着往后跑 len -  k 步，从这里断开，就是要求的结果了。
	 * @param head
	 * @param k
	 * @return
	 */
    public ListNode rotateRight(ListNode head, int k) {
        if(head ==null || k==0) {
        	return head;
        }
        int count = 1;//链表长度
        ListNode pre = head;
        while(pre.next !=null) {
        	count++;
        	pre = pre.next;
        }
        pre.next = head;//串成一个环
        k = k% count; //k可能大于链表长度
        int index = 1;
        pre = head;
        ListNode cur = head;
        //右移k位,就是说末位k个移到前面，说明len-k位置断开
        while(index<=(count-k)) {
        	pre = cur;
        	cur = cur.next;
        	index++;
        }
        //新的首尾节点
        pre.next = null;
        head = cur;
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
