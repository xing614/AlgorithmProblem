package easy;
/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 步 + 1 步
2.  2 步
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 步 + 1 步 + 1 步
2.  1 步 + 2 步
3.  2 步 + 1 步
 * @author liang
 *
 */
public class ClimbingStairs {

	/**
	 * 动态规划方法：
	 * 1.确认推导式 f(x)=f(x-1)+f(x-2)
	 * 2.设置初始条件 f(1)=1,f(2)=2
	 * @param n
	 * @return
	 */
    public static int climbStairs(int n) {
    	if(n==1)
    		return 1;
    	else if(n==2)
    		return 2;
    	else if(n>2)
    		return climbStairs(n-1)+climbStairs(n-2);
    	else 
    		return 0;
    }
    
    /**
     * 非递归方法
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
    	int f1=1;
    	int f2=2;
    	if(n==1)
    		return f1;
    	if(n==2)
    		return f2;
		for(int i=3;i<=n;i++) {
			int f3=f1+f2;//f(x)=f(x-1)+f(x-2);
			f1=f2;//预设f1变成f(x-1)的数据而不是自己本身f(x-2)的数据
			f2=f3;//预设f2变成f(x)的数据而不是自己本身f(x-1)的数据
		}
		return f2;
    		
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(3));
	}

}
