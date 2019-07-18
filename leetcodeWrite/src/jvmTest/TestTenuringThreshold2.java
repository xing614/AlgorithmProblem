package jvmTest;

public class TestTenuringThreshold2 {
	private static final int _1MB = 1024 * 1024;
	/**
	 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15  -XX:+PrintTenuringDistribution
	 * 
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold2() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 4];   // allocation1+allocation2大于survivo空间一半
		allocation2 = new byte[_1MB / 4];  
		allocation3 = new byte[4 * _1MB];
		allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		allocation4 = new byte[4 * _1MB];
		
		/**
		 * [GC [DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 15)
- age   1:     680304 bytes,     680304 total
: 4951K->664K(9216K), 0.0033210 secs] 4951K->4760K(19456K), 0.0033442 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   1:        136 bytes,        136 total
: 4924K->0K(9216K), 0.0011772 secs] 9020K->4760K(19456K), 0.0011987 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 4260K [0x32750000, 0x33150000, 0x33150000)
  eden space 8192K,  52% used [0x32750000, 0x32b78fe0, 0x32f50000)
  from space 1024K,   0% used [0x32f50000, 0x32f50088, 0x33050000)
  to   space 1024K,   0% used [0x33050000, 0x33050000, 0x33150000)
 tenured generation   total 10240K, used 4760K [0x33150000, 0x33b50000, 0x33b50000)
   the space 10240K,  46% used [0x33150000, 0x335f60b0, 0x335f6200, 0x33b50000)
 compacting perm gen  total 12288K, used 377K [0x33b50000, 0x34750000, 0x37b50000)
   the space 12288K,   3% used [0x33b50000, 0x33bae5c0, 0x33bae600, 0x34750000)
    ro space 10240K,  55% used [0x37b50000, 0x380d1140, 0x380d1200, 0x38550000)
    rw space 12288K,  55% used [0x38550000, 0x38bf44c8, 0x38bf4600, 0x39150000)
		 */
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testTenuringThreshold2();
	}

}
