package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * 939. 最小面积矩形
 * 给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。

如果没有任何矩形，就返回 0。

 

示例 1：

输入：[[1,1],[1,3],[3,1],[3,3],[2,2]]
输出：4
示例 2：

输入：[[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
输出：2
 

提示：

1 <= points.length <= 500
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
所有的点都是不同的。
 * @author liang
 *
 */
public class MinimumAreaRectangle_939 {

	/**
	 * 使用对角线判断是否是矩形，使用map<integer,set<integer>>保存 key为x坐标，y为x坐标下包含的点的y的坐标集合
	 * @param points
	 * @return
	 */
    public int minAreaRect(int[][] points) {
        HashMap<Integer,Set<Integer>> hm = new HashMap<>();
        Arrays.sort(points,Comparator.comparingInt(a -> a[0]));//按照x坐标排序
        int area = Integer.MAX_VALUE;//设置默认为最大值
        for(int i=0;i<points.length;i++) {
        	Set<Integer> yCur = hm.getOrDefault(points[i][0], new HashSet<>());//获得该x坐标下的所有y坐标
        	for(int j=0;j<i;j++) {
        		if(points[i][0]==points[j][0]) break;
        		Set<Integer> yTwo = hm.getOrDefault(points[j][0], new HashSet<>());//当前比较两个节点中的第二个x节点下的y坐标集合
        		if(yCur.contains(points[j][1]) && yTwo.contains(points[i][1])) {//表示另外两个点与i和j点对称
        			area = Math.min(area, Math.abs(points[i][0]-points[j][0])*Math.abs(points[i][1]-points[j][1]));
        		}
        	}
        	yCur.add(points[i][1]);
        	hm.put(points[i][0], yCur);
        }
        return area == Integer.MAX_VALUE?0:area;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
