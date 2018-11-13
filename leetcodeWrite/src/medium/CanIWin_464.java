package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 464.我能赢吗
 * 
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。

如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？

例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。

给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？

你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。

示例：

输入：
maxChoosableInteger = 10
desiredTotal = 11

输出：
false

解释：
无论第一个玩家选择哪个整数，他都会失败。
第一个玩家可以选择从 1 到 10 的整数。
如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。

 * @author liang
 *
 */
public class CanIWin_464 {

	Map<Integer,Boolean> map;//用来判断一种情况是否存在
	boolean[] used;//判断这个元素是否被使用过
	
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum<desiredTotal)return false;//和小于总数
        if(desiredTotal <=0)return true;
        map = new HashMap();
        used = new boolean[maxChoosableInteger+1];
        return helper(desiredTotal);
    }
    
	private boolean helper(int desiredTotal) {
		// TODO Auto-generated method stub
		if(desiredTotal<=0)//<=0说明一方赢了
			return false;
		int key = format(used);
		if(!map.containsKey(key)) {//当前这种情况在map中没出现过
			//尝试每一个未被选择的数字作为下一个步骤
			for(int i = 1;i<used.length;i++) {
				//只找没选择过的
				if(!used[i]) {
					used[i] = true;
					//判断是否会赢,即当前要达到的值-当前位置i值的结果接着递归，直到返回结果如果是false说明    desiredTotal-i的值第二个人没能直接赢 ，就是说第一个人赢了
					if(!helper(desiredTotal-i)) {
						map.put(key, true);//这个Key第一个人赢
						used[i] = false;//退回为原来false
						return true;
					}
					used[i] = false;
				}
				
			}
			map.put(key, false);//所有结果遍历都是false
		}
		return map.get(key);//出现过直接返回这个值答案
	}

	//将当前每个元素是否使用情况转换为一个int，如第一个元素没使用第一位就是0
	private int format(boolean[] used) {
		// TODO Auto-generated method stub
		int num = 0;
		for(boolean b:used) {
			num<<=1;//左移一位
			if(b) {//当前位被用了，则此时最低位
				num|=1;//最低位变1 
			}
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
