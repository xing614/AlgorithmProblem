package hard;
/**
 * 44. 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "*"
输出: true
解释: '*' 可以匹配任意字符串。
示例 3:

输入:
s = "cb"
p = "?a"
输出: false
解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
示例 4:

输入:
s = "adceb"
p = "*a*b"
输出: true
解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
示例 5:

输入:
s = "acdcb"
p = "a*c?b"
输入: false
 * @author liang
 *
 */
public class WildCardMatching_44 {

	/**
	 * 动态规划算法：输入两个字符串s,p(p包含通配符，用p去匹配s),用flag[i][j]表示字符串p从0到i的的子字符串能否匹配s从0到j的子字符串
	 * 递推公式：
	 * 	 如果p.charAt(i)==s.charAt(j)或则p.charAt(i)=='?',相当于将最后一个字符匹配掉，所以flag[i][j]=flag[i-1][j-1];
	 *  如果p.charAt(i)=='*'，
	 *  	'*'可以选择匹配0个字符，此时flag[i][j]=flag[i-1][j];
	 *  	可以选择匹配1个字符，此时flag[i][j]=flag[i-1][j-1];
	 *  	匹配多个字符就是，flag[i][j]=flag[i-1][j]||flag[i-1][j-1]||……||flag[i-1][0]。
	 *  		也就可以有flag[i][j-1]=flag[i-1][j-1]||flag[i-1][j-2]||……||flag[i-1][0]
	 *    合并简化成flag[i][j]==flag[i-1][j]||flag[i][j-1]
	 *  总体看：flag[i][j]只与第i行和第i-1行相关，所以只需要开辟两个一维数组即可。空间复杂度是O(n),时间复杂度是O（mn）
	 * @param s  字符串
	 * @param p	通配符  令包含？（匹配任何单个字符）和*（匹配任意字符串（包括空字符串））
	 * @return
	 */
    public static boolean isMatch1(String s, String p) {
        if(s == null || p == null)
        	return false;
        int lens = s.length();
        int lenp = p.length();
        boolean[][] flag = new boolean[lens+1][lenp+1];
        
        boolean ff = false;
        
        for(int i=0;i<=lens;i++) {//i是遍历s字符串
        	ff = false;
        	for(int j=0;j<=lenp;j++) {//j是遍历p通配符
        		if(i==0&&j==0) {
        			flag[i][j] = true;
        			ff = true;
        			continue;
        		}
        		
        		if(j == 0) {//p为空，s不为空 false
        			flag[i][j] = false;
        			continue;
        		}
        		
        		if(i == 0) {//s字符串为空,是否匹配看j-1
        			flag[i][j] = flag[i][j-1] && p.charAt(j-1) == '*';
        			System.out.println("i=="+i+",j=="+j+",[]"+flag[i][j]);
        		}else {//正常判断是否匹配，第一个&&是通配符是?或者字符相同  时flag[i][j]=flag[i-1][j-1]
        				//第二个&&是通配符是* 时flag[i][j]==flag[i-1][j]||flag[i][j-1]
        			flag[i][j] = (matchChar(s.charAt(i-1), p.charAt(j-1)) && flag[i-1][j-1])
        					|| (p.charAt(j-1)=='*' && (flag[i][j-1] || flag[i-1][j]));
        			System.out.println("i=="+i+",j=="+j+",[]"+flag[i][j]);
        		}
        		
        		if(flag[i][j])
        			ff = true;
        		//在此即可以退出，因为* 可以匹配余下的所有的字符串
        		if(flag[i][j] && p.charAt(j-1)=='*' && j==lenp) {
        			return true;
        		}
        		
        	}
    		if(!ff) {
    			return false;
    		}
        }
        
        return flag[lens][lenp];
    }
    
    public static boolean matchChar(char c,char p) {
    	return (p == '?' || p == c);
    }
    
    /**
     * 方法二，维护两个指针，一个指向s的字符，一个指向p的字符
     * 如果匹配，直接2个指针一起前进。
     * 如果匹配公式是*，在字符串中依次匹配即可。
     * 迭代程序，记录上一次开始比较的位置
     * 比如字符串是bcefd,通配符b*fd,i(这里是indexS)指向c,j(这里是indexP)指向f， c f不匹配就i+1 j不变，e f还不匹配 i+1,然后f f 匹配
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p) {
        if(s == null || p == null)
        	return false;
        int lens = s.length();
        int lenp = p.length();
        int indexS = 0;
        int indexP = 0;
        int preS = 0;
        int preP = 0;
        boolean back = false;//返回标识符
        while(indexS<lens) {
        	if(indexP<lenp && matchChar(s.charAt(indexS), p.charAt(indexP))) {//如果当前位置单字符匹配，则都++
        		indexS++;
        		indexP++;
        	}else if(indexP<lenp && p.charAt(indexP)=='*') {//当前字符是*
        		while(indexP<lenp && p.charAt(indexP)=='*') {//循环直到找到下一个非*位置
        			indexP++;
        		}
        		if(indexP == lenp) {//说明最后一个位置是*，表示可以匹配任何字符串
        			 return true;
        		}
        		//下一个位置不为*，记录这个位置
        		back = true;
        		preS = indexS;//这里indexS可以理解为例子bcef中的c
        		preP = indexP;//对应的indexP为例子b*f中的f
        	}else if(back){//这个位置不满足单字符匹配，不是*，但记录了前一个字符是*
        		indexS = ++preS; //从c变成e,就是说indexS、preS都一直往后移，直到while循环满足前面单字符匹配条件
        		indexP = preP;//为f
        	}else {
        		return false;
        	}
        }
        // 跳过末尾的所有的*.
        while (indexP < lenp && p.charAt(indexP) == '*') {
        	indexP++;
        }
        
        if (indexS == lens && indexP == lenp) {
             return true;
         }
 
         return false;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch1("adceb","*a*b"));
	}

}
