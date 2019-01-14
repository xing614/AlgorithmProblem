package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。

示例 1:

输入: [1,2,3,4,5], k=4, x=3
输出: [1,2,3,4]
 

示例 2:

输入: [1,2,3,4,5], k=4, x=-1
输出: [1,2,3,4]
 

说明:

k 的值为正数，且总是小于给定排序数组的长度。
数组不为空，且长度不超过 104
数组里的每个元素与 x 的绝对值不超过 104
 * @author liang
 *
 */
public class FindKClosestElements_658 {

	/**
	 *  由于数组是有序的，所以最后返回的k个元素也一定是有序的，那么其实就是返回了原数组的一个长度为k的子数组，转化一下，
	 *  实际上相当于在长度为n的数组中去掉n-k个数字，而且去掉的顺序肯定是从两头开始去，因为距离x最远的数字肯定在首尾出现。
	 *  每次比较首尾两个数字跟x的距离，将距离大的那个数字删除，直到剩余的数组长度为k为止
	 * @param arr
	 * @param k
	 * @param x
	 * @return
	 */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
        	list.add(arr[i]);
        }
        while(list.size()>k) {
        	int first = 0 ,last = list.size() -1;
        	if((x-list.get(first))<=(list.get(last)-x))
        		list.remove(last);
        	else
        		list.remove(first);
        }
        return list;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
