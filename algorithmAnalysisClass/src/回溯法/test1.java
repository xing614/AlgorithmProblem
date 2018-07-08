package 回溯法;
/**
 * 轮船装载问题                          该问题与01背包问题相似
 * 一共n个集装箱，集装箱重量分别为Wi,装载到载重量为c的轮船中。
 * 找出最大装载量以及装载哪些集装箱
 * @author liang
 * 解空间树为子集树：即二叉树
 * 将数组转化为二叉树，比如从A节点开始，如果第一个数被选为放入，则搜索左子树B，不放入则搜索右子树C。。依次下去。为2^n个解法，
 * 然后利用约束函数（不满足约束的子树，如下判断是否小于最大载重量）和限界函数（得不到最优解的）剪枝。
 */
public class test1 {
	
	public static int c = 20;//轮船最大载重量
	public static int n = 10;
	public static int w[] = {1,2,3,4,5,6,7,8,9,6};
	public static int cw = 0;//当前载重量
	public static int r;//剩余集装箱重量
	public static int bestw = 0;//当前最优载重量
	
	public static int x[] = new int[10];//当前解，用于设置各个物品是否存放
	public static int bestx[] = new int[10];//当前最优解，
	
	public static void Backtrack(int i){
		
		//搜索第i层结点
		if(i>=n){//到达叶节点
			if(cw > bestw){//当前载重量优于之前的最优载重量
				for(int j = 0; j<n; j++){//设置最优解
					bestx[j] = x[j];
					bestw = cw;
				}
			}
			return;
		}
		//搜索子树
		r -= w[i];//轮到判断w[i]是否放入，先把该重量从剩余重量中去掉
		if(cw +w[i]<= c){//放入w[i]的前提是放入后的载重量小于最大载重量。成立就遍历左子树，即放入该集装箱
			x[i] = 1;//放入
			cw += w[i];//当前载重量 = 当前 + 新放入的w[i]
			Backtrack(i+1);//搜索下一层
			cw -= w[i];//递归回来后，返回上一个活结点，要将这个加进来的重量返回去
		}
		if(cw + r > bestw){//如果 当前重量+剩余重量 的值<最佳载重量了，就没有搜索右子树的意义了，因为肯定比最佳载重量差
			x[i] = 0;//不放，即进入右子树
			Backtrack(i+1);
		}
		r+=w[i];//回溯回来了，剩余重量加回来
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++){
			r += w[i];
		}
		Backtrack(0);
		System.out.println(bestw);
		for(int i=0;i<n;i++){
			if(bestx[i]!=0){
				System.out.println(i);
			}
		}
	}

}
