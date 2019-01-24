package EightAlgorithms;
/**
 * 基数排序(Radix Sort)是桶排序的扩展，它的基本思想是：将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 具体做法是：将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 * @author liang
 *
 */
public class BaseSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {53, 3, 542, 748, 14, 214, 154, 63, 616};
		radixSort(a);    // 基数排序
	}

	private static void radixSort(int[] a) {
		// TODO Auto-generated method stub
		int exp;    // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
		
		//找到最大值
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		
		// 从个位开始，对数组a按"指数"进行排序
		for (exp = 1; max/exp > 0; exp *= 10)
			countSort(a, exp);
		

		
	}

	private static void countSort(int[] a, int exp) {
		// TODO Auto-generated method stub
		int[] output = new int[a.length];    // 存储"被排序数据"的临时数组
		int[] buckets = new int[10];
		// 将数据出现的次数存储在buckets[]中
		for (int i = 0; i < a.length; i++)
		    buckets[ (a[i]/exp)%10 ]++;
		
		// 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
		for (int i = 1; i < 10; i++)
		    buckets[i] += buckets[i - 1];
		
		// 将数据存储到临时数组output[]中
		for (int i = a.length - 1; i >= 0; i--) {
		    output[buckets[ (a[i]/exp)%10 ] - 1] = a[i];
		    buckets[ (a[i]/exp)%10 ]--;
		}
		
		// 将排序好的数据赋值给a[]
		for (int i = 0; i < a.length; i++)
		    a[i] = output[i];
		
		output = null;
		buckets = null;
		
	}
}
