package ̰���㷨;
/**
 * ����װ�أ��ִ�����c����װ��i������Ϊwi,�����ܶ�ļ�װ��װ��
 * ̰��ѡ�񣺴����������װ���ֲ�����
 * nlogn
 * @author liang
 *
 */
public class OptimalLoading { 


	public static void boxSort(int w[],int num) {
	    for (int i=num-1;i>0;i--)  
	    {  
	        for(int j=0;j<i;j++){      
	              
	            if(w[j]>w[j+1]){  
	                int temp=w[j];  
	                w[j]=w[j+1];  
	                w[j+1]=temp;  
	            }  
	        }  
	    } 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w[] = {2,3,4,1,2,5};//ÿ����װ�������
		int[] a = new int[6];
		int c = 10;//����
		/**
		 * ���ı�w[]��˳��
		 */
//		Sort(w,a,6);//���򣬽�w��˳���С�����ŵ�a
//		int x[] = new int[6];//����ÿ����Ӧ�ļ�װ���Ƿ�װ�ϣ�1Ϊװ�ϣ�0Ϊ��װ
//		for(int i=0;i<6;i++)
//			x[i]=0;
//		for(int i=0;i<6&&w[a[i]]<=c;i++){
//			x[a[i]] = 1;
//			c-=w[a[i]];
//		}
		
		/**
		 * �ı�w[]��˳��
		 */
		boxSort(w,6);
		int x[] = new int[6];//����ÿ����Ӧ�ļ�װ���Ƿ�װ�ϣ�1Ϊװ�ϣ�0Ϊ��װ
		for(int i=0;i<6;i++)
			x[i]=0;		
		for(int i=0;i<6&&w[i]<=c;i++){
			x[i] = 1;
			c-=w[i];
		}		
		
		for (int i = 0; i < 6; i++) {
			System.out.println(x[i]);
		}
		
	}
}
