package �ݹ�����β���;
/**
 * һ��¥����20����ÿ����1�������������ʴӵ��ߵ���һ���ж������߷���
 * ����������ӵ��ߵ���n�����߷���f��n���֣��ߵ��ڣ������������һ���Ǵӣ�n-1)����һ������һ���Ǵӵڣ����������������
 * ǰ����f(n-1)�ַ�����������f(n-2)�ַ�����������f(n)=f(n-1)+f(n-2),����f(0)=1,f(1)=1.
 * @author liang
 *
 */
public class StairsProblem {
	
	/**
	 * nΪ¥����,�ݹ鷽��
	 * @param n
	 * @return
	 */
	public static int search(int n){
		if(n==1 ||n==0)
			return 1;
		else return search(n-1)+search(n-2);
		
	}
	
	public static int[] result = new int[12];
	/**
	 * ��̬�滮��ʹ��һ�������¼���е�ֵ��˼���ǣ��ɵݹ飬��������Щ���ص��ģ�������Ҫ����ظ����㣬��������
	 * @param n
	 * @return
	 */
	public static int searchByDynamic(int n){
		int res;
		if(n==1||n==0)
			return 1;
		if(result[n]>0)
			return result[n];
		else 
			res = searchByDynamic(n-1) + searchByDynamic(n-2);
		result[n] = res;
		return res;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(search(2));
		
		{
			for(int i=0;i<12;i++){
				result[i] = -1;
			}		
			searchByDynamic(12);
		}
	}

}
