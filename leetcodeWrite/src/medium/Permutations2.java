package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 * @author liang
 *
 */
public class Permutations2 {

	/**
	 * 剪枝
	 * 举个例子：对于序列<1,1,2,3>。在DFS首遍历时，1 作为首元素被加到list中，并进行后续元素的添加；那么，当DFS跑完第一个分支，遍历到1 (第二个)时，这个1 不再作为首元素添加到list中，因为1 作为首元素的情况已经在第一个分支中考虑过了。 
	 *  1. 先对给定的序列nums进行排序，使得大小相同的元素排在一起。 
  	 *	2. 新建一个used数组，大小与nums相同，用来标记在本次DFS读取中，位置i的元素是否已经被添加到list中了。 
  	 *	3. 根据思路可知，我们选择跳过一个数，当且仅当这个数与前一个数相等，并且前一个数未被添加到list中。 
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(len==0||nums==null)  return res;

        boolean[] used = new boolean[len];
        List<Integer> list = new ArrayList<Integer>();

        Arrays.sort(nums);
        dfs(nums, used, list, len,res);
        return res;
    }
    //这里是判断list长度是否和数组长度一样，也可以用Level层数
	private void dfs(int[] nums, boolean[] used, List<Integer> list, int len, List<List<Integer>> res) {
        if(list.size()==len) {
            res.add(new ArrayList<Integer>(list));
            return ;
        }
        for(int i=0;i<len;i++) {
        	// 当前位置的数已经在List中了
        	if(used[i])continue;
        	 // 当前元素与其前一个元素值相同 且 前元素未被加到list中，跳过该元素
        	if(i>0 && nums[i]==nums[i-1] && !used[i-1])continue;
        	// 深度优先搜索遍历
        	used[i] =true;
        	list.add(nums[i]);
        	dfs(nums,used,list,len,res);
        	list.remove(list.size()-1);
        	used[i] =false;
        }
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
