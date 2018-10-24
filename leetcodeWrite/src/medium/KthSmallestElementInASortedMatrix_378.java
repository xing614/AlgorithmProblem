package medium;

import java.util.PriorityQueue;

/**
 * 378.有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。

示例:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。
说明: 
你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n^2 。
 * @author liang
 *
 */
public class KthSmallestElementInASortedMatrix_378 {

	/**
	 * 使用优先队列
	 * 自定义比较规则Comparable
	 * @param matrix
	 * @param k
	 * @return
	 */
    public int kthSmallest(int[][] matrix, int k) {
        
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	
    	PriorityQueue<Tuple> pq = new PriorityQueue<>();
    	
    	/**
    	 * 先将第一行升序序列放入队列，
    	 * 自定义比较大小，最小元素放队首
    	 * 每次队首元素出队后，将其所在列的下一个元素放入队中，直到最后一行
    	 * 这样可以比较一个元素的同一行与同一列中相邻的元素中哪个较小，从而保证队首元素始终是矩阵中所有元素的最小值
    	 */
    	for(int j = 0;j<cols;j++) {
    		pq.add(new Tuple(0,j,matrix[0][j]));
    	}
    	//进行k-1次出队、入队，最后队首元素一定是所有元素中的第k小
    	for(int i=0;i<k-1;i++) {
    		Tuple tp = pq.poll();//出队列
    		if(tp.x == cols-1)
    			continue;
    		pq.add(new Tuple(tp.x +1,tp.y,matrix[tp.x +1][tp.y ]));
    	}
    	return pq.poll().val;
    	
    }
    
    class Tuple implements Comparable<Tuple>{

    	int x;
    	int y;
    	int val;
    	
    	public Tuple(int x,int y,int val) {
    		this.x = x;
    		this.y = y;
    		this.val = val;
    	}
		@Override
		public int compareTo(Tuple o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
		}
    	
    }
}
