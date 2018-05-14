package hard;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。

	请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
	
	示例 1:
	
	nums1 = [1, 3]
	nums2 = [2]
	
	中位数是 2.0
	示例 2:
	
	nums1 = [1, 2]
	nums2 = [3, 4]
	
	中位数是 (2 + 3)/2 = 2.5
 * @author liang
 *
 */
public class MedianOfTwoSortedArrays {

	//这是普通方法，时间复杂度不是 O(log (m+n)) 而是n*logn ,就是将AB两个数组合并，然后找中位数
    public static double findMedianLow(int A[], int B[]) {
    	int[] sumArray = new int[A.length+B.length];
    	System.arraycopy(A, 0, sumArray, 0, A.length);
    	System.arraycopy(B, 0, sumArray, A.length, B.length);
        Arrays.sort(sumArray);
        int length = sumArray.length;
        if (length % 2 == 0) {
            double num1 = sumArray[length / 2];
            double num2 = sumArray[length / 2 - 1];
            return (num1 + num2) / 2;
        } else {
            return sumArray[length / 2];
        }
    }
    /**
     *  O(log (m+n))
     *  一种求两个数组中第k小的元素的方法，这里的k在本题中是指(m+n)/2中位数
     *  思路：
     *    取A[k / 2] B[k / 2] 比较，
		    如果 A[k / 2] > B[k / 2] 那么，所求的元素必然不在B的前k / 2个元素中(证明反证法)
		    反之，必然不在A的前k / 2个元素中，于是我们可以将A或B数列的前k / 2元素删去，求剩下两个数列的
		    k - k / 2小元素，于是得到了数据规模变小的同类问题，递归解决
		    如果 k / 2 大于某数列个数，所求元素必然不在另一数列的前k / 2个元素中，同上操作就好。
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        //长度为积数则取中间，为偶数取中间两个的平均值
        if ((total & 0x01) != 0) {
            return findMedian(nums1, m, nums2, n, total / 2 + 1);
        } else {
            return (findMedian(nums1, m, nums2, n, total / 2) + findMedian(nums1, m, nums2, n,
                    total / 2 + 1)) / 2.0;
        }
    }
    
    //二分法，每次都能去除掉一部分范围外数据。需要注意每次去除数据都会改变数组的结构，所以需要特殊处理临界值
    private static double findMedian(int A[], int m, int B[], int n, int target) {
        if (m == 0) {
            return B[target - 1];
        } else if (n == 0) {
            return A[target - 1];
        } else if (target == 1) {
            return A[0] < B[0] ? A[0] : B[0];
        }
        int temp = target / 2;
        if (Math.min(m, n) < temp) {
            temp = Math.min(m, n);
        }
        if (A[temp - 1] > B[temp - 1]) {
            return findMedian(A, m, Arrays.copyOfRange(B, temp, n), n - temp, target - temp);
        } else if (A[temp - 1] < B[temp - 1]) {
            return findMedian(Arrays.copyOfRange(A, temp, m), m - temp, B, n, target - temp);
        } else {
            return A[temp - 1];
        }
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2};
		int[] B = {3,4};
		System.out.println(findMedianSortedArrays(A,B));
	}

}
