package threadAbout;

public class SiSuo implements Runnable{

	public int flag = 1;
	public static Object o1 = new Object();//静态的就是类属性
	public static Object o2 = new Object();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SiSuo td1 = new SiSuo();  
		SiSuo td2 = new SiSuo();  
        td1.flag = 1;  
        td2.flag = 0;  
        //td1,td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。  
        //td2的run()可能在td1的run()之前运行  
        new Thread(td1).start();  
        new Thread(td2).start(); 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(flag == 1) {
			synchronized(o1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(o2) {
					System.out.println(1);
				}
			}
		}
		if(flag ==1) {
			synchronized(o2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(o1) {
					System.out.println(1);
				}
			}
		}
	}

}
