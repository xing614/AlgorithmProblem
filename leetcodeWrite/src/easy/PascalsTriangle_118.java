package easy;

import java.util.ArrayList;
import java.util.List;
/**
 * 118. 杨辉三角
 * 输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author liang
 *
 */
public class PascalsTriangle_118 {

	/**
	 * 根据规律设定
	 * @param numRows
	 * @return
	 */
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(numRows == 0)
    		return res;
    	List<Integer> pre = new ArrayList<>();//前一列
    	pre.add(1);
    	res.add(pre);
    	for(int i=0;i<numRows-1;i++) {
    		List<Integer> cur = new ArrayList<Integer>();
    		cur.add(1);//左边第一个数
    		for(int j=1;j<pre.size();j++) {//前一组的个数-2个；从第三行还是加
    			cur.add(pre.get(j-1)+pre.get(j));
    		}
    		cur.add(1);//右边最后一个
    		res.add(cur);
    		pre = cur;
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
