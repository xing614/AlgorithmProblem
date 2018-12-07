package medium;

import java.util.Random;

/**
 * 497. 非重叠矩形中的随机点
 * 给定一个非重叠轴对齐矩形的列表 rects，写一个函数 pick 随机均匀地选取矩形覆盖的空间中的整数点。

提示：

整数点是具有整数坐标的点。
矩形周边上的点包含在矩形覆盖的空间中。
第 i 个矩形 rects [i] = [x1，y1，x2，y2]，其中 [x1，y1] 是左下角的整数坐标，[x2，y2] 是右上角的整数坐标。
每个矩形的长度和宽度不超过 2000。
1 <= rects.length <= 100
pick 以整数坐标数组 [p_x, p_y] 的形式返回一个点。
pick 最多被调用10000次。
 

示例 1：

输入: 
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
输出: 
[null,[4,1],[4,1],[3,3]]
示例 2：

输入: 
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
输出: 
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 

输入语法的说明：

输入是两个列表：调用的子例程及其参数。Solution 的构造函数有一个参数，即矩形数组 rects。pick 没有参数。参数总是用列表包装的，即使没有也是如此。
 * @author liang
 *
 */
public class RandomPointinNonOverlappingRectangles_497 {

	private int[][] rects;
	private Random rd;
	private int[] sum;//到第i个长方形为止的面积和
	private int total;//面积总和
	/**
	 * 先根据面积作为权重，按概率选到长方形。之后在这个长方形的范围内随机选x和y，输出
	 * @param rects
	 */
    public RandomPointinNonOverlappingRectangles_497(int[][] rects) {
        this.rects = rects;
        this.rd = new Random();
        int[] weight = new int[rects.length];//权重 就是面积
        for(int i= 0;i<rects.length;i++) {
        	weight[i] = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
        }
        this.sum = new int[weight.length];
        this.total = 0;
        for (int i = 0; i < sum.length; i++) {
            total += weight[i];
            sum[i] = total;
        }
    }
    
    public int[] pick() {
        int[] rect = rects[pickRect()];
        int x = rect[0] + rd.nextInt(rect[2] - rect[0] + 1);//随机出x坐标
        int y = rect[1] + rd.nextInt(rect[3] - rect[1] + 1);
        return new int[] {x, y};
    }

    /**
     * 使用二分法找到 随机出来的面积在第几个长方形中
     * @return
     */
    private int pickRect() {
        int target = rd.nextInt(total);
        int i = 0, j = sum.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (sum[mid] > target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
    
}
