package medium;

import java.util.Stack;

/**
 * 71. 简化路径
给定一个文档 (Unix-style) 的完全路径，请进行路径简化。

例如，
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

边界情况:

你是否考虑了 路径 = "/../" 的情况？
在这种情况下，你需返回 "/" 。
此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 * @author liang
 *
 */
public class SimplifyPath_71 {
	/**
	 * 路径简化的依据是：
     * 当遇到“/../"则需要返回上级目录，需检查上级目录是否为空。
     * 当遇到"/./"则表示是本级目录，无需做任何特殊操作。 
     * 当遇到"//"则表示是本级目录，无需做任何操作。
     * 当遇到其他字符则表示是文件夹名，无需简化。
     * 当字符串是空或者遇到”/../”，则需要返回一个"/"。
     * 当遇见"/a//b"，则需要简化为"/a/b"
     * 我的思路是先把所有的按照/分割开来
     * 当字符串不为".."，则将字符串入栈。
     * 当字符串为"..", 则弹栈（返回上级目录）
     * 最后使用StringBuilder进行拼接，由于String在每次对字符串修改时候均会生成一个新的String，
     * 效率较低，一般会采用StringBuilder或者StringBuffer来进行字符串修改的操作，
     * StringBuilder是StringBuffer的简易替换，是非线程安全的，而StringBuffer是线程安全的。
	 * @param path
	 * @return
	 */
    public String simplifyPath(String path) {
        if(path==null||path.length()==0)
        	return path;
        Stack<String> stack = new Stack<String>();
        String[] list = path.split("/");
        for(int i=0; i<list.length; i++){
        	if(list[i].equals(".")||list[i].length()==0)
                continue;
            else if(!list[i].equals(".."))
                stack.push(list[i]);
            else{
                if(!stack.isEmpty())
                    stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();   
        Stack<String> temp = new Stack<String>();
        while(!stack.isEmpty())  
            temp.push(stack.pop());     
        while(!temp.isEmpty())
            res.append("/"+temp.pop());      
        if(res.length()==0)
            res.append("/");  
        return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
