package hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例:

LRUCache cache = new LRUCache( 2 /* 缓存容量 );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
 * @author liang
 *
 */
public class LRUCache_146 {
	
	private List<CacheNode> cacheList;
	private HashMap<Integer,CacheNode> cacheMap;
	private int capacity;
	
	/**
	 * LRU算法一般使用链表，如果有元素 就把该元素返回并放在队头，如果没有就插入队头，链表满了就移除尾数据，
	 * 这里要求O（1），所以再添加HashMap作为查找，保证速度1
	 * @param capacity
	 */
    public LRUCache_146(int capacity) {
    	cacheList = new LinkedList<CacheNode>();
        cacheMap = new HashMap<Integer, CacheNode>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cacheMap.containsKey(key)) {
        	cacheList.remove(cacheMap.get(key));
        	cacheList.add(0,cacheMap.get(key));//队头添加
        	return cacheMap.get(key).value;
        }else {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
    	CacheNode ca = new CacheNode(key,value);
        if(cacheMap.containsKey(key)) {
        	cacheList.remove(cacheMap.get(key));
        	cacheList.add(0,ca);//队头添加
        	cacheMap.get(key).value = value;
        }else {
        	//没有这个元素
        	if(cacheMap.size() == capacity) {
        		//移除
        		cacheMap.remove(cacheList.get(cacheList.size()-1).key);
        		cacheList.remove(cacheList.size()-1);
        		cacheMap.put(key, ca);
        		cacheList.add(0,ca);
        	}else {
        		cacheMap.put(key, ca);
        		cacheList.add(0,ca);
        	}
        }
    }
    
    //设置缓存元素
    private class CacheNode{
    	int key;
        int value;
        public CacheNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
