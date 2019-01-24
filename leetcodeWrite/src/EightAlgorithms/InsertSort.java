package EightAlgorithms;
/**
 * 直接插入排序
 * 在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。
 * 如此反复循环，直到全部排好顺序。
 * @author liang
 *
 */
public class InsertSort {

	/**
	 * 从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
	 * 将当前数放置到空着的位置，即j+1。
	 * @param a
	 */
	public void insertSort(int[] a) {
		int len = a.length;
		int insert;//要插入的数
		for(int i=1;i<len;i++) {//第一个数不用插入，从第二个数开始
			insert = a[i];//要插入的数
			int j=i-1;
			while(j>=0 && a[j]>insert) {//从后往前循环，将大于insertNum的数向后移动
				a[j+1]=a[j];//向后移动
				j--;
			}
			a[j+1] = insert;//找到位置，插入当前元素
		}
	
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
