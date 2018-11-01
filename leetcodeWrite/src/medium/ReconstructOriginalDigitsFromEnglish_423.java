package medium;
/**
 * 423. 从英文中重建数字
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。

注意:

输入只包含小写英文字母。
输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
输入字符串的长度小于 50,000。
示例 1:

输入: "owoztneoer"

输出: "012" (zeroonetwo)
示例 2:

输入: "fviefuro"

输出: "45" (fourfive)
 * @author liang
 *
 */
public class ReconstructOriginalDigitsFromEnglish_423 {

	/**
	 * 对字符串中的字符进行计数，根据这些字符与数字的关系可以直接得到结果。
	 * 例如：字符z只在zero中出现，字符w只在two中出现，字符x只在six中出现，字符g只在eigth中出现，字符u只在four中出现
	 * 那么我们根据z,w,x,g,u的个数就可以知道0,2,6,8,4的个数。
	 * 对于剩下的one,three,five,seven，one可以由字符o的个数减去在0,2,4,6,8中出现的o的个数。
	 * three可以由字符h的个数减去字符t,r,e在0,2,4,6,8中出现的个数
	 * 同理可以得到剩下的数字的个数
	 * @param s
	 * @return
	 */
    public String originalDigits(String s) {
        int[] temp = new int[26];//abcde每个字符出现的次数
        int[] digit = new int[10];//123456十个数字每个数字出现的次数
        for(int i=0;i<s.length();i++) {
        	temp[s.charAt(i)-97]++;
        }
        digit[0] = temp['z'-97];//0是zero， z只在这里出现了，所以通过它可以知道0出现的次数
        digit[2] = temp['w'-97];
        digit[6] = temp['x'-97];
        digit[8] = temp['g'-97];
        digit[4] = temp['u'-97];
        
        digit[1] = temp['o' -97] - (digit[0] + digit[2] + digit[4]);
        digit[3] = temp['h' -97] - digit[8];
        digit[5] = temp['f' -97] - digit[4];
        digit[7] = temp['s' -97] - digit[6];
        digit[9] = temp['i' -97] - (digit[6] + digit[8] + digit[5]);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<digit.length;i++) {
        	for(int j = 0;j<digit[i];j++) {
        		sb.append(i+"");
        	}
        }
        return sb.toString();
    }
    
}
