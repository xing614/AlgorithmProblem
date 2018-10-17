package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 373. 查找和最小的K对数字
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。

定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。

找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。

示例 1:

输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
输出: [1,2],[1,4],[1,6]
解释: 返回序列中的前 3 对数：
     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
示例 2:

输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
输出: [1,1],[1,1]
解释: 返回序列中的前 2 对数：
     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
示例 3:

输入: nums1 = [1,2], nums2 = [3], k = 3 
输出: [1,3],[2,3]
解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * @author liang
 *
 */
public class FindKPairsWithSmallestSums_373 {

	/**
	 * 用最小堆保存遍历过程中的pairs
	 * 当遍历到(i,j)时，继续往下遍历，相邻的结点是(i+1,j)，(i,j+1) 
	 * 因为是有序数组，这两个pair是较小的，加入堆中。
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<int[]> res = new ArrayList<int[]>();
    	boolean visit[][] = new boolean[nums1.length][nums2.length];
    	if(nums1.length == 0 ||nums2.length == 0) {
    		return res;
    	}
    	//优先队列做最小堆
    	Queue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] i, int[] j) {
				// TODO Auto-generated method stub
				return (nums1[i[0]]+nums2[i[1]]-(nums1[j[0]]+nums2[j[1]]));//前一组两个数和  - 后一组两个数和
			}
    		
    	});
    	
    	heap.add(new int[] {0,0});
    	visit[0][0] = true;
    	
    	while(!heap.isEmpty() && res.size() <k) {
    		int d[] = heap.poll();//返回头
    		res.add(new int[] {nums1[d[0]],nums2[d[1]]});//加入当前最小
    		
    		//放入当前位置i,j的下一个位置i,j+1
    		if(d[1]+1<nums2.length && visit[d[0]][d[1]+1] == false) {
    			heap.add(new int[] {d[0],d[1]+1});
    			visit[d[0]][d[1]+1] = true;
    		}
    		
    		if(d[0]+1<nums1.length && visit[d[0]+1][d[1]] == false) {
    			heap.add(new int[] {d[0]+1,d[1]});
    			visit[d[0]+1][d[1]+1] = true;
    		}
    	}
    	
		return res;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
