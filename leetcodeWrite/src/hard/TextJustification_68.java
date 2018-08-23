package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:

单词是指由非空格字符组成的字符序列。
每个单词的长度大于 0，小于等于 maxWidth。
输入单词数组 words 至少包含一个单词。
示例:

输入:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
输出:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
示例 2:

输入:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
输出:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     因为最后一行应为左对齐，而不是左右两端对齐。       
     第二行同样为左对齐，这是因为这行只包含一个单词。
示例 3:

输入:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
输出:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 * @author liang
 *
 */
public class TextJustification_68 {

	/**
	 * 1、每一行选择K的单词，K个单词的长度+K-1个空格的长度必须要小于maxWidth，这里每次选择满足这个条件的最大值就可以 
	 * 2、对于已经选定了K个单词，首先计算基本空格，也就是space=（maxWidth-所有单词的长度）/ （k-1），但是还有多余出一部分空格，那么就在附加空格的时候，从左边开始每次多加一个，满足题目的左边的空格大于等于右边的（至多多一个） 
	 * 3、注意只有1个单词的场景 
	 * 4、最后一行需要调整，最后一行单词之间的空格只有1个，末尾再用空格补足长度“
	 * @param words
	 * @param maxWidth
	 * @return
	 */
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> res = new ArrayList<String>();
        int start = 0;
        int end = 1;
        int n =words.length;
        while(start<n) {
        	int compulsorySpaces=0; //必须的空格，为当前选中单词数量-1
        	int wordLength=words[start].length();//当前选中单词的字符数量
        	//试探选择最大的单词数量
        	while(end<n && compulsorySpaces+1+wordLength+words[end].length()<=maxWidth) {
                compulsorySpaces++;
                wordLength+=words[end].length();
                end++;
        	}
        	if(end == n) {//末行特殊处理,最后一行正常放入字符串每个字符串之间一个空格，然后末位添加多个空格
        		StringBuffer sb = new StringBuffer(words[start]);
        		for(int k=start+1;k<end;k++) 
        			sb.append(" "+words[k]);
        		for(int k=wordLength+compulsorySpaces;k<maxWidth;k++) sb.append(" ");
        		 res.add(sb.toString());
                 break;
        	}
        	if(end-start==1){ //只选中一个的特殊处理，剩下位置填入空格
                StringBuilder sb=new StringBuilder(words[start]);
                for(int k=wordLength;k<maxWidth;k++)
                    sb.append(" ");
                res.add(sb.toString());
            }
        	else {//处理多个空格
        		int space = (maxWidth - wordLength)/(end-start-1);//单词之间的空格数
        		int remains = maxWidth-wordLength-(end-start-1)*space; //因为整除未能分配的空格数量，这些空格数量依次从左向右一个一个加在空格中
        		 StringBuilder sb=new StringBuilder(words[start]);
                 for(int k=start+1;k<end;k++){
                	 for(int l=0;l<space;l++) sb.append(" ");//每个之间添加的均等数空格
                	 if(remains-- > 0) sb.append(" ");//在大于0，也就是还需要在左边多加空格的时候，多给一个
                	 sb.append(words[k]);
                 }
                 res.add(sb.toString());
        	}
        	start = end;
        	end = end+1;
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
