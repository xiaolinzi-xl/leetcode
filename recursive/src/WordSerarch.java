package recursive;

public class WordSerarch {
	
	private int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	private boolean[][] visited;
	
	public boolean exist(char[][] board, String word) {
		
		visited = new boolean[board.length][board[0].length];
		
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if (searchWord(board, word, 0, i, j)) {
					return true;
				}
        	}
        }
        return false;
    }
	
//	从board[startx][starty]开始搜索，匹配word[index,word.size())
	private boolean searchWord(char[][] board,String word,int index,int startx,int starty) {
		if (index == word.length()-1) {
			return board[startx][starty] == word.charAt(index);
		}
		if (board[startx][starty] == word.charAt(index)) {
			visited[startx][starty] = true;
//			从[startx][starty]出发，四个方向
			for(int i=0;i<4;i++){
				int newx = startx + d[i][0];
				int newy = starty + d[i][1];
				if (newx<board.length && newx>=0 && newy>=0 && newy<board[0].length 
						&& !visited[newx][newy] && searchWord(board, word, index+1, newx, newy)) {
					return true;
				}
			}
			visited[startx][starty] = false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'a','a'}};
		String word = "aaa";
		WordSerarch test = new WordSerarch();
		System.out.println(test.exist(board, word));
	}
	
}
