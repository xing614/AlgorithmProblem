package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1:

输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
输出: [[1,5],[6,9]]
示例 2:

输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出: [[1,2],[3,10],[12,16]]
解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。


 * @author liang
 *
 */
public class InsertInterval_57 {

	/**
	 * 遍历每一个已给出的interval，
	 * 当 当前的interval的end小于newInterval的start时，说明新的区间在当前遍历到的区间的后面，并且没有重叠，所以res添加当前的interval；
	 * 当 当前的interval的start大于newInterval的end时，说明新的区间比当前遍历到的区间要前面，并且也没有重叠，所以把newInterval添加到res里，并更新newInterval为当前的interval； 
	 * 当 当前的interval与newInterval有重叠时，merge interval并更新新的newInterval为merge后的
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> res = new ArrayList<Interval>();
    	for(Interval inter:intervals) {
    		if(inter.end<newInterval.start) {
    			res.add(inter);//每次不重叠直接添加到res中
    		}else if(inter.start>newInterval.end){
    			res.add(newInterval);
    			newInterval = inter;//新添加的加进去了，intervals剩余的依次放入
    		}else if(inter.end>=newInterval.start||inter.start<=newInterval.end) {//存在重叠
    			int start = Math.min(inter.start, newInterval.start);
    			int end = Math.max(inter.end, newInterval.start);
    			newInterval = new Interval(start,end);
    		}
    	}
    	res.add(newInterval);
		return res;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
}
