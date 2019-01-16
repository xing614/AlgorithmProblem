package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 659. 分割数组为连续子序列
 * 
 * 输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？

 

示例 1：

输入: [1,2,3,3,4,5]
输出: True
解释:
你可以分割出这样两个连续子序列 : 
1, 2, 3
3, 4, 5
 

示例 2：

输入: [1,2,3,3,4,4,5,5]
输出: True
解释:
你可以分割出这样两个连续子序列 : 
1, 2, 3, 4, 5
3, 4, 5
 

示例 3：

输入: [1,2,3,4,4,5]
输出: False
 

提示：

输入的数组长度范围为 [1, 10000]

 * @author liang
 *
 */
public class SplitArrayintoConsecutiveSubsequences_659 {

	Map<Integer,PriorityQueue<Integer>> map;//优先队列里放的是末尾为key的队列的长度，优先队列自动排序int从小到大，每次队头放的队列长度最小的队列长度
 	/**
	 * map+PriorityQueue<Integer>
	 * 排列扑克牌，优先将数字排在长度较小的扑克牌队列后面
	 * Map<Integer, PriorityQueue<Integer>> dmap的key为扑克牌队列的末尾，value为优先队列，存储扑克牌队列的长度
	 * @param nums
	 * @return
	 */
    public boolean isPossible(int[] nums) {
        map = new HashMap<>();
        for(int num:nums) {
        	PriorityQueue<Integer> pq = getOrPut(num-1);//找到队尾末尾时num-1的数
        	int len = pq.isEmpty()? 0 :pq.poll();//移出队头数字,优先队列存储的是长度，队头为长度最短的，然后移除它，使得key为num的多一个队列长度为长度+1
        	PriorityQueue<Integer> pq1 = getOrPut(num);//末尾为num的长度+1
        	pq1.offer(len+1);//插入元素
        }
        for(int k :map.keySet()) {
        	for(int len:map.get(k)) {
        		if(len<3)
        			return false;
        	}
        }
        return true;
    }
    
	private PriorityQueue<Integer> getOrPut(int num) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> priorityQueue = map.get(num);
		if(priorityQueue == null) {
			priorityQueue = new PriorityQueue<Integer>();
			map.put(num, priorityQueue);
		}
		return priorityQueue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
