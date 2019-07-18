package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 797. 所有可能的路径
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）

二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。

示例:
输入: [[1,2], [3], [3], []] 
输出: [[0,1,3],[0,2,3]] 
解释: 图是这样的:
0--->1
|    |
v    v
2--->3
这有两条路: 0 -> 1 -> 3 和 0 -> 2 -> 3.
提示:

结点的数量会在范围 [2, 15] 内。
你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。
 * @author liang
 *
 */
public class AllPathsFromSourcetoTarget_797 {

	//可以使用dfs和bfs+队列
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        List<Integer>list=new ArrayList<Integer>();
        list.add(0);
        solve(graph,res,list,0);
        return res;
    }
    //cur为第n个节点
	private void solve(int[][] graph, List<List<Integer>> res, List<Integer> list, int cur) {
		// TODO Auto-generated method stub
		if(list.size()>graph.length)//长度大于节点数
			return;
		if(cur == graph.length-1) {//到了最后一个节点
			res.add(new ArrayList<Integer>(list));
		}
		for(int i=0;i<graph[cur].length;i++) {
			list.add(graph[cur][i]);
			solve(graph,res,list,graph[cur][i]);
			list.remove(list.size()-1);
		}
	}
	//bfs+队列，设计数据结构Node包含当前位置值和前一个位置
	public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
		List<List<Integer>>res=new ArrayList<List<Integer>>();
		Queue<Node> que = new LinkedList<>();
		Node firstNode = new Node(null,0);
		que.add(firstNode);
		while(!que.isEmpty()) {
			Node cur = que.poll();
			int[] nexts = graph[cur.cur];
			for(int next:nexts){
				Node nextNode = new Node(cur,next);
				if(next == graph.length-1) {
					res.add(nextNode.getPath());
				}else {
					que.add(nextNode);
				}
			}
		}
		return res;
	}
	class Node{
		Node prev;
		int cur;
		public Node(Node prev, int cur) {
			super();
			this.prev = prev;
			this.cur = cur;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		public int getCur() {
			return cur;
		}
		public void setCur(int cur) {
			this.cur = cur;
		}
		public List<Integer> getPath(){//根据prev获取从头到该点的线路
			List<Integer> li = new ArrayList<>();
			li.add(cur);
			Node p = prev;
			while(p!=null) {
				li.add(p.cur);
				p = p.prev;
			}
			Collections.reverse(li);
			return li;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
