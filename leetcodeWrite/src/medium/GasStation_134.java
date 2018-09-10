package medium;
/**
 * 134. 加油站
题目描述提示帮助提交记录社区讨论阅读解答
在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明: 

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
示例 1:

输入: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

输出: 3

解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。
示例 2:

输入: 
gas  = [2,3,4]
cost = [3,4,3]

输出: -1

解释:
你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
因此，无论怎样，你都不可能绕环路行驶一周。
 * @author liang
 *
 */
public class GasStation_134 {

	/**
	 * 方法一
	 * 这是一个贪心题
	 * 设置一个count表示现在剩余的油量，设置一个temp[]
	 * temp[i]=max(temp[i-1]+gas[i]-cost[i],gas[i]-cost[i]),
	 * 如果temp[i]<0那么出发的位置肯定是在i之后的。如果temp[i]>=0那么出去的位置不变
	 * @param gas
	 * @param cost
	 * @return
	 */
    public int canCompleteCircuit1(int[] gas, int[] cost) {
    	int n=gas.length;
    	int[] temp=new int[n];
    	temp[0]=gas[0]-cost[0];

    	int count=gas[0]-cost[0];//现在剩余的油量
    	int pos;//表示从哪个开始
    	boolean flag;//为true则表示要从新位置重新计算
    	if(count>=0) {
    		pos=0;
    		flag=false;
    	} else {
    		pos=-1;
    		flag=true;
    	}
    	for(int i=1;i<n;i++) {
    		temp[i]=Math.max(temp[i-1]+gas[i]-cost[i], gas[i]-cost[i]);//当前temp[i]可能的最大值，要么是之前继承剩余汽油，要么从头开始
    		if(temp[i]<0) {
    			pos=-1;
    			flag=true;
    		}
    		else {
    			if(flag) {
    				pos=i;
    				flag=false;
    			}
    		}
    		count=count+gas[i]-cost[i];
    	}

    	if(count>=0) return pos;
    	else return -1;
    }
    
    /**
     * 方法二
     * 维护i和j,i为起点，j为终点
     * 也是搜索当前i位置开始是否可以往下走，可以就j++增大范围
     * 不可以就i从j的下一个点开始重新遍历
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
    	
        int i=0;
        int len = gas.length;
        int sum = 0;
        int j=0;
        while(i<len){
            sum = 0;
            j=i;
            while(j<len){
                sum = sum + gas[j];
                if(sum<cost[j]){
                    int temp  = j+1;
                    if(temp==i){//如何遍历的下一个起点之前已经遍历过，说明无解
                        return -1;
                    }
                    i=temp;//从当前节点的下一个开始重新遍历
                    break;
                }
                else{
                    sum = sum-cost[j];
                    j++;
                    j = j%len;//考虑到是一个圆环
                }
                if(j==i){
                    return i;
                }
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
