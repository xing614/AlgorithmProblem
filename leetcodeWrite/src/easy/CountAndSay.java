package easy;
/**
 * 38. 报数
报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n ，输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。

示例 1:

输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"
 * @author liang
 *
 */
public class CountAndSay {
	/**
	 * 这道题算就是字符串处理的问题，序列中第一个字符串是“1”，
	 * 接下来依次统计前一个字符串中连续相同字符的数量，并添加到下一字符串中
	 * @param n
	 * @return
	 */
    public static String countAndSay(int n) {
        String s = "1";//初始的第一个字符串
        for(int i=1;i<n;i++) {//依次处理前一个字符串直到 计算出第n个字符串
        	int count = 1;//计数 前一个字符串某一个位置开始 连续出现相同数字的数量  比如1211 当当前位置是第三位 count最后结果是2
        	String temp = "";
        	for(int j =1;j<s.length();j++) {//遍历上一个s得到这一个s
        		if(s.charAt(j) == s.charAt(j-1)) {//相邻两个数据一样 则count++
        			count++;
        		}else {//不一样则记录+temp，count返回1重新计数下一个数
        			temp = temp+(char)(count+'0')+s.charAt(j-1);
        			count = 1;
        		}
        	}
        	s = temp +(char)(count + '0')+s.charAt(s.length()-1);
        	
        }
        return s;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(25));
	}

}
