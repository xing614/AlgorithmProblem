package medium;
/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
 * @author liang
 *
 */
public class WordSearch {

	/**
	 * 使用DFS搜索上下左右四个角就行了，由于不能重复使用，所以要用一个数组isUsed来存储是否已经遍历过了
	 * @param board
	 * @param word
	 * @return
	 */
    public static boolean exist(char[][] board, String word) {
    	if (word.length() == 0) return true;
        if (board.length == 0 || board[0].length == 0) return false;
        boolean[][] isUsed = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfsSearchWord(board, word, 0, i, j, isUsed)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean dfsSearchWord(char[][] board, String word,
        int depth, int row, int col, boolean[][] isUsed) {
		if (depth == word.length()) return true;
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
		if (isUsed[row][col]) return false;
		if (board[row][col] != word.charAt(depth)) return false;
		isUsed[row][col] = true;
		boolean result = dfsSearchWord(board, word, depth + 1, row - 1, col, isUsed)
		|| dfsSearchWord(board, word, depth + 1, row + 1, col, isUsed)
		|| dfsSearchWord(board, word, depth + 1, row, col - 1, isUsed)
		|| dfsSearchWord(board, word, depth + 1, row, col + 1, isUsed);
		//搜索上下左右四个角
		isUsed[row][col] = false;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] boo = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(boo.length);
		System.out.println(boo[0].length);
		System.out.println(exist(boo,"ABCCED"));
	}

}
