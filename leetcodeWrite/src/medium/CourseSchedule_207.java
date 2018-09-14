package medium;

import java.util.ArrayList;

/**
 * 207. 课程表
现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？

示例 1:

输入: 2, [[1,0]] 
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
说明:

输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
提示:

这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
拓扑排序也可以通过 BFS 完成。
 * @author liang
 *
 */
public class CourseSchedule_207 {

	/**
	 * 图的遍历，使用dfs
	 * 先建立好有向图，
	 * 然后从第一个门课开始，找其可构成哪门课，
	 * 暂时将当前课程标记为已访问，然后对新得到的课程调用DFS递归，直到出现新的课程已经访问过了，则返回false，
	 * 没有冲突的话返回true，然后把标记为已访问的课程改为未访问。
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList[] list = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++){
            list[i] = new ArrayList<Integer>();
        }
        //建立有向图
        for (int i = 0; i < prerequisites.length; i++){//对先决条件添加它的后续课程
            list[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean[] visit = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++){
            if (!dfs(list, visit, i)){
                return false;
            }
        }
        return true;
    }
    /**
     * 比如最开始i为0位置，进入dfs判断当前位置是否看过，没看过先设为true,然后遍历i位置图相邻的节点，判断这个节点是否看过
     * 没看过接着设为true，如果看过就说明可以构成一个环，但图不能成环所以返回false
     * @param list
     * @param visit
     * @param pos
     * @return
     */
	private boolean dfs(ArrayList[] list, boolean[] visit, int pos) {
        if (visit[pos]){
            return false;
        } else {
            visit[pos] = true;
        }
        for (int i = 0; i < list[pos].size(); i++){//pos相连的其他节点
            if (!dfs(list, visit, (int) list[pos].get(i))){//看pos连得其他节点是否有被 visit过
                return false;
            }
            list[pos].remove(i);
        }
        visit[pos] = false;
        return true;
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
