package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @author liang
 *
 */
public class MergeIntervals {
	/**
	 * 思路：先排序，然后检查相邻两个区间，看前一个区间的结尾是否大于后一个区间的开始，注意前一个区间包含后一个区间的情况。
	 * 用Java自带的sort()方法，只要自己重写compare()方法即可。
	 * @param intervals
	 * @return
	 */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> li = new ArrayList<Interval>();
        if(intervals.size() == 0) return li;
        Collections.sort(intervals, new MyComparator());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i=0; i<intervals.size();i++) {
        	Interval interval = intervals.get(i);
        	if(interval.start>end) {//后一个start大于前一个end，说明这俩没重合
        		li.add(new Interval(start,end));//所以直接保留前一个元素
        		start = interval.start;
        		end = interval.end;
        	}else {//后一个start小于前一个end，说明存在重合，则确定end大的值，然后接着遍历
        		end = Math.max(end, interval.end);
        	}
        }
        li.add(new Interval(start,end));//遍历到最后一个也是重合之后，保存它
        return li;
    }
    
    
    public class MyComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start-o2.start;
		}
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}