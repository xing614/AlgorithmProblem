package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 133. 克隆图
题目描述提示帮助提交记录社区讨论阅读解答
克隆一张无向图，图中的每个节点包含一个 label （标签）和一个 neighbors （邻接点）列表 。

OJ的无向图序列化：

节点被唯一标记。

我们用 # 作为每个节点的分隔符，用 , 作为节点标签和邻接点的分隔符。

例如，序列化无向图 {0,1,2#1,2#2,2}。

该图总共有三个节点, 被两个分隔符  # 分为三部分。 

第一个节点的标签为 0，存在从节点 0 到节点 1 和节点 2 的两条边。
第二个节点的标签为 1，存在从节点 1 到节点 2 的一条边。
第三个节点的标签为 2，存在从节点 2 到节点 2 (本身) 的一条边，从而形成自环。
我们将图形可视化如下：

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 * @author liang
 *
 */
public class CloneGraph_133 {

	/**
	 * 这道题的意思是完整复制一份图，实际上考察的是图的遍历方法，
	 * 这道题主要使用BFS，然后先复制点，再复制边。
	 * 旧图与新图之间使用一个map来做映射。而且新节点中的neibour都是要新创建出来的。
	 * @param node
	 * @return
	 */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
        	return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();//形成映射
        Queue<UndirectedGraphNode> queue = new LinkedList<>();//队列用来记录图遍历节点
        map.put(node, newNode);
        queue.offer(node);
        while(!queue.isEmpty()) {
        	UndirectedGraphNode top = queue.poll();//弹出第一个
        	List<UndirectedGraphNode> neighbors = top.neighbors;//这个节点的所有相邻界点
        	for(UndirectedGraphNode neighbor:neighbors) {
        		if(!map.containsKey(neighbor)) {//未遍历到这个节点，则在map中不存在这个节点
        			UndirectedGraphNode newTmpNode = new UndirectedGraphNode(neighbor.label);//复制这节点
        			map.put(neighbor, newTmpNode);//放入
        			queue.offer(neighbor);//放入队列
        		}
        		map.get(top).neighbors.add(map.get(neighbor));
        	}
        }
        return newNode;//返回根节点
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class UndirectedGraphNode {
	    int label;
	    List<UndirectedGraphNode> neighbors;
	    UndirectedGraphNode(int x) { 
	    	label = x; 
	    	neighbors = new ArrayList<UndirectedGraphNode>();
	    }
	};


}
