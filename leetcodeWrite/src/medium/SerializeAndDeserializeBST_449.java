package medium;
/**
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。

设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。

编码的字符串应尽可能紧凑。

注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 * @author liang
 *
 */
public class SerializeAndDeserializeBST_449 {
	/**
	 * 先序遍历
	 * @param root
	 * @return
	 */
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root,sb);
        return sb.toString();
    }

    private void serializeDFS(TreeNode root, StringBuilder sb) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		sb.append(root.val).append(",");
		serializeDFS(root.left, sb);
		serializeDFS(root.right, sb);
	}

	// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
        	return null;
        String[] arr = data.split(",");
        return deserializeDFS(arr,0,arr.length-1);
    }
    
    private TreeNode deserializeDFS(String[] arr, int left, int right) {
		// TODO Auto-generated method stub
    	if(left>right || left>=arr.length)
    		return null;
    	TreeNode root = new TreeNode(Integer.parseInt(arr[left]));
		int mid = gitMid(arr,left,right);
		root.left = deserializeDFS(arr, left+1, mid-1);
		root.right = deserializeDFS(arr, mid+1, right);
    	return root;
	}

    /**
     * 找中间值
     * @param arr
     * @param left
     * @param right
     * @return
     */
	private int gitMid(String[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int init = Integer.parseInt(arr[left]);
		while(left<=right) {
			if(init<Integer.parseInt(arr[left]))
				break;
			else 
				left++;
		}
		return left;
	}

	public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
}
