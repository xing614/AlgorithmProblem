package jvmTest;

public class TestPretenureSizeThreshold {
	private static final int _1MB = 1024 * 1024;
	/**
	 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
	 * 对象超过3M 时直接进入老年代
	 */
	public static void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[4 * _1MB];  //直接分配在老年代中
		
		/**
		 Heap
 def new generation   total 9216K, used 507K [0x32750000, 0x33150000, 0x33150000)
  eden space 8192K,   6% used [0x32750000, 0x327cef38, 0x32f50000)
  from space 1024K,   0% used [0x32f50000, 0x32f50000, 0x33050000)
  to   space 1024K,   0% used [0x33050000, 0x33050000, 0x33150000)
 tenured generation   total 10240K, used 4096K [0x33150000, 0x33b50000, 0x33b50000)
   the space 10240K,  40% used [0x33150000, 0x33550010, 0x33550200, 0x33b50000)
 compacting perm gen  total 12288K, used 376K [0x33b50000, 0x34750000, 0x37b50000)
   the space 12288K,   3% used [0x33b50000, 0x33bae3b8, 0x33bae400, 0x34750000)
    ro space 10240K,  55% used [0x37b50000, 0x380d1140, 0x380d1200, 0x38550000)
    rw space 12288K,  55% used [0x38550000, 0x38bf44c8, 0x38bf4600, 0x39150000)
		  
		  
		  
		 */
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testPretenureSizeThreshold();
	}

}
