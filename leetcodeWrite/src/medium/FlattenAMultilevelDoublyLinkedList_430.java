package medium;

/**
 * 430. 扁平化多级双向链表
 * 
扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。

 

示例:

输入:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

输出:
1-2-3-7-8-11-12-9-10-4-5-6-NULL
 * @author liang
 *
 */
public class FlattenAMultilevelDoublyLinkedList_430 {
	
	/**
	 * 要求把这个带有子节点的双向链表转化为一个不带子节点的双向链表，其规则是把子节点所有的节点都插入到该节点的后面。
	 * @param head
	 * @return
	 */
    public Node flatten(Node head) {
        Node ret = head;
        dfs(head);
        return ret;
    }

	private Node dfs(Node head) {
		// TODO Auto-generated method stub
		Node curr = head;
		Node save;
		while(head!=null) {
			save = head.next;
			if(head.child!=null) {
				Node temp = head.next;
				head.next = head.child;
				head.child.prev = head;
				head.child = null;
				temp = dfs(head.next);
				if(temp!=null && save!=null) {
					temp.next = save;//子树最后一个节点连接 之前的head.next
					save.prev = temp;// 之前的head.next的prev 连接子树最后一个节点
				}
			}
			if(save == null) {//当前节点没有下一个节点了
				break;
			}
			head = save;//进入下一个节点
		}
		return head;
	}
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};