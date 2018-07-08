package 贪心算法;
/**
 * 最优装载，轮船载重c，集装箱i的重量为wi,尽可能多的集装箱装上
 * 贪心选择：从重量最轻的装，局部最优
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
		int w[] = {2,3,4,1,2,5};//每个集装箱的重量
		int[] a = new int[6];
		int c = 10;//载重
		/**
		 * 不改变w[]的顺序
		 */
//		Sort(w,a,6);//排序，将w的顺序从小到大排到a
//		int x[] = new int[6];//设置每个对应的集装箱是否装上，1为装上，0为不装
//		for(int i=0;i<6;i++)
//			x[i]=0;
//		for(int i=0;i<6&&w[a[i]]<=c;i++){
//			x[a[i]] = 1;
//			c-=w[a[i]];
//		}
		
		/**
		 * 改变w[]的顺序
		 */
		boxSort(w,6);
		int x[] = new int[6];//设置每个对应的集装箱是否装上，1为装上，0为不装
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
