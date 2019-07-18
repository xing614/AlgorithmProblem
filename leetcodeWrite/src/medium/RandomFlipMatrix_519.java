package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 519. 随机翻转矩阵
 * 
 * @author liang
 *
 */
public class RandomFlipMatrix_519 {
	
	/**
	 * 结果不对 超过时间限制
	 */
	int rows;
	int cols;
	int totals;
	int[][] res;
	Random random;
	List set = new ArrayList();
    public RandomFlipMatrix_519(int n_rows, int n_cols) {
    	this.rows = n_rows;
    	this.cols = n_cols;
    	this.totals = n_cols*n_rows;
    	res = new int[rows][cols];
    	this.random = new Random();
    }
    
    public int[] flip() {
//       int pos = random.nextInt(this.totals-1);
//       while(set.contains(pos))
//    	   pos = random.nextInt(this.totals-1);
//       set.add(pos);
//       return new int[] {pos/this.cols,pos%this.cols};
    	int pos = random.nextInt(this.totals-1);
    }
    
    public void reset() {
    	for(int i =0;i<this.rows;i++) {
    		for(int j=0;j<this.cols;j++) {
    			this.res[i][j] = 0;
    		}
    	}
    }
}
