package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 648. 单词替换
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。

现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。

你需要输出替换之后的句子。

示例 1:

输入: dict(词典) = ["cat", "bat", "rat"]
sentence(句子) = "the cattle was rattled by the battery"
输出: "the cat was rat by the bat"
注:

输入只包含小写字母。
1 <= 字典单词数 <=1000
1 <=  句中词语数 <= 1000
1 <= 词根长度 <= 100
1 <= 句中词语长度 <= 1000
 * @author liang
 *
 */
public class ReplaceWords_648 {

	/**
	 * 已知sentence和缩写list,把sentence中的word按照一定规则转换成其缩写,并返回sentence。
	 * 解题思路是,用一个hashset存储缩写list中的元素,把sentence通过split(” “)分割成单词array,
	 * 逐个单词对应查找其缩写并转换成其缩写,再把缩写后的单词array合成sentence并返回。
	 * @param dict
	 * @param sentence
	 * @return
	 */
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<String>();
        set.addAll(dict);
        String[] words = sentence.split(" ");
        String replaceWords = "";
        for(int i=0;i<words.length;i++) {
        	for(int j=0;j<words[i].length();j++) {
        		if(set.contains(words[i].substring(0, j+1))) {//最短的前缀词
        			words[i] = words[i].substring(0, j+1);
        			break;
        		}
        	}
        }
        for(int i=0;i<words.length;i++)
        	replaceWords+=(words[i]+" ");
        return replaceWords.substring(0,replaceWords.length()-1);
    }
    

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
