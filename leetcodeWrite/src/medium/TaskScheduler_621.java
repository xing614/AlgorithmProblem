package medium;

import java.util.Arrays;

/**
 * 621. 任务调度器
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的最短时间。

示例 1：

输入: tasks = ["A","A","A","B","B","B"], n = 2
输出: 8
执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
注：

任务的总个数为 [1, 10000]。
n 的取值范围为 [0, 100]。
 * @author liang
 *
 */
public class TaskScheduler_621 {

	/**
	 * 先找到最多出现次数的字符 出现次数和有几个，然后比较有空格情况和没空格情况
	 * @param tasks
	 * @param n
	 * @return
	 */
    public int leastInterval(char[] tasks, int n) {
        int[] alpNum = new int[26];
        for (int i = 0; i < tasks.length; i ++) {
            alpNum[tasks[i] - 'A'] ++;
        }
        Arrays.sort(alpNum);
        int i, maxNum = 0;//最多出现次数的字符有几个
        for (i = 24; alpNum[i] == alpNum[25]; i --) {
            maxNum ++; 
        }
        //当有空格时
        //(alpNum[25] - 1) * n表示  "Aasi ijasi"A
        //alpNum[25]是每组产生一个空格
        //maxNum是最后一组的个数
        return Math.max((alpNum[25] - 1) * n + alpNum[25] + maxNum, tasks.length);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
