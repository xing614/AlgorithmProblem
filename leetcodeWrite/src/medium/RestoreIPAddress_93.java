package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 93. 复原IP地址
题目描述提示帮助提交记录社区讨论阅读解答
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
 * @author liang
 *
 */
public class RestoreIPAddress_93 {

	/**
	 * 递归
	 * 一个ip地址只有3个点，根据点的个数判断合法不合法（也即字符串长度只能比点的个数多，且小于3*（k+1）,k为点的个数）。
	 * 如果最后不需要添加点，则字段值小于256，则合法，添加结果集。
	 * @param s
	 * @return
	 */
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        
        //3表示当前还有三个点
        ddd(list,s,"",3);
        return list;
    }
    /**
     * 
     * @param list 返回的集合
     * @param s	//字符串s
     * @param res	//结果，最后加到集合中
     * @param i	//剩余的点‘.’个数
     */
	private void ddd(List<String> list, String s, String res, int i) {
		// TODO Auto-generated method stub
		//S长度小于点的个数，就不够分配了
		if(s.length() <= i){
    		return;
    	}
		//s的长度超过了最长值
		if(s.length()>3*(i+1)) {
			return;
		}
		//最后一段，要小于256
		if(i==0) {
			if((s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>=256) {
				return;
			}
			list.add(res+"."+s);
			return;
		}
		//遍历前面3位，如果小于256，则参与递归
		for(int j=1;j<=s.length();j++) {
			String temp = s.substring(0,j);//当前段小于256，表示合法，可以继续
    		if(Integer.parseInt(temp) < 256){
    			String str = s.substring(j);//从J开始之后的数据
    			//分情况，如果result为空，则前面不加"."
    			if(res.length()>0) {
    				temp = res+"."+temp;
    			}
    			ddd(list,str,temp,i-1);
    			//如果第一个数字为0，则不再继续循环
    			if(s.charAt(0) == '0'){
    				break;
    			}
    		}else {
    			break;
    		}
		}
	}
	
	public static int aa() {
		int x;
		try {
			x = 1;//正常返回1
			return x; 
		}catch (Exception e) {
			// TODO: handle exception
			x = 2;
			return x;
		}finally {
			x = 3;
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(aa());
	}

}
