package medium;

/**
 * ������Ӵ�
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ1000��
	
	ʾ�� 1��
	
	����: "babad"
	���: "bab"
	ע��: "aba"Ҳ��һ����Ч�𰸡�
	ʾ�� 2��
	
	����: "cbbd"
	���: "bb"
 * @author liang
 *
 */
public class LongestPalindromicSubstring {
	/**
	 * �����ƽ⣺���������Ӵ����ж�ÿ���Ӵ��Ƿ��ǻ��Ĵ� O(n)
	 * ���(0~n)�ַ�����ʼ�жϣ���Ϊ�������ж�(0~(n-1)),(1~n),(0~(n-2)),(1~(n-1))���������� �ҵ��������
	 * @param s
	 * @return
	 */
    public static String longestPalindrome(String s) {
    	for(int i=s.length();i>0;i--) {
    		for(int left=0,right=(i-1);right<s.length();left++,right++) {
    			if(isLongest(s,left,right)) {
    				return s.substring(left,right+1);
    			}
    		}
    	}
		return s;
    }
    //�ж��Ƿ��ǻ����Ӵ�
    public static boolean isLongest(String s,int left,int right) {
    	while(left<right) {
    		if(s.charAt(left) == s.charAt(right)) {
    			left++;
    			right--;
    		}else {
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * �����ĵ���������ɢѰ������Ĵ�
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
    	String resu = "";
    	String check = "";
    	if(s.length() == 1) return s;
    	for(int i=0;i<s.length();i++) {
    		check = checkLongest(s,i,i);//Ѱ����iΪ���ĵ���Ӵ�
    		if(check.length()>resu.length()) {
    			resu = check;
    		}
    		check = checkLongest(s,i,i+1);//Ѱ����i��i+1�ԳƵ���Ӵ�
    		if(check.length()>resu.length()) {
    			resu = check;
    		}
    	}
    	return resu;
    }
    
	private static String checkLongest(String s, int left, int right) {
		String result = "";
		while(left>=0 && right<s.length()) {
			if(s.charAt(left) == s.charAt(right)) {
				result = s.substring(left, right+1);
				left--;
				right++;				
			}else {
				return result;
			}

		}
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome2("babad"));
	}

}
