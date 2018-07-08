package �ݹ�����β���;

import java.util.Arrays;

/**
 * ��������
 * ���β��� ���ֽ�-�ݹ����-�ϲ�
 * @author liang
 *
 */
public class QuickSort {

	public static void Quick_Sort(int a[],int p,int r){
		if(p<r){
			int q=Partition(a,p,r);
			Quick_Sort(a,p,q-1);//����������
			Quick_Sort(a,q+1,r);//���Ұ������
		}
	}
	
	/**
	 * �����Ұ��������򰴻�׼Ԫ�����ݵĴ�С��������,���ؽ���������ĵ�λ��
	 * @param a
	 * @param p
	 * @param r
	 */
	public static int Partition(int a[],int p,int r){
		int i = p,j = r+1;
		int x = a[p];//��׼Ԫ������
		while(true){
			while(a[++i]<x&&i<r);//������࿪ʼѰ�Ҵ���x�����ݽڵ㣬������x������
			while(a[--j]>x);//�������ҵ�С�� x ��
			if(i>=j) break;
			Swap(a[i],a[j]);//����
		}
		a[p] = a[j];
		a[j] = x;//��׼Ԫ�����ݷ�������
		return j;//��һ����׼��
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
