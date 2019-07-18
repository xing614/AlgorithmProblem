package hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 871. 最低加油次数
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。

注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。

 

示例 1：

输入：target = 1, startFuel = 1, stations = []
输出：0
解释：我们可以在不加油的情况下到达目的地。
示例 2：

输入：target = 100, startFuel = 1, stations = [[10,100]]
输出：-1
解释：我们无法抵达目的地，甚至无法到达第一个加油站。
示例 3：

输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
输出：2
解释：
我们出发时有 10 升燃料。
我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
我们沿途在1两个加油站停靠，所以返回 2 。
 

提示：

1 <= target, startFuel, stations[i][1] <= 10^9
0 <= stations.length <= 500
0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 * @author liang
 *
 */
public class MinimumNumberofRefuelingStops_871 {

	/**
	 * 贪心算法+队列：每次走剩余油能走的最大的路程，找到最大的和起始范围内的加油站中能加最多油的那个
	 * @param target
	 * @param startFuel
	 * @param stations
	 * @return
	 */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
        int currentFuel = startFuel;
        int times = 0;
        int stationsLen = stations.length;
        int currentPosistion = 0;
        while(currentFuel<target) {
        	while(currentPosistion<stationsLen &&stations[currentPosistion][0]<=currentFuel) {
        		queue.add(stations[currentPosistion++][1]);
        	}
        	if(queue.isEmpty()) {
        		return -1;
        	}
        	currentFuel+=queue.poll();
        	times++;
        }
        return times;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
