package medium;
/**
 * 390. 消除游戏 
 * 给定一个从1 到 n 排序的整数列表。
首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
返回长度为 n 的列表中，最后剩下的数字。

示例：

输入:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

输出:
6
 * @author liang
 *
 */
public class EliminationGame_390 {
	
	/**
	 * 1、一开始不是1,2,3,4,5,6..n 对吧？第一轮结束剩下2，4，6，8，10….2*(n/2) 等于2*(1,2,3,4…n/2),看着这个序列，是否觉得和一开始的问题很像，对吧，但是似乎有点不一样？ 
	 * 2、对于下一轮而言，虽然是1,2,3,4…,n/2,但是顺序是相反的消除？那既然这样，我们转变成n/2,…,4,3,2,1不就好了，所以我们还是按照1的方式求1，2，3，4…n/2但是对于结果要n/2 + 1 - lastremain掉不就好了
	 * @param n
	 * @return
	 */
    public int lastRemaining(int n) {
    	//将其镜像对折为一个子问题，当前状态可以推出的下一个状态的结果，但是相反
        return n==1?1:2*(n/2 + 1 - lastRemaining(n/2));
    }
}