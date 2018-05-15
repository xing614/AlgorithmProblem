package medium;

import java.util.HashSet;

/**
 * ���ظ��ַ�����Ӵ�
 * ����һ���ַ������ҳ��������ظ��ַ�����Ӵ��ĳ��ȡ�
	
	ʾ����
	
	���� "abcabcbb" ��û���ظ��ַ�����Ӵ��� "abc" ����ô���Ⱦ���3��
	
	���� "bbbbb" ������Ӵ����� "b" ��������1��
	
	���� "pwwkew" ����Ӵ��� "wke" ��������3����ע��𰸱�����һ���Ӵ���"pwke" �� ������  �������Ӵ���
 * @author liang
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * ����ѭ��
	 * @param s
	 * @return
	 */
    public static int lengthOfLongestSubstring(String s) {
    	if(s.length() == 0) {
    		return 0;
    	}
    	if(s.length() == 1) {
    		return 1;
    	}
    	int max = 0;
    	int result = 0;
    	for(int i=0;i<s.length();i++) {
    		HashSet hs = new HashSet();
    		for(int j=i;j<s.length();j++) {
    			if(hs.contains(s.charAt(j))) {
    				if(result>max) {
    					max = result;    			
    				}
    				result = 0;
    				break;

    			}else {
    				hs.add(s.charAt(j));
    				result++;
    				if(j==(s.length()-1)) {
    					if(result>max) {
        					max = result;
    					}
    					result = 0;
    				}
    			}
    		}
    	}
		return max;
        
    }
	
    /**
     * �ַ������÷�����
     * ����������ָ�룬��ע�м��ַ�����ÿ���ж���ѡ����/��һ��ָ����ǰ�ƶ���ά��һ��HashSet, 
     * ����������ƶ��Ҵ��ڣ����û�г����ظ�������ƶ��Ҵ��ڣ�
     * ��������ظ��ַ�����˵����ǰ�����еĴ��Ѿ�������Ҫ�󣬼����ƶ��д��ڲ����ܵõ����õĽ����
     * ��ʱ�ƶ��󴰿ڣ�ֱ���������ظ��ַ�Ϊֹ���м���������Щ���в����и��õĽ������Ϊ���ǲ����ظ����Ǹ��̡�
     * ��Ϊ�󴰿ں��Ҵ��ڶ�ֻ��ǰ�������������ڶ���ÿ��Ԫ�ط��ʲ�����һ�飬���ʱ�临�Ӷ�ΪO(2*n)=O(n),�������㷨���ռ临�Ӷ�ΪHashSet��size,Ҳ��O(n). 
     * O(n)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if(s==null || s.length()==0)  
            return 0;  
        HashSet<Character> set = new HashSet<Character>();  
        int max = 0;  
        int walker = 0;  //��
        int runner = 0;  //��
        while(runner<s.length())  //��û��ͷ
        {  
            if(set.contains(s.charAt(runner)))  //���ظ�����
            {  
                if(max<runner-walker)  
                {  
                    max = runner-walker;  
                }  
                while(s.charAt(walker)!=s.charAt(runner))  //��������ݣ�=�����ݣ�˵���ظ����ַ�������֮����ַ����У�����ָ��ǰ�ƣ�ͬʱ���������ɾ��
                {  
                    set.remove(s.charAt(walker));  
                    walker++;  
                }  
                walker++;  //�ҵ��ظ����ݣ���ָ��ǰ��һλȥ���ظ����ݣ���һ����Ѱ��Ӧ�ÿ�������ظ��ĵط����У��������ҳ����ĺ�ѡ����Ȼ���ظ��ַ����ҳ��Ȼ������ϴε�����
            }  
            else  
            {  
                set.add(s.charAt(runner));  
            }  
            runner++;  
        }  
        max = Math.max(max,runner-walker);  //��Ϊ�������һ�μ���ʱ��runnerֱ���ߵ��ַ���ĩβ��û�������ظ��ַ�����whileѭ�������ҵ�������ظ��Ӵ�ֻ����runner�����ظ��ַ�ʱ�Ž��еġ�
        return max;  
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("au"));
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

}
