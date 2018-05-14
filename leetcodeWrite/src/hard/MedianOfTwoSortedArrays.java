package hard;

import java.util.Arrays;

/**
 * ����������СΪ m �� n ���������� nums1 �� nums2 ��

	���ҳ������������������λ����Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log (m+n)) ��
	
	ʾ�� 1:
	
	nums1 = [1, 3]
	nums2 = [2]
	
	��λ���� 2.0
	ʾ�� 2:
	
	nums1 = [1, 2]
	nums2 = [3, 4]
	
	��λ���� (2 + 3)/2 = 2.5
 * @author liang
 *
 */
public class MedianOfTwoSortedArrays {

	//������ͨ������ʱ�临�ӶȲ��� O(log (m+n)) ����n*logn ,���ǽ�AB��������ϲ���Ȼ������λ��
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
     *  һ�������������е�kС��Ԫ�صķ����������k�ڱ�������ָ(m+n)/2��λ��
     *  ˼·��
     *    ȡA[k / 2] B[k / 2] �Ƚϣ�
		    ��� A[k / 2] > B[k / 2] ��ô�������Ԫ�ر�Ȼ����B��ǰk / 2��Ԫ����(֤����֤��)
		    ��֮����Ȼ����A��ǰk / 2��Ԫ���У��������ǿ��Խ�A��B���е�ǰk / 2Ԫ��ɾȥ����ʣ���������е�
		    k - k / 2СԪ�أ����ǵõ������ݹ�ģ��С��ͬ�����⣬�ݹ���
		    ��� k / 2 ����ĳ���и���������Ԫ�ر�Ȼ������һ���е�ǰk / 2��Ԫ���У�ͬ�ϲ����ͺá�
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        //����Ϊ������ȡ�м䣬Ϊż��ȡ�м�������ƽ��ֵ
        if ((total & 0x01) != 0) {
            return findMedian(nums1, m, nums2, n, total / 2 + 1);
        } else {
            return (findMedian(nums1, m, nums2, n, total / 2) + findMedian(nums1, m, nums2, n,
                    total / 2 + 1)) / 2.0;
        }
    }
    
    //���ַ���ÿ�ζ���ȥ����һ���ַ�Χ�����ݡ���Ҫע��ÿ��ȥ�����ݶ���ı�����Ľṹ��������Ҫ���⴦���ٽ�ֵ
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
