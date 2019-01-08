package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 593. 有效的正方形
 * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。

一个点的坐标（x，y）由一个有两个整数的整数数组表示。

示例:

输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
输出: True
 

注意:

所有输入整数都在 [-10000，10000] 范围内。
一个有效的正方形有四个等长的正长和四个等角（90度角）。
输入点没有顺序。
 * @author liang
 *
 */
public class ValidSquare_593 {

	/**
	 * 先将四个点按X轴排序，然后判断四条边长度相同，两条对角线长度相同
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 * @return
	 */
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int[]> li = new ArrayList<>();
        li.add(p1);
        li.add(p2);
        li.add(p3);
        li.add(p4);
        Collections.sort(li, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				// TODO Auto-generated method stub
				if(a[0]>b[0])
					return 1;
				else if(a[0]<b[0])
					return -1;
				else {
					if(a[1]>b[1])
						return 1;
					else if(a[1]<b[1])
						return -1;
					else return 0;
				}
			}
		});
//        Iterator<int[]> iterator = li.iterator();
//        while(iterator.hasNext()) {
//        	System.out.println(iterator.next()[0]);
//        }
//        	
//        System.out.println(li);
        //判断正方形边长是否相等，对角线是否相等
        return distance(li.get(0),li.get(1)) == distance(li.get(0),li.get(2))
        		&& distance(li.get(0), li.get(1)) == distance(li.get(1), li.get(3))
                && distance(li.get(0), li.get(2)) == distance(li.get(2), li.get(3))
                && distance(li.get(1), li.get(3)) == distance(li.get(2), li.get(3))
                && distance(li.get(0), li.get(3)) == distance(li.get(1), li.get(2))
                && distance(li.get(0), li.get(3)) > 0
                && distance(li.get(0), li.get(1)) > 0;
        
    }
    
    // 计算两点之间的距离平方
	private static int distance(int[] a, int[] b) {
		// TODO Auto-generated method stub
		
		return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p1 = {1,1};
		int[] p2 = {0,1};
				int[] p3 = {1,0};
				int[] p4 = {0,0};
		validSquare(p1,p2,p3,p4);
	}

}
