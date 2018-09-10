package medium;

import java.util.HashMap;

/**
 * 138. 复制带随机指针的链表
题目描述提示帮助提交记录社区讨论阅读解答
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的深度拷贝。 
 * @author liang
 *
 */
public class CopyListWithRandomPointer_138 {

	/**
	 * 与克隆图133相似
	 * 不同是这个除了节点，还有next,random
	 * 先遍历克隆所有节点，在遍历克隆所有next和random
	 * @param head
	 * @return
	 */
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode,RandomListNode> maps = new HashMap<>();
        //进行第一次遍历  将节点存入哈希表
		RandomListNode cur=head;
		while(cur!=null){
			RandomListNode newNode = new RandomListNode(cur.label);
			maps.put(cur, newNode);
			cur = cur.next;
		}
		//第二次遍历，存储节点的next和random
		cur = head;
		while(cur!=null) {
			RandomListNode node=maps.get(cur);
			node.next=maps.get(cur.next);
			node.random=maps.get(cur.random);
			cur=cur.next;
		}
		return maps.get(head);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class RandomListNode {
	    int label;
	    RandomListNode next, random;
	    RandomListNode(int x) { this.label = x; }
	};

}
