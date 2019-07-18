package EightAlgorithms;
/**
 * 简单选择排序
 * 如果每次比较都交换，那么就是交换排序；如果每次比较完一个循环再交换，就是简单选择排序。
 * 
 * 遍历整个序列，将最小的数放在最前面。
 * 遍历剩下的序列，将最小的数放在最前面。
 * 重复第二步，直到只剩下一个数。
 * @author liang
 *
 */
public class SelectSort {

	public void selectSort(int[] a) {
		int len = a.length;
		for(int i=0;i<len;i++) {
			int value = a[i];
			int position = i;
			for(int j=i+1;j<len;j++) {//找到最小的值和位置
				if(a[j]<value) {
					value = a[j];
					position = j;
				}
			}
			a[position] = a[i];//交换出最小的数.这一轮找到的最小值的位置变为i位置元素
			a[i] = value;//i位置变为最小值
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SelectSort ss = new SelectSort();
		int[] aa= {1,3,5,7,4,2,9,6};
		ss.selectSort(aa);
		for(int a:aa) {
			System.out.println(a);
		}
	}

}
