package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。

两棵树重复是指它们具有相同的结构以及相同的结点值。

示例 1：

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
下面是两个重复的子树：

      2
     /
    4
和

    4
因此，你需要以列表的形式返回上述重复子树的根结点。
 * @author liang
 *
 */
public class FindDuplicateSubtrees_652 {

	/**
	 * 在一个map<string,list<treenode>>里保存一个子树中序遍历的字符串为key，value保存子树，如果value长度大于1，说明重复
	 * @param root
	 * @return
	 */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    	List<TreeNode> res = new ArrayList<>();
    	if(root == null)
    		return res;
        Map<String,List<TreeNode>> map = new HashMap<>();
        midOrder(root,map);
        for(List<TreeNode> m:map.values()) {
        	if(m.size()>1)
        		res.add(m.get(0));
        }
        return res;
    }
    
	private String midOrder(TreeNode node, Map<String, List<TreeNode>> map) {
		// TODO Auto-generated method stub
		if(node == null)
			return "";
		
		String s = "<"+midOrder(node.left, map)+node.val+midOrder(node.right, map)+">";
		if(!map.containsKey(s))
			map.put(s, new ArrayList<TreeNode>());
		map.get(s).add(node);
		return s;
	}


	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
