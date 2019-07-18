package jvmTest;

public class TestHandlePromotion {

	private static final int _1MB = 1024 * 1024;
	/**
	 * VM参数：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
	 */
	@SuppressWarnings("unused")
	public static void testHandlePromotion() {
		byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation1 = null;
		allocation4 = new byte[2 * _1MB];
		allocation5 = new byte[2 * _1MB];
		allocation6 = new byte[2 * _1MB];
		allocation4 = null;
		allocation5 = null;
		allocation6 = null;
		allocation7 = new byte[2 * _1MB];
		
		/**
		 * 
		
		java.version = 1.6.0_37
		
		
		[GC [DefNew: 6487K->152K(9216K), 0.0040346 secs] 6487K->4248K(19456K), 0.0040639 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew: 6546K->152K(9216K), 0.0004896 secs] 10642K->4248K(19456K), 0.0005141 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 2364K [0x32750000, 0x33150000, 0x33150000)
  eden space 8192K,  27% used [0x32750000, 0x32978fe0, 0x32f50000)
  from space 1024K,  14% used [0x32f50000, 0x32f76108, 0x33050000)
  to   space 1024K,   0% used [0x33050000, 0x33050000, 0x33150000)
 tenured generation   total 10240K, used 4096K [0x33150000, 0x33b50000, 0x33b50000)
   the space 10240K,  40% used [0x33150000, 0x33550020, 0x33550200, 0x33b50000)
 compacting perm gen  total 12288K, used 377K [0x33b50000, 0x34750000, 0x37b50000)
   the space 12288K,   3% used [0x33b50000, 0x33bae758, 0x33bae800, 0x34750000)
    ro space 10240K,  55% used [0x37b50000, 0x380d1140, 0x380d1200, 0x38550000)
    rw space 12288K,  55% used [0x38550000, 0x38bf44c8, 0x38bf4600, 0x39150000)
Warning: The flag -HandlePromotionFailure has been EOL'd as of 6.0_24 and will be ignored
		 */
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testHandlePromotion();
	}

}
