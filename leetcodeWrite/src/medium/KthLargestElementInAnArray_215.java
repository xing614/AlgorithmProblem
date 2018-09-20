package medium;
/**
 * 215. 数组中的第K个最大元素
题目描述提示帮助提交记录社区讨论阅读解答
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @author liang
 *
 */
public class KthLargestElementInAnArray_215 {

	/**
	 * 使用最小堆，堆总共可以放入k个元素，先放入数组的前k个，然后遍历数组后面所有元素
	 * 如果元素小于堆顶，就抛弃，
	 * 大于就抛出堆顶元素，将其放入
	 * 最后堆顶元素就是第k大
	 * @param nums
	 * @param k
	 * @return
	 */
    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];//堆数组
        heap[0] = nums[0];
        //将数组前k个元素放入
        for(int i=1;i<k;i++) {
        	up(nums[i],heap,i);
        }
        //整理放入之后的元素
        for(int i = k;i<nums.length;i++) {
        	insert(nums,k,heap,i);
        }
        return heap[0];
    }
    
	private void up(int num, int[] heap, int i) {
		// TODO Auto-generated method stub
		int p = i;
		heap[i] = num;
		while(p!=0) {//调整位置
			int parent = (p-1)/2;//父节点
			if(heap[parent]>heap[p]) {
				swap(heap,parent,p);
			}
			p = parent;
		}
	}
	
	private void insert(int[] nums, int k, int[] heap, int i) {
		// TODO Auto-generated method stub
		if(nums[i]>heap[0]) {//只考虑大于堆顶元素的
			heap[0] = nums[i];//替换栈顶
			int p = 0;
			while(p<k) {//从p位置开始调整插入的元素
				int minChild = 2*p+1;//左子树
				if(minChild+1<k && heap[minChild] > heap[minChild+1])//子树大的值
					minChild++;
				if(minChild < k && heap[p] > heap[minChild]) {//大于子树值，换位置
					swap(heap,p,minChild);
					p = minChild;//当前位置
				}else
					break;//找到合适的位置了
			}
		}
	}
	
	private void swap(int[] heap, int parent, int p) {
		// TODO Auto-generated method stub
		int tmp = heap[parent];
		heap[parent] = heap[p];
		heap[p] = tmp;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
