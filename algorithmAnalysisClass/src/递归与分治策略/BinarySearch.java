package 递归与分治策略;
/**
 * 二分搜索		---  分治策略
 * 在排好序的数组里找到一个数据
 * @author liang
 *
 */
public class BinarySearch {
	
	public static int data[]={0,1,2,3,4,5,6,7,8,9};
	
	public static int search(int x){
		int left = 0,right = data.length-1;
		while(left<=right){
			int middle = (left+right)/2;
			if(x==data[middle])
				return middle;
			if(x>data[middle])
				left = middle+1;
			else 
				right = middle-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(search(4));
	}

}
