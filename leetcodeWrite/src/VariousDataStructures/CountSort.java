package VariousDataStructures;

/**
 * 计数排序
 * @author liang
 *
 */
public class CountSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      //排序的数组
        int a[]={100,93,97,92,96,99,92,89,93,97,90,94,92,95};
        int b[]=countSort(a);
        for(int i:b){
           System.out.print(i+"");
        }
        System.out.println();
	}

	/**
	 * 计数排序的基本思想是对于给定的输入序列中的每一个元素x，确定该序列中值小于x的元素的个数（此处并非比较各元素的大小，而是通过对元素值的计数和计数值的累加来确定）。
	 * 一旦有了这个信息，就可以将x直接存放到最终的输出序列的正确位置上。
	 * 例如，如果输入序列中只有17个元素的值小于x的值，则x可以直接存放在输出序列的第18个位置上。
	 * @param a
	 * @return
	 */
	private static int[] countSort(int[] a) {
        int b[] = new int[a.length];
        int max = a[0],min = a[0];//之后找出a的最大值和最小值
        for(int i:a){
            if(i>max){
                max=i;
            }
            if(i<min){
                min=i;
            }
        }
        //这里k的大小是要排序的数组中，元素大小的极值差+1
        int k=max-min+1;
        int c[]=new int[k];
        for(int i=0;i<a.length;++i){
            c[a[i]-min]+=1;//优化过的地方，减小了数组c的大小
        }
        for(int i=1;i<c.length;++i){
            c[i]=c[i]+c[i-1];
        }
        for(int i=a.length-1;i>=0;--i){
            b[--c[a[i]-min]]=a[i];//按存取的方式取出c的元素
        }
    return b;
	}

}
