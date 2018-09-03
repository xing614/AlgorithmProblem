package medium;
/**
 * ���������ǿ���������ʾ�����Ǹ�������λ����������ʽ�洢�����ǵ�ÿ���ڵ�ֻ�洢�������֡���������ӷ���һ���µ�����
	
	����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��
	
	ʾ����
	
	���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
	�����7 -> 0 -> 8
	ԭ��342 + 465 = 807
 * @author liang
 *
 */
public class AddTwoNumbers {


	/*
	 * ����һ,l1��l2��һ����ʱ���̵Ĳ���
	 */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
    	ListNode tem = new ListNode(0);//��һ��λ��Ϊ0���ӵڶ���λ�ÿ�ʼ����������ʱ�ӵڶ�����ʼ
    	ListNode result = tem;
    	int valueTen = 0;//ʮλ
    	int valueIndi = 0;//��λ
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
    			l1 = new ListNode(0);//���l1�ǿգ��Ͳ����ټ���
    		}
    		if(l2 ==null) {
    			l2 = new ListNode(0);//���l2�ǿգ��Ͳ����ټ���
    		}
    	}
    	if(valueTen!=0)//���һλ
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
		//Ӧ����708
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
