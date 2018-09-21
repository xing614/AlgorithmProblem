package medium;
/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * @author liang
 *
 */
public class SpiralMatrix2_59 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n==0) return res;
        int x= 0,y=0;
        int val = 1;
        while(n>0) {
        	if(n==1) {//当n最初是奇数时才有可能出现，然后这是最中心位置了
        		res[x][y] = val;
        		break;
        	}
        	for(int i=0;i<n-1;i++) {
        		res[x][y++] = val++;
        	}
        	for(int i=0;i<n-1;i++) {
        		res[x++][y] = val++;
        	}
        	for(int i=0;i<n-1;i++) {
        		res[x][y--] = val++;
        	}
        	for(int i=0;i<n-1;i++) {
        		res[x--][y] = val++;
        	}
        	n -= 2;//一轮会上下左右各走一遍，就-2
        	x++;//经过一轮回到原地后想右下移动一位
        	y++;
        }
        return res;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
