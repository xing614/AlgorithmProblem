package other;

public class ClassLoadingLearn {

	private static ClassLoadingLearn cl = new ClassLoadingLearn();	
	public static int t0;
	public static int t1 = 0;

	private ClassLoadingLearn() {
		t0++;
		t1++;
	}
	
	public static ClassLoadingLearn get () {
		return cl;
	}
	
	public static void main(String[] args) {
		ClassLoadingLearn cl = ClassLoadingLearn.get();
		System.out.println(t0);//return 1
		System.out.println(t1);//return 0
	}

}
