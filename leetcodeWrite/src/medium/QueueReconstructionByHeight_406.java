package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * @author liang
 *
 */
public class QueueReconstructionByHeight_406 {

	/**
	 * 贪心算法
	 * (1)首先找到身高最高的人并对他们进行排序。
	 * (2)然后找到身高次高的人，按照他们的前面的人数把他们插入到最高的人群中。
	 * 因此这是一个排序和插入的过程，按照身高进行降序排序，然后把身高相同的人按照k进行升序排序。每次取出身高相同的一组人，按照k值把他们插入到队列中。
	 * @param people
	 * @return
	 */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int []>() {

        	//按身高降序排序 即h大的在前面，按k升序排列 即k小的在前面
			@Override
			public int compare(int[] a, int[] b) {
				// TODO Auto-generated method stub
				if(a[0]!=b[0])
					return -a[0]+b[0];
				else	//如果两人身高相同，则k小的在前面
					return a[1]-b[1];
			}
        	
		});
        
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<people.length;i++) {
        	int[] peop = people[i];
        	res.add(peop[1],peop);//位置，元素
        }
        
        return res.toArray(new int[people.length][]);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
