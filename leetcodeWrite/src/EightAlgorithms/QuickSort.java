package EightAlgorithms;
/**
 * 快速排序
 * 要求时间最快时。
 * 选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
 * 递归的将p左边和右边的数都按照第一步进行，直到不能递归。
 * @author liang
 *
 */
public class QuickSort {

	public void quickSort(int[] a,int start,int end) {
		if(start<end) {
			int base = a[start];//标识
			int midNum;//用于记录中间值
			int i = start;
			int j = end;
			do {
				while((a[i]<base) && i<end) {
					i++;
				}
				while((a[j]>base) && j>start) {
					j--;
				}
				if(i<=j) {
					midNum = a[i];
					a[i] = a[j];
					a[j] = midNum;
					i++;
					j--;
				}
			}while(i<=j);
			if(start<j) {
				quickSort(a, start, j);
			}
			if(end>i) {
				quickSort(a, i, end);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
