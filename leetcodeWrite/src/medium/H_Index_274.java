package medium;

import java.util.Arrays;

/**
 * 274. H指数
给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。

h 指数的定义: “一位有 h 指数的学者，代表他（她）的 N 篇论文中至多有 h 篇论文，分别被引用了至少 h 次，其余的 N - h 篇论文每篇被引用次数不多于 h 次。”

示例:

输入: citations = [3,0,6,1,5]
输出: 3 
解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
     由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
说明: 如果 h 有多种可能的值，h 指数是其中最大的那个。
 * @author liang
 *
 */
public class H_Index_274 {

	/**
	 * 先对数组排序，
	 * 然后从后向前遍历，
	 * 维护一个count变量，当count值大于或等于现在的值时，就可以返回了。
	 * 如果到最后退出循环时，仍未返回，那表示数组中的数都大于count，那么就返回count。
	 * 因为此时有0个数小于count，有count数大于count。
	 * @param citations
	 * @return
	 */
    public int hIndex(int[] citations) {
        int size = citations.length;
        if(size<0)
        	return 0;
        Arrays.sort(citations);
        int count = 0;
        for(int i =size-1;i>=0;i--) {
        	if(count>=citations[i]) {
        		return count;
        	}
        	count++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
