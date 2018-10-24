package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 399. 除法求值
 * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。

示例 :
给定 a / b = 2.0, b / c = 3.0
问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]

输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。

基于上述例子，输入如下：

equations(方程式) = [ ["a", "b"], ["b", "c"] ],
values(方程式结果) = [2.0, 3.0],
queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。


 * @author liang
 *
 */
public class EvaluateDivision_399 {

	//存储
	HashMap<String,List<String>> divisionRelations = new HashMap<>();//除间关系
	HashMap<String,Double> equationsResult = new HashMap<>();//结果关系
	
	
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //保存好关系
    	for(int i=0;i<equations.length;i++) {
    		String a = equations[i][0];
    		String b = equations[i][1];
    		if(divisionRelations.containsKey(a) == false) {
    			divisionRelations.put(a, new ArrayList<String>());
    		}
    		if(divisionRelations.containsKey(b) == false) {
    			divisionRelations.put(b, new ArrayList<String>());
    		}
    		divisionRelations.get(a).add(b);
    		equationsResult.put(a+"%"+b, values[i]);
    		//存入b/a的情况
    		if(values[i]!=0)
    			divisionRelations.get(b).add(a);
    		equationsResult.put(b+"%"+a, 1.0/values[i]);
    	}
    	//计算
    	double[] result = new double[queries.length];
    	for(int i=0;i<queries.length;i++) {
    		result[i] = dfs(new HashSet<String>(),queries[i][0],queries[i][1]);
    	}
    	return result;
    }
    
    /**
     * 搜索那些那可以,要么 a/b 存在,要么有 （a/c）*(c/b)存在，二选一
     * @param visited 里面保存的是已经遍历到的元素
     * @param val
     * @param string
     * @param string2
     * @return
     */
	private double dfs(HashSet<String> visited, String a, String b) {
		double result = -1;
		visited.add(a);
		//不存在这个元素就返回-1
		if(divisionRelations.containsKey(a) == false) {
			visited.remove(a);
			return result;
		}
		//与a直接相连的元素
		List<String> list = divisionRelations.get(a);
		for(String temp:list) {
			if(temp.equals(b)) {//找到了，a/b 存在,设置result
				result = equationsResult.get(a+"%"+temp);
				break;
			}else if(visited.contains(temp) == false){
				double midResult = dfs(visited,temp,b);
				if(midResult!=-1) {//（a/c）*(c/b)
					result = equationsResult.get(a+"%"+temp)*midResult;
					break;
				}
			}
		}
		visited.remove(a);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
