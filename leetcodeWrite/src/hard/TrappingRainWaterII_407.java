package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 407. 接雨水 II
 * 给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。

 

说明:

m 和 n 都是小于110的整数。每一个单位的高度都大于0 且小于 20000。

 

示例：

给出如下 3x6 的高度图:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

返回 4。


如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。

 



下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。
 * @author liang
 *
 */
public class TrappingRainWaterII_407 {
	public class Node{
        int x;
        int y;
        int h;
        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.h -o2.h;//从小到大
            }
        });
		TrappingRainWaterII_407 tt = new TrappingRainWaterII_407();
		TrappingRainWaterII_407.Node node = tt.new Node(1,1,1);
		q.add(tt.new Node(0,0,2));
		q.add(tt.new Node(0,1,1));
		q.add(tt.new Node(0,2,3));
		System.out.println(q.poll().y);
		System.out.println(q.poll().y);
		System.out.println(q.poll().y);
	}

}
