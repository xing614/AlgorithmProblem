package hard;
/**
 * 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6


 *
 * Definition for singly-linked list.
 * public class ListNode1 {
 *     int val;
 *     ListNode1 next;
 *     ListNode1(int x) { val = x; }
 * }
 *
 * @author liang
 *
 */
public class MergeKSortedLists {


	
	/**
	 * 常规归并算法，每次找到最小的
	 * 但是时间会超过限制
	 * @param lists
	 * @return
	 */
    public static ListNode1 mergeKLists(ListNode1[] lists) {
    	ListNode1 head = null;//头，作为返回
    	ListNode1 current = null;//当前位置
    	ListNode1 maxNode = new ListNode1(Integer.MAX_VALUE);
    	while(lists.length>0) {
    		ListNode1 minNode = maxNode;//最小的节点
    		int minIndex = -1;//最小节点在第几个链表上
    		for(int i=0;i<lists.length;i++) {
    			ListNode1 indexNode = lists[i];
    			if(indexNode== null) {
    				System.out.println("第"+i+"个链表已空");
    			}else if(indexNode.val<minNode.val) { //  当前节点比当前最小的要小
    				//保存最小的节点和最小节点的位置
    				minNode = indexNode;
    				minIndex = i;
    			}
    		}
    		if(minIndex == -1) {
    			break;
    		}
    		
    		//设置当前current对应的node
    		if(current == null) {
    			current = minNode;
    			head = minNode;
    		}else {
    			current.next = minNode;
    			current = current.next;
    		}
    		
    		//被选中的节点所指向的链表指针向后移动一位
    		lists[minIndex] = lists[minIndex].next!=null?lists[minIndex].next:null;
    		//ListNode1 ListNode1 = lists[minIndex];
    		//ListNode1 = ListNode1.next;
    		
    	}
    	
		return head;
        
    }
    
	public static void main(String[] args) {
		ListNode1 l1 = new ListNode1(1);
		ListNode1 l2 = new ListNode1(4);
		ListNode1 l3 = new ListNode1(5);
		ListNode1 l4 = new ListNode1(1);
		ListNode1 l5 = new ListNode1(3);
		ListNode1 l6 = new ListNode1(4);
		ListNode1 l7 = new ListNode1(2);
		ListNode1 l8 = new ListNode1(6);
		l1.next = l2;
		l2.next = l3;
		l4.next = l5;
		l5.next = l6;
		l7.next = l8;
		ListNode1[] ln = new ListNode1[3];
		ln[0] = l1;
		ln[1] = l4;
		ln[2] = l7;
		ListNode1 mergeKLists = mergeKLists(ln);
		while(mergeKLists!=null) {
			System.out.println(mergeKLists.val);
			mergeKLists = mergeKLists.next;
		}
	}

}

	class ListNode1{
	    int val;
	    ListNode1 next;
	    ListNode1(int x) { val = x; }		
	}
