package �ݹ�����β���;

//import java.util.Arrays;

/**
 * �ϲ�����
 * ʹ�÷��β���
 * ������Ԫ�طֳɴ�С��ͬ�������Ӽ��ϣ��ֱ�������Ӽ��Ͻ������򣬽��ź�����Ӽ��Ϻϲ���Ҫ����ź���ļ���
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
		//�ϲ�a[left:m]��a[m+1:right]��b[left:right]
		int i=left,j=m+1,k=left;//k��left��ʼ
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
		
		//���ƻ�����a
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
