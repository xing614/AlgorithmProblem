package medium;
/**
 * 413. 等差数列划分
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。

例如，以下数列为等差数列:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
以下数列不是等差数列。

1, 1, 2, 5, 7
 

数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。

如果满足以下条件，则称子数组(P, Q)为等差数组：

元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。

函数要返回数组 A 中所有为等差数组的子数组个数。

 

示例:

A = [1, 2, 3, 4]

返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 * @author liang
 *
 */
public class ArithmeticSlices_413 {

	/**
	 * 一个等差数列可以分解为1+2+...n-2个子数列
	 * {1,2,3,4,5} -> {1,2,3,4,5} + {1,2,3,4} + {2,3,4,5} + {1,2,3} + {2,3,4} + {3,4,5} -> 1+2+3 ->6
	 * 
	 * @param A
	 * @return
	 */
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0,count = 1;
        if(A.length<3)
        	return 0;
        for(int i=1;i<A.length-1;i++) {
        	//符合条件的就sum加它可分解子数列个数
        	if(A[i]-A[i-1] == A[i+1]-A[i]) {
        		sum+=(count++);
        	}else {
        		count = 1;//可以分解的子数列个数
        	}
        }
        return sum;
    }
    /**
     * 如果一个等差数列是长度是n，那么一共有一个 （n-1）(n-2)/2 个子等差数列，
     * 所以先求出所有最长的子等差数列的长度即可，利用滑动窗口，两个游标，当当前遇等差数列的条件不满足了以后更新计数值和游标
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices2(int[] A) {
    	if(A == null || A.length<3)
    		return 0;
    	int count = 0;
    	int left = 0,right = 1;
    	int diff = A[right]-A[left];
    	while(right<A.length) {
    		//符合等差条件
    		if(right<A.length-1 && A[right+1]-A[right] == diff) {
    			right++;
    		}else {
    			int len = right - left + 1;
    			if(len>=3) {
    				count +=((1+(len-2)) * (len-2))/2;
    			}
    			if(right == A.length-1) {
    				break;
    			}else {
    				left = right;
    				right++;
    				diff=A[right]-A[left];
    			}
    		}
    	}
    	return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
