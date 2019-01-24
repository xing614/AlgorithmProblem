package EightAlgorithms;
/**
 * 堆排序
 * 
 * 对简单选择排序的优化。
 * 将序列构建成大顶堆。
 * 将根节点与最后一个节点交换，然后断开最后一个节点。
 * 重复第一、二步，直到所有节点断开。
 * 
 * 堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。
 * 一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
 * @author liang
 *
 */
public class HeapSort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={49,38,65,97,76,13,27,49,78,34,12,64};
		int len = a.length;
		//循环 建堆 和 交换堆顶和排完序的堆的最后一个元素
		for(int i=0;i<len-1;i++) {
			//建堆
			buildMaxHeap(a,len-1-i);//每次建堆完  堆的元素数量就-1
			swap(a,0,len-1-i);//交换
			
		}
	}

	private static void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	//从0~last建大顶堆。每次从last的父节点开始判断，找到该节点的子节点最大值的坐标，判断其与父节点大小，如果子节点大 就把子节点和父节点交换
	private static void buildMaxHeap(int[] a, int last) {
		// TODO Auto-generated method stub
		for(int i=(last-1)/2;i>=0;i--) {//从last节点的父节点开始
			int k=i; //k保存正在判断的节点 
			while(k*2+1<=last) {//如果当前k节点的子节点存在 
				int biggerIndex = 2*k+1;//k节点的左子节点的索引 
				if(biggerIndex<last) {//如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
					if(a[biggerIndex]<a[biggerIndex+1]) {//右子节点的值较大
						biggerIndex++;//biggerIndex总是记录较大子节点的索引
					}
				}
				if(a[k]<a[biggerIndex]) {//如果k节点的值小于其较大的子节点的值  
					swap(a,k,biggerIndex);//交换
					k=biggerIndex;//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值  
				}else {
					break;
				}
			}
		}
	}

}
