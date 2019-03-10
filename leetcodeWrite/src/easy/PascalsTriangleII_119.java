package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
 * @author liang
 *
 */
public class PascalsTriangleII_119 {

	/**
	 * 与118的区别是返回第k行，这里本身将res作为返回，然后下一行以前一行为基础，从后往前开始修改
	 * @param rowIndex
	 * @return
	 */
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(rowIndex < 0){
    	    return res;
    	}
    	res.add(1);
    	for(int i=0;i<rowIndex;i++) {
    		for(int j=res.size()-1;j>0;j--) {
    			res.set(j, res.get(j-1)+res.get(j));
    			
    		}
    		res.add(1);
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
