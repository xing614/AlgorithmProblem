package medium;

import java.util.Stack;

/**
 * 445. 两数相加 II
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。

 

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶:

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例:

输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出: 7 -> 8 -> 0 -> 7  
 * @author liang
 *
 */
public class AddTwoNumbersII_445 {
	/**
	 * 借用栈
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
        	return l2;
        if(l2 == null)
        	return l1;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while(l1!=null) {
        	st1.push(l1.val);
        	l1 = l1.next;
        }
        while(l2!=null) {
        	st2.push(l2.val);
        	l2 = l2.next;
        }
        int sum = 0;
        //head的下一个节点
        ListNode curNode = new ListNode(sum/10);
        while(!st1.isEmpty() || !st2.isEmpty()) {
        	if(!st1.isEmpty()) {
        		sum+=st1.pop();//获取最后一个元素弹出
        	}
        	if(!st2.isEmpty()) {
        		sum+=st2.pop();
        	}
        	ListNode head = new ListNode(sum/10);
        	curNode.val = sum %10;
        	head.next = curNode;
        	curNode = head;
        	sum/=10;//下次使用，进制位
        }
        if(curNode.val == 0)
        	curNode = curNode.next;
        return curNode;
    }
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
}
