package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
示例 1:

输入: [ [1,2], [2,3], [3,4], [1,3] ]

输出: 1

解释: 移除 [1,3] 后，剩下的区间没有重叠。
示例 2:

输入: [ [1,2], [1,2], [1,2] ]

输出: 2

解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
示例 3:

输入: [ [1,2], [2,3] ]

输出: 0

解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * @author liang
 *
 */
public class Non_overlappingIntervals_435 {
	/**
	 * 贪心问题，
	 * 每次都找到那个结束点最小的区间，然后依次向后找那些与前面区间不冲突且结束点早的区间。
	 * 这个过程中把局部的最优解合并成了全局的最优解。
	 * @param intervals
	 * @return
	 */
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0)
        	return 0;
        
        /**
         * end小的放在前面
         */
        Comparator<Interval> com = new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.end>o2.end) {
					return 1;
				}else if(o1.end<o2.end) {
					return -1;
				}else {
					return 0;
				}
			}
        	
        };
        Arrays.sort(intervals,com);
        
        int lastEnd = intervals[0].end;
        int remove = 0;
        for(int i =1;i<intervals.length;i++) {
        	if(intervals[i].end == lastEnd)//被包含
        		remove++;
        	else if(intervals[i].start<lastEnd)//有重合
        		remove++;
        	else
        		lastEnd = intervals[i].end;
        }
        
        return remove;
    }
    
    public static void main(String[] args) {
    	Non_overlappingIntervals_435 no = new Non_overlappingIntervals_435();
    	Interval i1 = no.new Interval(1,2);
    	Interval i2 = no.new Interval(1,3);
    	Interval i3 = no.new Interval(2,3);
    	Interval i4 = no.new Interval(3,5);
    	Interval[] intervals= {i1,i2,i3,i4};
    	no.eraseOverlapIntervals(intervals);
    }
    
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }  
    
    
}



