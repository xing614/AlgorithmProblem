package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 332.重新安排行程
 * 
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。

说明:

如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
所有的机场都用三个大写字母表示（机场代码）。
假定所有机票至少存在一种合理的行程。
示例 1:

输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
示例 2:

输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。

 * @author liang
 */
public class ReconstructItinerary_332 {

	Map<String,PriorityQueue<String>> map = new HashMap<>();//保存每个点及其邻节点
	List<String> res = new ArrayList<>();
	/**
	 * 用一个hashmap<String,PriorityQueue<String>>保存每个点及其邻节点，
	 * 然后使用深度遍历，第一次得到的结果便是答案（因为每次都是用的最小路径）。
	 * 
	 * 另外一种方法是每次找到终点，然后删除该点继续查找下一个终点，最后得到的结果反转即可。
	 * @param tickets
	 * @return
	 */
    public List<String> findItinerary(String[][] tickets) {
        for(String[] ticket:tickets) {
        	//computeIfAbsent如果map里没有这个key，那么就按照后面的这个function添加对应的key和value
        	map.computeIfAbsent(ticket[0], k->new PriorityQueue<>()).add(ticket[1]);
        }
        dfs("JFK");
        Collections.reverse(res);//翻转
        return res;
    }
    
	private void dfs(String node) {
		PriorityQueue<String> priorityQueue = map.get(node);
		while(priorityQueue!=null && !priorityQueue.isEmpty()) {
			dfs(priorityQueue.poll());
		}
		res.add(node);//就是倒序插入元素的
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
