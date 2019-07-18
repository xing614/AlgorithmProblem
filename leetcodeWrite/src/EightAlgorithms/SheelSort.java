package EightAlgorithms;
/**
 * 希尔排序
 * 对于直接插入排序问题，数据量巨大时。
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 * 
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * @author liang
 *
 */
public class SheelSort {

	public void sheelSort(int[] a) {
		int len = a.length;
		int temp = 0;
		int j = 0;
		for (int increment = a.length / 2; increment > 0; increment /= 2) {//每次将步长缩短为原来的一半
			for (int i = increment; i < a.length; i++) {
				temp = a[i];
				for (j = i; j >= increment; j -= increment) {//每一组的一个相对相同位置
					print(a);
					if(temp > a[j - increment]){ //如想从小到大排只需修改这里
		                a[j] = a[j - increment];
		            }
		            else{
		                break;
		            }
				}
				a[j] = temp;//把a[i]的值设置到j-increment对应位置中小于前一个对应位置数据的位置
			}
		}
			

	}
	public void print(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}		
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {11,4,67,8,5,76,14,36,45,1,6,43};
		SheelSort ss = new SheelSort();
		ss.sheelSort(a);

		
	}

}
