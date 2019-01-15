package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * 539. 最小时间差
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。


示例 1：

输入: ["23:59","00:00"]
输出: 1

备注:

列表中时间数在 2~20000 之间。
每个时间取值在 00:00~23:59 之间。

 * @author liang
 *
 */
public class MinimumTimeDifference_539 {

	/**
	 * 先排序，然后计算时间差
	 * @param timePoints
	 * @return
	 */
	public int findMinDifference2(List<String> timePoints) {
        int n = timePoints.size();
        Collections.sort(timePoints); //对所有时间排序
        int res = 1440; // 24 * 60
        for(int i = 0; i < n; i++) {
            int diff = timeDiff(timePoints.get(i), timePoints.get((i+1)%n)); //获取时间差
            diff = Math.min(diff, 1440-diff);//由于时间24小时循环，两个时间之间会有2个时间差，取较小者
            res = Math.min(res, diff);//获取较小的时间差
        }
        return res;
    }

    private int timeDiff(String s1, String s2) {//获取两个时间的时间差
        int h1 = Integer.valueOf(s1.substring(0, 2));
        int m1 = Integer.valueOf(s1.substring(3, 5));
        int h2 = Integer.valueOf(s2.substring(0, 2));
        int m2 = Integer.valueOf(s2.substring(3, 5));
        return Math.abs((h1-h2)*60 + (m1-m2));
    }
    
    
	/**
	 * 先排序，然后比较相邻元素，最后比较第一个元素和最后一个元素
	 * @param timePoints
	 * @return
	 */
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        //升序排列
        Collections.sort(timePoints, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String[] time1 = o1.split(":");
				String[] time2 = o2.split(":");
				int res1 = Integer.parseInt(time1[0])*60+Integer.parseInt(time1[1]);
				int res2 = Integer.parseInt(time2[0])*60+Integer.parseInt(time2[1]);
				return res1-res2;
			}
        	
        });
        //比较相邻
        System.out.println(timePoints);
        for(int i = 0; i < timePoints.size() - 1; i ++){
            String[] time1 = timePoints.get(i).split(":");
            String[] time2 = timePoints.get(i+1).split(":");
            int result1 = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
            int result2 = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);
            if(min >= result2 - result1) min = result2 - result1;
        }
        //比较第一个和最后一个
        String[] time1 = timePoints.get(0).split(":");
        String[] time2 = timePoints.get(timePoints.size() - 1).split(":");
        int result1 = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
        int result2 = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);
        if(min >= result2 - result1) min = result2 - result1;
        if(min >= result1 + 24* 60 - result2) min = result1 + 24* 60 - result2;
        
        return min;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumTimeDifference_539 ss = new MinimumTimeDifference_539();
		List<String> t = new ArrayList<>();
		t.add("14:41");
		t.add("13:31");
		t.add("15:51");
		ss.findMinDifference(t);
	}

}
