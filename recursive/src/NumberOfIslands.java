package recursive;

public class NumberOfIslands {
	// 搜索的顺序-----顺时针顺序
	private int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	private boolean[][] visited;
	
	public int numIslands(char[][] grid) {
		if(grid.length == 0)
            return 0;
		visited = new boolean[grid.length][grid[0].length];
		
		int res = 0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if (grid[i][j] == '1' && !visited[i][j]) {
					res++;
					dfs(grid, i, j);
				}
			}
		}
		return res;
	}
	
	public void dfs(char[][] grid,int x,int y) {
		visited[x][y] = true;
		
		for(int i=0;i<4;i++){
			int newx = x + d[i][0];
			int newy = y + d[i][1];
			
			if (newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length
					&& !visited[newx][newy] && grid[newx][newy]=='1') {
				dfs(grid, newx, newy);
			}
		}
		
		return;
	}
	
	
}
