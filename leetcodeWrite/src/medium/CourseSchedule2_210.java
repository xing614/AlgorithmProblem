package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. 课程表 II
现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

示例 1:

输入: 2, [[1,0]] 
输出: [0,1]
解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
示例 2:

输入: 4, [[1,0],[2,0],[3,1],[3,2]]
输出: [0,1,2,3] or [0,2,1,3]
解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
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
public class CourseSchedule2_210 {

	/**
	 * 入度 (in-degree) ：以某顶点为弧头，终止于该顶点的弧的数目称为该顶点的入度。就是说存在在[i][1]中且在[j][0]中没有这个元素,[i][1]是前置条件
	 * 使用拓扑排序，每次删除一个入度为0的点，用一个list保存每次删除的点（入度为0的点）（入度为0就说明它的前置条件都满足了，可以放入结果了）
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];//保存每个入度数
        for(int i=0;i<prerequisites.length;i++) {
        	inDegree[prerequisites[i][0]]++;//1位置是前置条件，看0位置的入度数
        }
        Queue<Integer> queue = new  LinkedList<>();//存放入度为0的元素
        for(int i=0;i<inDegree.length;i++) {
        	if(inDegree[i] ==0)//入度为0的元素
        		queue.add(i);
        }
        List<Integer> res = new ArrayList<>();
        int count = queue.size();//入度为0数，之后每放入一个之后添加前置条件入度变为0的元素，该值+1，与numCourses比较
        while(!queue.isEmpty()) {
        	int tmp = queue.poll();//弹出第一个元素
        	res.add(tmp);
        	for(int i=0;i<prerequisites.length;i++) {
        		if(tmp == prerequisites[i][1]) {//弹出的元素是某元素前置条件
        			int t = prerequisites[i][0];
        			inDegree[t]--;//在res放入这个前置条件后，就可以入度-1
        			if(inDegree[t]==0) {//入度为0就可放入queue等候根据它消去其他入度
        				queue.add(t);
        				count++;
        			}
        		}
        	}
        }
        if(count != numCourses) {//数量不对，
        	int[] a = new int[0];
        	return a;
        }else {
        	int[] a = new int[res.size()];
        	for(int i =res.size()-1;i>=0;i--) {
        		 a[i] = res.get(i);
        	}
        	return a;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
