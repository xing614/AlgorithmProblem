package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

 

示例 1:

输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
示例 2:

输入: deadends = ["8888"], target = "0009"
输出：1
解释：
把最后一位反向旋转一次即可 "0000" -> "0009"。
示例 3:

输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
输出：-1
解释：
无法旋转到目标数字且不被锁定。
示例 4:

输入: deadends = ["0000"], target = "8888"
输出：-1
 

提示：

死亡列表 deadends 的长度范围为 [1, 500]。
目标数字 target 不会在 deadends 之中。
每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 * @author liang  
 *
 */
public class OpenTheLock_752 {
	/**
	 * 类似bfs广度遍历，每次保存这一层所有可能，0000为起始点，9000,1000,0900,0100,0090,0010,0001,0009这八个节点与是起始点的可达点，过滤这一层已经遍历过得节点和死亡节点。
	 * @param deadends
	 * @param target
	 * @return
	 */
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();//保存已经访问/遍历过的数
        String start = "0000";
        Queue<String> queue1 = new LinkedList<>();//保存这一层要遍历的数据
        Queue<String> queue2 = new LinkedList<>();//保存下一层要遍历的数据
        queue1.offer(start);
        int step = 0;
        if(dead.contains(start)||dead.contains(target))
        	return -1;
        while(!queue1.isEmpty()) {
        	String cur = queue1.poll();
        	if(target.equals(cur)) {
        		return step;
        	}
        	List<String> nexts = getNext(cur);//根据当前数获得根据他可以改变出的下一层的所有可能结果
        	for(String s:nexts) {
            	if(!dead.contains(s)&&!visited.contains(s)) {
            		queue2.offer(s);
            		visited.add(s);
            	}       		
        	}
        	if(queue1.isEmpty()) {//当前层空了，就下一层变为当前层
        		queue1 = queue2;
        		queue2 = new LinkedList<>();
        		step++;
        	}

        }
        return -1;
    }

	private List<String> getNext(String cur) {
		// TODO Auto-generated method stub
		List<String> res = new ArrayList<>();
		for(int i=0;i<4;i++) {
			StringBuilder sb = new StringBuilder(cur);
			sb.setCharAt(i, cur.charAt(i)=='9'?'0':(char)(cur.charAt(i)+1));//第i位+1
			res.add(sb.toString());
			sb.setCharAt(i, cur.charAt(i)=='0'?'9':(char)(cur.charAt(i)-1));//第i位-1
			res.add(sb.toString());
		}
		return res;
	}
}
