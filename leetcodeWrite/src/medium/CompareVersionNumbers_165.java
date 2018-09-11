package medium;
/**
 * 165. 比较版本号
题目描述提示帮助提交记录社区讨论阅读解答
比较两个版本号 version1 和 version2。
如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。

你可以假设版本字符串非空，并且只包含数字和 . 字符。

 . 字符不代表小数点，而是用于分隔数字序列。

例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。

示例 1:

输入: version1 = "0.1", version2 = "1.1"
输出: -1
示例 2:

输入: version1 = "1.0.1", version2 = "1"
输出: 1
示例 3:

输入: version1 = "7.5.2.4", version2 = "7.5.3"
输出: -1
 * @author liang
 *
 */
public class CompareVersionNumbers_165 {

	/**
	 * 版本号先用 . 分割
	 * @param version1
	 * @param version2
	 * @return
	 */
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int i =0;//标志位
        while(i<ver1.length && i<ver2.length) {
        	int n1 = Integer.parseInt(ver1[i]);
        	int n2 = Integer.parseInt(ver2[i]);
        	if(n1<n2) {
        		return -1;
        	}else if(n1>n2) {
        		return 1;
        	}else
        		i++;
        }
        if(i== ver1.length && i==ver2.length)//长度都到头了，表示两个数一样
        	return 0;
        else if(i == ver1.length) {//没有遍历完ver2的数据
        	while(i<ver2.length) {
        		if(Integer.parseInt(ver2[i])!=0) {//不是0，就说明比ver1的大
        			return -1;
        		}
        		i++;
        	}
        	return 0;
        }else {
        	while(i<ver1.length) {
        		if(Integer.parseInt(ver1[i])!=0) {//不是0，就说明比ver1的大
        			return 1;
        		}
        		i++;
        	}
        	return 0;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
