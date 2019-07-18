package jvmTest;

/**
 * VM Args:-Xss128k,减少栈内存容量
 * 如果线程请求的栈深度大于虚拟机所允许的最大深度，抛出StackOverflowError
 * @author liang
 *
 */
public class JavaVMStackSOF {

	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		}catch(Throwable e) {
			System.out.println("stack lengTh:"+oom.stackLength);
			throw e;
		}
	}

}
