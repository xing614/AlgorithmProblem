package 递归与分治策略;

//import java.util.Arrays;

/**
 * 合并排序
 * 使用分治策略
 * 将待排元素分成大小相同的两个子集合，分别对两个子集合进行排序，将排好序的子集合合并成要求的排好序的集合
 * @author liang
 *
 */
public class MergeSort {

	public static int[] a = {0,3,1,5,7,2,14,444,9,4};
		
	
	public static void Merge_Sort(int a[],int left,int right){
		if(left<right){
			int i = (left+right)/2;
			Merge_Sort(a,left,i);
			Merge_Sort(a,i+1,right);
			Merge(a,left,i,right);
		}
	}
	
	public static void Merge(int a[],int left,int m,int right){
		//合并a[left:m]和a[m+1:right]到b[left:right]
		int i=left,j=m+1,k=left;//k从left开始
		int[] b = new int[10];
		while((i<=m)&&(j<=right)){
			if(a[i]<a[j])
				b[k++] = a[i++];
			else
				b[k++] = a[j++];
		}
		if(i>m)
			for(int q=j;q<=right;q++)
				b[k++] = a[q];
		else 
			for(int q=i;q<=m;q++){
				b[k++] = a[q];
			}
		
		//复制回数组a
		for(int ii=left;ii<=right;ii++){
			a[ii] = b[ii];
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Merge_Sort(a,0,a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
	}

}
