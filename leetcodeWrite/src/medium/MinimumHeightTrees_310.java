package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 310. 最小高度树
题目描述提示帮助提交记录社区讨论阅读解答
对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。

格式

该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。

你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。

示例 1:

输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3 

输出: [1]
示例 2:

输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5 

输出: [3, 4]
说明:

 根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 * @author liang
 *
 */
public class MinimumHeightTrees_310 {

	/**
	 * 理解：
	 * 就是每次先遍历最外层叶子节点（只与一个节点连接的节点）
	 * 然后找这些叶子节点相连的节点，中也只与一个节点相连的节点放入新的list
	 * 直到找到最后
	 */
	
	/**
	 * 因为树就是两个点被一条线链接的无向图，所以先用一个list把树存成无向图的列表。
	 * 可以从头边同时进行，查看叶子节点并加入到叶子节点链表（遍历一遍后，叶子节点链表size 为1）。
	 * 将叶子节点保存下来。
	 * 这些叶子节点不用再查，但是剩余的中间节点，要依次查看，
	 * 把跟第一层叶子节点有关的图的矩阵里对应的记录全部删除，类似于剥除最外面一圈所有的点。 
	 * 这个时候就会有第二层叶子节点（那些在列表当中size为1的点），用同样的方法进行剥除。
	 * 最后留在叶子节点list里面的点即可以为根。
	 * @param n 一共n个节点
 	 * @param edges  边
	 * @return
	 */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if(n == 1) {
        	leaves.add(0);
        	return leaves;
        }
        //存储左点对应右点 和 右点对应左点
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        	adj.add(new HashSet<>());
        //在list保存左右点对应
        for(int[] edge:edges) {
        	adj.get(edge[0]).add(edge[1]);//在list第edge[0]存放edge[1]
        	adj.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n;i++) {
        	if(adj.get(i).size() == 1)//存在一个连接点数据
        		leaves.add(i);//放入leaves当作潜在的根节点
        }
        while(n>2) {
        	n -= leaves.size();
        	List<Integer> newLeaves = new ArrayList<>();
        	for(int i:leaves) {//潜在根节点
        		for(int j:adj.get(i)) {//获取根节点对应的多个连接点
        			adj.get(j).remove(i);//移除这些连接点与i连接
        			if(adj.get(j).size() == 1)//该位置只与一个节点相连
        				newLeaves.add(j);//它将作为下一次遍历的节点
        		}
        	}
        	leaves = newLeaves;
        }
        return leaves;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
