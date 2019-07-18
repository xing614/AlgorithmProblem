package threadAbout;

import java.util.concurrent.Semaphore;

public class ABCABCABC {

	private static Semaphore A = new Semaphore(1);
	private static Semaphore B = new Semaphore(0);
	private static Semaphore C = new Semaphore(0);
	public volatile int flag = 1;
	static class PrintA implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(true) {
					A.acquire(1);
					System.out.println(1);
					B.release();
				}				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static class PrintB implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(true) {
					B.acquire(1);
					System.out.println(2);
					C.release();
				}				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static class PrintC implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(true) {
					C.acquire(1);
					System.out.println(3);
					A.release();
				}				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread ta = new Thread(new PrintA());
		Thread tb = new Thread(new PrintB());
		Thread tc = new Thread(new PrintC());
		ta.start();
		tb.start();
		tc.start();
	}

}
