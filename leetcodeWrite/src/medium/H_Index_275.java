package medium;
/**
 * 275. H指数 II
题目描述提示帮助提交记录社区讨论阅读解答
给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。

h 指数的定义: “一位有 h 指数的学者，代表他（她）的 N 篇论文中至多有 h 篇论文，分别被引用了至少 h 次，其余的 N - h 篇论文每篇被引用次数不多于 h 次。"

示例:

输入: citations = [0,1,3,5,6]
输出: 3 
解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
     由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
说明:

如果 h 有多有种可能的值 ，h 指数是其中最大的那个。

进阶：

这是 H指数 的延伸题目，本题中的 citations 数组是保证有序的。
你可以优化你的算法到对数时间复杂度吗？
 * @author liang
 *
 */
public class H_Index_275 {

	/**
	 * 使用二分法 对数时间
	 * @param citations
	 * @return
	 */
    public static int hIndex(int[] citations) {
        int left = 0,right = citations.length-1;
        while(left<=right){
        	int mid = left + (right-left)/2;
        	System.out.println(mid);
        	if(citations[citations.length - mid - 1]>mid) {//说明这个位置的数（被引用次数）> 当前位置。则接着向右二分
        		left = mid+1;
        	}else {
        		right = mid-1;
        	}
        }
        return left;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] aa = {0,1,3,5,6};
		hIndex(aa);
	}

}
