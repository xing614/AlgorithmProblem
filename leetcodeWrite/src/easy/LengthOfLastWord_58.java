package easy;
/**
 * 58. 最后一个单词的长度
给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:

输入: "Hello World"
输出: 5

 * @author liang
 *
 */
public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        int n =s.length();
        int res= 0;
        if(n==0) return res;
        int index = n-1;
        while(index!=0 && s.charAt(index)==' ') {//将末尾所有空格去掉
        	index--;
        }
        //从最后一个字母开始搜索，直到第一位或者找到距离末位最近的第一个空格的位置
        while( index!=-1  && s.charAt(index)!=' ') {//index!=-1放在前，防止StringIndexOutOfBoundsException: String index out of range: -1
        	res ++;
        	index--;
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
