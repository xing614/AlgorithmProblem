package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 299. 猜数字游戏
你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。

请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。

请注意秘密数字和朋友的猜测数都可能含有重复数字。

示例 1:

输入: secret = "1807", guess = "7810"

输出: "1A3B"

解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
示例 2:

输入: secret = "1123", guess = "0111"

输出: "1A1B"

解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 * @author liang
 *
 */
public class BullsAndCows_299 {

	/**
	 * 遍历两个字符串，看在某个位置是否相等，如果相等，就A++；如果不相等，就把secret中的字符和guess中的字符再分别存起来；
	 * 然后再遍历第二遍，第二遍的遍历就是，经过处理的guess字符，会不会在经过处理的secrets的字符里面。
	 * 如果在，就B++，表明只是放错了位置而已
	 * @param secret
	 * @param guess
	 * @return
	 */
    public String getHint(String secret, String guess) {
        char[] secrets = secret.toCharArray();
        char[] guesses = guess.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        List<Character> postDealList = new LinkedList<>();
        
        int As = 0;//位置相等的A++
        int Bs = 0;//
        //第一次遍历
        for(int i = 0;i<secrets.length;i++) {
        	if(secrets[i] == guesses[i]) {//位置相等的A++
        		As++;
        	}else {
        		if(!map.containsKey(secrets[i])) {//map不存在就放入
        			map.put(secrets[i], 0);
        		}
        		map.replace(secrets[i], map.get(secrets[i])+1);//该Key+1
        		postDealList.add(guesses[i]);//这个不等位置的guess放入list
        	}
        }
        //第二次遍历，就遍历postDealList和map比较是否有元素
        int size = postDealList.size();
        for(int i=0;i<size;i++) {
        	char guessChar = postDealList.get(i);
        	if(map.containsKey(guessChar)) {
        		Integer val = map.get(guessChar);
        		Bs++;
        		if(val-1 == 0) {//只有一个就移除
        			map.remove(guessChar);
        		}else {
        			map.put(guessChar, val-1);
        		}
        	}
        }
        return String.valueOf(As)+"A"+String.valueOf(Bs)+"B";
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
