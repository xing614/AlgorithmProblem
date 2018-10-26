package medium;

import java.util.Random;

/**
 * 382. 链表随机节点
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。

进阶:
如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？

示例:

// 初始化一个单链表 [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
solution.getRandom();
 * @author liang
 *
 */
public class LinkedListRandomNode_382 {
	
	/**
	 * 蓄水池抽样
	 * 原理：
	 * 数据流只有一个数据。我们接收数据，发现数据流结束了，直接返回该数据，该数据返回的概率为1。
	 * 读到了第一个数据，这次不能直接返回该数据，因为数据流没有结束。继续读取第二个数据，发现数据流结束了。因此只要保证以相同的概率返回第一个或者第二个数据就可以满足题目要求。因此我们生成一个0到1的随机数R,如果R小于0.5我们就返回第一个数据，如果R大于0.5，返回第二个数据。
	 * 三个数据的数据流：们按顺序给流中的数据命名为1、2、3。我们陆续收到了数据1、2和前面的例子一样，我们只能保存一个数据，所以必须淘汰1和2中的一个。
	 * 		应该如何淘汰呢？不妨和上面例子一样，我们按照二分之一的概率淘汰一个，例如我们淘汰了2。
	 * 		继续读取流中的数据3，发现数据流结束了，我们知道在长度为3的数据流中，如果返回数据3的概率为1/3,那么才有可能保证选择的正确性。
	 * 		也就是说，目前我们手里有1,3两个数据，我们通过一次随机选择，以1/3的概率留下数据3，以2/3的概率留下数据1.那么数据1被最终留下的概率是多少呢？
	 * 数据1被留下：（1/2）*(2/3) = 1/3
	 * 数据2被留下概率：（1/2）*(2/3) = 1/3
	 * 数据3被留下概率：1/3
	 * 
	 * 第 i 个数被选中的概率为它被选中的概率：1 / i ，乘以后面的数不被选中的概率：[ i / ( i + 1 ) ] * [ ( i + 1 ) / ( i + 2 ) ] *... * [ ( n  - 1 ) / ( n + 1 )]
	 * 
	 * 即P（第 i 个数被选中） ＝ （  1 / i  ）* [ i / ( i + 1 ) ] * [ ( i + 1 ) / ( i + 2 ) ] *... * [ ( n  - 1 ) / ( n + 1 )] = 1 / n 
	 */
	
	static ListNode h = null;
	
	public LinkedListRandomNode_382(ListNode head) {
	    this.h = head;
	}
	
	/** Returns a random node's value. */
	public int getRandom() {
	    Random rand = new Random();
	    int ans = -1;
	    int ind = 0;
	    ListNode p = h;
	    while(p!=null) {
	    	ind++;
	    	int rn = rand.nextInt(ind);
	    	if(rn == ind-1) {//如果抽中的是最后一个数，就改变ans，否则不改变
	    		ans = p.val;
	    	}
	    	p = p.next;
	    }
	    return ans;
	}
}
