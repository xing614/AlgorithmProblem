package ���ݷ�;
/**
 * �ִ�װ������                          ��������01������������
 * һ��n����װ�䣬��װ�������ֱ�ΪWi,װ�ص�������Ϊc���ִ��С�
 * �ҳ����װ�����Լ�װ����Щ��װ��
 * @author liang
 * ��ռ���Ϊ�Ӽ�������������
 * ������ת��Ϊ�������������A�ڵ㿪ʼ�������һ������ѡΪ���룬������������B��������������������C����������ȥ��Ϊ2^n���ⷨ��
 * Ȼ������Լ��������������Լ���������������ж��Ƿ�С����������������޽纯�����ò������Ž�ģ���֦��
 */
public class test1 {
	
	public static int c = 20;//�ִ����������
	public static int n = 10;
	public static int w[] = {1,2,3,4,5,6,7,8,9,6};
	public static int cw = 0;//��ǰ������
	public static int r;//ʣ�༯װ������
	public static int bestw = 0;//��ǰ����������
	
	public static int x[] = new int[10];//��ǰ�⣬�������ø�����Ʒ�Ƿ���
	public static int bestx[] = new int[10];//��ǰ���Ž⣬
	
	public static void Backtrack(int i){
		
		//������i����
		if(i>=n){//����Ҷ�ڵ�
			if(cw > bestw){//��ǰ����������֮ǰ������������
				for(int j = 0; j<n; j++){//�������Ž�
					bestx[j] = x[j];
					bestw = cw;
				}
			}
			return;
		}
		//��������
		r -= w[i];//�ֵ��ж�w[i]�Ƿ���룬�ȰѸ�������ʣ��������ȥ��
		if(cw +w[i]<= c){//����w[i]��ǰ���Ƿ�����������С������������������ͱ�����������������ü�װ��
			x[i] = 1;//����
			cw += w[i];//��ǰ������ = ��ǰ + �·����w[i]
			Backtrack(i+1);//������һ��
			cw -= w[i];//�ݹ�����󣬷�����һ�����㣬Ҫ������ӽ�������������ȥ
		}
		if(cw + r > bestw){//��� ��ǰ����+ʣ������ ��ֵ<����������ˣ���û�������������������ˣ���Ϊ�϶��������������
			x[i] = 0;//���ţ�������������
			Backtrack(i+1);
		}
		r+=w[i];//���ݻ����ˣ�ʣ�������ӻ���
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++){
			r += w[i];
		}
		Backtrack(0);
		System.out.println(bestw);
		for(int i=0;i<n;i++){
			if(bestx[i]!=0){
				System.out.println(i);
			}
		}
	}

}
