package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

例如，

给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。

注意：

你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * @author liang
 *
 */
public class TopKFrequentElements {

	/**
	 * 使用桶排序
	 * @param nums
	 * @param k
	 * @return
	 */
    public List<Integer> topKFrequent(int[] nums, int k) {
      	//第一步，还是先统计每个数字出现的次数，这个貌似不可避免，时间复杂度为O(n)
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		Integer count = map.get(nums[i]);
    		if(count==null){
    			count = 0;
    		}
    		map.put(nums[i], count+1);
    	}
    	
    	//第二步，构造一个桶，下标表示出现次数，如果nums大小为n，且这n个数相等，那么
    	//出现次数最大为n，所有桶的大小为n+1
    	//这个桶实际上是将上面那个map的key value翻转了一下，因为对于同一个value可能有多个
    	//key，所以buckey的元素应该是个列表,第一次这么用列表
    	List<Integer>[] bucket = new List[nums.length+1];
    	
    	for(int key:map.keySet()){
    		int count = map.get(key);
    		if(bucket[count]==null){
    			ArrayList<Integer> temp = new ArrayList<Integer>();
    			temp.add(key);
    			bucket[count] = temp;
    		}else{
    			bucket[count].add(key);
    		}
    	}
    	
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	for(int i=bucket.length-1;i>=0&&res.size()<k;i--){
    		if(bucket[i]!=null){
    			//这里addAll是因为题目说明了只有一个唯一解，是个特例
    			res.addAll(bucket[i]);
    		}
    	}
    	return res;

    }
    
    /**
     * 使用优先队列
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> top2(int[] nums, int k){
       	//先统计每个数字出现的次数，这个貌似不可避免，时间复杂度为O(n)
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		Integer count = map.get(nums[i]);
    		if(count==null){
    			count = 0;
    		}
    		map.put(nums[i], count+1);
    	}
    	
    	//然后应该可以使用优先队列了，
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,new Comp(map));
    	
    	for(int key:map.keySet()){
    		if(pq.size()<k){
    			pq.add(key);
    			continue;
    		}
    		
    		int small = pq.peek();
    		if(map.get(small)<map.get(key)){
    			pq.poll();
    			pq.add(key);
    		}
    	}
    	return new ArrayList<Integer>(pq);

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//注意构造函数，使用map来初始化
class Comp implements Comparator<Integer>{

	HashMap<Integer,Integer> map;
	public Comp(HashMap<Integer,Integer> map){
		this.map = map;
	}
	 
	@Override  //通过key的value来排序
	public int compare(Integer o1, Integer o2) {
		return map.get(o1)-map.get(o2);
	}
	
}