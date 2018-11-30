package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * 508. 出现次数最多的子树元素和
 * 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。

 

示例 1
输入:

  5
 /  \
2   -3
返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。

示例 2
输入:

  5
 /  \
2   -5
返回 [2]，只有 2 出现两次，-5 只出现 1 次。

 

提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 * @author liang
 *
 */
public class MostFrequentSubtreeSum_508 {

	/**
	 * 找出出现频率最高的子树和值
	 * 使用dfs计算每个子树和
	 * 用HashMap，以子树和为key，以出现次数为value
	 * 数组来记录，如果碰到次数更当前记录的次数最大的一直的子树和，就添加到数组中，当出现更大次数的时候就重新记录，替代数组第一个元素
	 * @param root
	 * @return
	 */
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)
        	return new int[] {};
        HashMap<Integer,Integer> map = new HashMap<>();
        countSumDFS(root, map);
        
        int[] res = new int[map.size()];//存储结果
        int num = 0;//最大值的个数
        int max = 0;//最高子树和
        java.util.Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
        	Map.Entry<Integer, Integer> entry = iter.next();
        	if((int)entry.getValue()>max) {//大于最大值，则重置结果
        		num = 1;
        		res[0] = (int)entry.getKey();
        		max = (int)entry.getValue();
        	}else if((int)entry.getValue() == max){
        		res[num] = (int)entry.getKey();
        		num++;
        	}
        }
        return Arrays.copyOfRange(res, 0, num);
    }
    /**
     * 计算子树和
     * 保存到map
     * @param root
     * @param map
     * @return
     */
    public int countSumDFS(TreeNode root,HashMap<Integer,Integer> map) {
    	int sum = 0;
    	sum+=root.val;
    	if(root.left != null)
    		sum+=countSumDFS(root.left, map);
    	if(root.right!=null)
    		sum+=countSumDFS(root.right, map);
    	if(map.containsKey(sum)) {
    		map.put(sum, map.get(sum)+1);
    	}else {
    		map.put(sum, 1);
    	}
    	return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; 
    }
}
	 
}
