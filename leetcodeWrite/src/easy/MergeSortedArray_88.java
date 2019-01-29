package easy;
/**
 * 88. 合并两个有序数组
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

 * @author liang
 *
 */
public class MergeSortedArray_88 {

	/**
	 * 采用倒序插入，从后往前移动
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lenM = m-1;
        int lenN = n-1;
        int lenAll = m+n-1;
        //插入元素
        while(lenM>=0 && lenN>=0) {
        	if(nums1[lenM]>=nums2[lenN]) {//如果1数组当前位置大于2当前位置
        		nums1[lenAll--] = nums1[lenM--];
        	}else {
        		nums1[lenAll--] = nums2[lenN--];
        	}
        }
        //如果还有剩余
        if(lenM == -1) {
        	while(lenN >= 0 ) {
        		nums1[lenAll--] = nums2[lenN--];
        	}
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
