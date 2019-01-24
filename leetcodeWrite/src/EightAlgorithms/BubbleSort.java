package EightAlgorithms;
/**
 * 冒泡排序
 * 将序列中所有元素两两比较，将最大的放在最后面。
 * 将剩余序列中所有元素两两比较，将最大的放在最后面。
 * @author liang
 *
 */
public class BubbleSort {

	public void bubbleSort(int[] a) {
		int len = a.length;
		for(int i=0;i<len;i++) {
			for(int j=0;i<len-1-i;j++) {//每轮遍历会找到最大值放在最后一个位置，所以每遍历一次，j的范围小1
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
