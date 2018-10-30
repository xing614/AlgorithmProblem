package medium;
/**
 * 331.验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。

给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。

每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。

你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。

示例 1:

输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
输出: true
示例 2:

输入: "1,#"
输出: false
示例 3:

输入: "9,#,#,1"
输出: false
 * @author liang
 *
 */
public class VerifyPreorderSerializationOfABinaryTree_331 {

	/**
	 * 规律：
	 * 1. 数字的个数总是比#号少一个
	 * 2. 最后一个一定是#号
	 * @param preorder
	 * @return
	 */
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        int degree = -1;//#比数字个数多1，所以最初设置-1，结果遍历完这个数应该是0
        for(String str:strs) {
        	degree++;
        	if(degree>0)//大于0就当前 #个数大于数字个数了，超过容忍范围
        		return false;
        	if(!str.equals("#")) {//一个数字可以容忍两个#
        		degree-=2;
        	}
        }
        return degree == 0;//
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
