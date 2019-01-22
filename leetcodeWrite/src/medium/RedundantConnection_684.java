package medium;
/**
 * 684. 冗余连接
 * 在本问题中, 树指的是一个连通且无环的无向图。

输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。

结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。

返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。

示例 1：

输入: [[1,2], [1,3], [2,3]]
输出: [2,3]
解释: 给定的无向图为:
  1
 / \
2 - 3
示例 2：

输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
输出: [1,4]
解释: 给定的无向图为:
5 - 1 - 2
    |   |
    4 - 3
注意:

输入的二维数组大小在 3 到 1000。
二维数组中的整数在1到N之间，其中N是输入数组的大小。
更新(2017-09-26):
我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。
 * @author liang
 *
 */
public class RedundantConnection_684 {

	/**
	 * 给一个无向图，删掉组成环的最后一条边
	 * 并查集算法:
	 * 首先每个节点都是各自独立的，故每个节点的根节点都是其本身。
	 * 连通两个节点A、B时，检查A与B的根节点；如果根节点相同，则表示A、B已经是连通的；
	 * 如果根节点不同，则将A的根节点修改为B的根节点。
	 * 对于并查集算法而言，关键要掌握的点在于find()方法，即寻找一个节点的根节点的方法。这个方法要同时具备”查找”与”修改”的功能。
	 * @param edges
	 * @return
	 */
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for(int i=0;i<parent.length;i++)
        	parent[i] = i;
        for(int[] edge:edges) {
        	int f = edge[0],t = edge[1];
        	 if (find(parent, f) == find(parent, t)) return edge;//根节点相同则返回此边
             else parent[find(parent, f)] = find(parent, t);//根节点不同，则修改根节点，连通两个子图
        }
        return new int[2];
    }
    
    
    
	private int find(int[] parent, int f) {
		// TODO Auto-generated method stub
		if (f != parent[f]) {
	          parent[f] = find(parent, parent[f]); //如果不是，则向上追溯到根节点并修正成新的根节点
	        }
	    return parent[f];//如果某节点的根就是它本身，它则是根节点.返回修正后的根节点
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
