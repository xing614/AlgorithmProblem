package hard;
/**
 * ������ʽƥ��
 * 
 * ����һ���ַ��� (s) ��һ���ַ�ģʽ (p)��ʵ��֧�� '.' �� '*' ��������ʽƥ�䡣

'.' ƥ�����ⵥ���ַ���
'*' ƥ���������ǰ���Ԫ�ء�
ƥ��Ӧ�ø��������ַ��� (s) �������ǲ����ַ�����

˵��:

s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� . �� *��
ʾ�� 1:

����:
s = "aa"
p = "a"
���: false
����: "a" �޷�ƥ�� "aa" �����ַ�����
ʾ�� 2:

����:
s = "aa"
p = "a*"
���: true
����: '*' �����ƥ���������ǰ���Ԫ��, ������ƥ�� 'a' �����, �ظ� 'a' һ��, �ַ����ɱ�Ϊ "aa"��
ʾ�� 3:

����:
s = "ab"
p = ".*"
���: true
����: ".*" ��ʾ��ƥ���������('*')�����ַ�('.')��
ʾ�� 4:

����:
s = "aab"
p = "c*a*b"
���: true
����: 'c' ���Բ����ظ�, 'a' ���Ա��ظ�һ�Ρ���˿���ƥ���ַ��� "aab"��
ʾ�� 5:

����:
s = "mississippi"
p = "mis*is*p*."
���: false
 * @author liang
 *
 */
public class RegularExpressionMatching {
	/**
	 * �ݹ�
	 * 1�ж�P����һ���ַ���*�����p��s��ǰ�ַ���ͬ����p�ǡ�.��,��һֱ�����ƶ�ֱ��pû�С�.*����x*������������ݹ��жϣ�x��ָ��s��ͬ���ַ���
	 * 2P����һ���ַ�����*�����p��s��ǰ�ַ���ͬ����p�ǡ�.������p��s�����ƶ�һ���ַ����ݹ��ж�
	 * @param s
	 * @param p
	 * @return
	 */
    public static boolean isMatch(String s, String p) {
    	int slen = s.length();
    	int plen = p.length();
    	
    	if(plen == 0) return slen == 0;
    	if(plen == 1) {//ƥ���ַ�������Ϊ1����Ҫôs == p;pΪ.ʱs����Ϊ1
    		if(p.equals(s)||p.equals('.')&&s.length()==1) return true;
    		else return false;
    	}
    	if(p.charAt(1)=='*') {//��[1]��ʼ�ж��ǲ���*
    		//��һ���ַ� Ϊ*ʱ���жϵ�һ���ַ�s��p�Ƿ�ƥ�䣬ƥ���һֱ�����ƶ�
    		while(s.length()>0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
    			if(isMatch(s,p.substring(2))) return true;//������S����p���� �ǲ���Ҳƥ��
    			s.substring(1);//����
    		}
    		return isMatch(s,p.substring(2));//����s���Ʋ�ƥ���ˣ���ʼ����P�ݹ��ж�
    	}else {
    		//��һ���ַ���Ϊ*ʱ���жϵ�һ���ַ�s��p��ͬ����p��ǰ�ַ��ǡ�.����ƥ���s��Pһֱ�����ƶ�
    		if(s.length()>0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
    			return isMatch(s.substring(1),p.substring(1));
    		}
    		return false;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isMatch("aab","c*a*b");
	}

}
