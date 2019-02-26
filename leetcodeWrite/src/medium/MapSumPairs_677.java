package medium;
/**
 * 677. 键值映射
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。

对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。

对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。

示例 1:

输入: insert("apple", 3), 输出: Null
输入: sum("ap"), 输出: 3
输入: insert("app", 2), 输出: Null
输入: sum("ap"), 输出: 5
 * @author liang
 *
 */
public class MapSumPairs_677 {
	/**
	 * 使用前缀树，sum方法的时候首先要找到匹配前缀的节点，然后用层序遍历(广度优先)方式去遍历这个节点的子树。遍历的时候使用递归进行遍历。
	 */
	//key的前缀字符
	char keyPrefix;
	//子节点
	MapSumPairs_677[] children;
	//存储的值，不为0则为终止节点
	int value;
	
    /** Initialize your data structure here. */
    public MapSumPairs_677() {
        children = new MapSumPairs_677[26];//26字符可能
        value = 0;
    }
    
    /**
     * 字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
     * @param key
     * @param val
     */
    public void insert(String key, int val) {
        if(key!=null) {
        	char[] charArr = key.toCharArray();
        	MapSumPairs_677 currentNode = this;
        	for(int i=0;i<charArr.length;i++) {
        		char currentChar = charArr[i];
        		//根据字符获取对应的子节点
        		MapSumPairs_677 node=currentNode.children[currentChar-97];
        		if(node!=null && node.keyPrefix==currentChar){//判断节点是否存在
                    currentNode=node;
                }else{//不存在则创建一个新的叶子节点,并指向当前的叶子节点
                    node=new MapSumPairs_677();
                    node.keyPrefix=currentChar;
                    currentNode.children[currentChar-97]=node;
                    currentNode=node;
                }
        	}
        	//存储值
            currentNode.value=val;
        }else {
        	this.value = val;
        }
    }
    
    /**
     * 根据表示前缀的字符串，返回所有以该前缀开头的键的值的总和。
     * @param prefix
     * @return
     */
    public int sum(String prefix) {
    	int result=0;
        //前缀是否匹配
        boolean match=true;
        if(prefix!=null && !prefix.trim().equals("")){
            char[] prefixChar=prefix.toCharArray();
            MapSumPairs_677 currentNode=this;
            for(int i=0;i<prefixChar.length;i++){
                char currentChar=prefixChar[i];
                MapSumPairs_677 node=currentNode.children[currentChar-97];
                if(node!=null && node.keyPrefix==currentChar){//判断节点是否存在
                    currentNode=node;
                }else{
                    match=false;
                    break;
                }
            }
            if(match){//前缀匹配后开始检索这个匹配节点后续的子树
                result=sumByFloor(currentNode);
            }
        }
        return result;
    }
    /**
     * 层序遍历(广度优先)方式访问树
     * @param mapSum
     * @return
     */
    private int sumByFloor(MapSumPairs_677 mapSum){
        int result=0;
        if(mapSum==null){
            return 0;
        }else{
            result+=mapSum.value;
            MapSumPairs_677[] mapSums=mapSum.children;
            for(MapSumPairs_677 sum:mapSums){
                if(sum!=null){
                    result+=sumByFloor(sum);
                }else{
                    result+=sumByFloor(sum);
                }
            }
        }
        return result;
    }
}
