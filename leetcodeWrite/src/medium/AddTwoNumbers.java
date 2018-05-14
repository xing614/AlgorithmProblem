package medium;
/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
	
	你可以假设除了数字 0 之外，这两个数字都不会以零开头。
	
	示例：
	
	输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
	输出：7 -> 0 -> 8
	原因：342 + 465 = 807
 * @author liang
 *
 */
public class AddTwoNumbers {


	/*
	 * 方案一,l1或l2不一样长时，短的补上
	 */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
    	ListNode tem = new ListNode(0);//第一个位置为0，从第二个位置开始计数，返回时从第二个开始
    	ListNode result = tem;
    	int valueTen = 0;//十位
    	int valueIndi = 0;//个位
    	int all = 0;
    	while(l1!=null && l2!=null) {
    		all = l1.val+l2.val+valueTen;
    		valueTen = all/10;
    		valueIndi = all%10;
    		ListNode next = new ListNode(valueIndi);
    		tem.next = next;
    		l1 = l1.next;
    		l2 = l2.next;
    		tem = tem.next;
    		if(l1 == null &&l2 == null) {
    			break;
    		}
    		if(l1 ==null) {
    			l1 = new ListNode(0);//如果l1是空，就补上再计算
    		}
    		if(l2 ==null) {
    			l2 = new ListNode(0);//如果l2是空，就补上再计算
    		}
    	}
    	if(valueTen!=0)//最后一位
    		tem.next = new ListNode(valueTen);
		return result.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);//243
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);//564
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		//应该是708
		ListNode ll = addTwoNumbers(l1,l2);
		while(ll!=null) {
			System.out.println(ll.val);
			ll = ll.next;
		}
	}

}
class ListNode{
	   int val;
	   ListNode next;
	   ListNode(int x) { val = x; }
	}
