package medium;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 436. 寻找右区间
 * 给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。

对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。

注意:

你可以假设区间的终点总是大于它的起始点。
你可以假定这些区间都不具有相同的起始点。
示例 1:

输入: [ [1,2] ]
输出: [-1]

解释:集合中只有一个区间，所以输出-1。
示例 2:

输入: [ [3,4], [2,3], [1,2] ]
输出: [-1, 0, 1]

解释:对于[3,4]，没有满足条件的“右侧”区间。
对于[2,3]，区间[3,4]具有最小的“右”起点;
对于[1,2]，区间[2,3]具有最小的“右”起点。
示例 3:

输入: [ [1,4], [2,3], [3,4] ]
输出: [-1, 2, -1]

解释:对于区间[1,4]和[3,4]，没有满足条件的“右侧”区间。
对于[2,3]，区间[3,4]有最小的“右”起点。
 * @author liang
 *
 */
public class FindRightInterval_436 {

	/**
	 * 使用TreeMap 
	 * 首先将所有起始位置和他的序号放入TreeMap（key是位置I的起始位置，value是I）当中
	 * 随后遍历每个位置的结束为止，使用TreeMap的方法，使用当前序号结束位置的大小找到TreeMap中第一个大于等于其结束位置的Entry，如果存在则取出value，不然就返回-1
	 * @param intervals
	 * @return
	 */
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer,Integer> tm = new TreeMap<>();//key为区间的start，value为第几个区间
        for(int i=0;i<intervals.length;i++) {
        	tm.put(intervals[i].start, i);
        }
        for(int i=0;i<intervals.length;i++) {
        	//方法调用返回的最小键大于intervals[i].end的最小entry
        	Map.Entry<Integer, Integer> entry = tm.ceilingEntry(intervals[i].end);
        	result[i] = (entry!=null) ?entry.getValue():-1;
        }
        return result;
        
    }
    
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
