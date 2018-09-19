package medium;
/**
 * 223. 矩形面积
在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。

每个矩形由其左下顶点和右上顶点坐标表示，如图所示。

Rectangle Area

示例:

输入: -3, 0, 3, 4, 0, -1, 9, 2 输出: 45

说明: 假设矩形面积不会超出 int 的范围。
 * @author liang
 *
 */
public class RectangleArea_223 {

	/**
	 * 两个矩阵面积相加 再减去重复矩阵
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return
	 */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //得到重复矩阵的左下角和右上角
    	int left = Math.max(E, A);
    	int bottom = Math.max(F, B);
    	// 可能两个长方形分别位于左下右上
    	int right = Math.max(left, Math.min(G, C));
    	int top = Math.max(bottom, Math.min(D, H));
    	return (C-A)*(D-B) + (G-E)*(H-F) - (right-left)*(top-bottom);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
