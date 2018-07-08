package 递归与分治策略;

import java.util.Arrays;

/**
 * 快速排序
 * 分治策略 ；分解-递归求解-合并
 * @author liang
 *
 */
public class QuickSort {

	public static void Quick_Sort(int a[],int p,int r){
		if(p<r){
			int q=Partition(a,p,r);
			Quick_Sort(a,p,q-1);//对左半段排序
			Quick_Sort(a,q+1,r);//对右半段排序
		}
	}
	
	/**
	 * 左半和右半两个区域按基准元素数据的大小交换数据,返回交换后的中心点位置
	 * @param a
	 * @param p
	 * @param r
	 */
	public static int Partition(int a[],int p,int r){
		int i = p,j = r+1;
		int x = a[p];//基准元素数据
		while(true){
			while(a[++i]<x&&i<r);//从最左侧开始寻找大于x的数据节点，不大于x就右移
			while(a[--j]>x);//从最右找到小于 x 的
			if(i>=j) break;
			Swap(a[i],a[j]);//交换
		}
		a[p] = a[j];
		a[j] = x;//基准元素数据放在中心
		return j;//下一个基准点
	}
	
	public static void Swap(int a,int b){
		int tem = a;
		a = b;
		b = tem;
	}
	public static void main(String[] args) {
		int[] a = {1,4,2,6,7}; 
		Quick_Sort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
