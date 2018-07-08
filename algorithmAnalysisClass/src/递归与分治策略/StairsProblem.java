package 递归与分治策略;
/**
 * 一个楼梯有20级，每次走1级或两级，请问从底走到顶一共有多少种走法？
 * 分析：假设从底走到第n级的走法有f（n）种，走到第ｎ级有两个方法，一个是从（n-1)级走一步，另一个是从第（ｎ－２）级走两步，
 * 前者有f(n-1)种方法，后者有f(n-2)种方法，所以有f(n)=f(n-1)+f(n-2),还有f(0)=1,f(1)=1.
 * @author liang
 *
 */
public class StairsProblem {
	
	/**
	 * n为楼层数,递归方法
	 * @param n
	 * @return
	 */
	public static int search(int n){
		if(n==1 ||n==0)
			return 1;
		else return search(n-1)+search(n-2);
		
	}
	
	public static int[] result = new int[12];
	/**
	 * 动态规划，使用一个数组记录所有的值。思想是，可递归，子问题有些是重叠的，可能需要多次重复计算，保留下来
	 * @param n
	 * @return
	 */
	public static int searchByDynamic(int n){
		int res;
		if(n==1||n==0)
			return 1;
		if(result[n]>0)
			return result[n];
		else 
			res = searchByDynamic(n-1) + searchByDynamic(n-2);
		result[n] = res;
		return res;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(search(2));
		
		{
			for(int i=0;i<12;i++){
				result[i] = -1;
			}		
			searchByDynamic(12);
		}
	}

}
