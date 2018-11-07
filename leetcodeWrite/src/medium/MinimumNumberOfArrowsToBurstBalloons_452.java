package medium;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。

一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

Example:

输入:
[[10,16], [2,8], [1,6], [7,12]]

输出:
2

解释:
对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 * @author liang
 *
 */
public class MinimumNumberOfArrowsToBurstBalloons_452 {
	/**
	 * 贪心算法
	 * 先按Xstart的大小排序
	 * 然后按Xend的大小排序
	 * 贪心策略：从points数组第一个开始遍历，如果第i和前i-1个气球都有重叠，则他们可以一次击破
	 * 直到出现某个气球与它之前的某个气球不完全重叠，则需要射出一箭
	 * @param points
	 * @return
	 */
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0 ||points == null) {
        	return 0;
        }
        Arrays.sort(points,(a,b)->{return a[0] - b[0] == 0? a[1]-b[1] : a[0]-b[0];});
        int arrows = 1;//箭的数量
        int endPoint = points[0][1];//尾指针值
        for(int i=1;i<points.length;i++) {
        	if(points[i][0]<=endPoint) {
        		endPoint = endPoint<points[i][1]?endPoint:points[i][1];//即尾指针值是这个范围内最小的
        	}else {
        		arrows++;
        		endPoint = points[i][1];
        	}
        }
        return arrows;
    }
}
