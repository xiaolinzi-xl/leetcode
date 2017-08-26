package recursive;

import java.util.ArrayList;
import java.util.List;
/*
 * 回溯法的本质就是深度优先
 */
public class NQueen {
	
	private List<List<String>> res = new ArrayList<List<String>>();
	
	public List<List<String>> solveNQueens(int n) {
        
		List<Integer> row = new ArrayList<>();
		putQueen(n, 0, row);
		return res;
    }
	
//	在index行中摆放皇后的位置
	public void putQueen(int n,int index,List<Integer> row) {
		if (index == n) {
			res.add(generateBoard(index, row));
			return;
		}
//		尝试将第index行的皇后摆放在第i列
		for(int i=0;i<n;i++){
			int j;
			for(j=index-1;j>=0;j--){
				if (i==row.get(j) || Math.abs(index-j)==Math.abs(i-row.get(j))) {
					break;
				}
			}
			if (j<0) { // 满足条件，摆放下一个皇后
				row.add(i);
				putQueen(n, index+1, row);
				row.remove(Integer.valueOf(i)); // 回溯
			}
		}
		
	}
	
	public List<String> generateBoard(int n,List<Integer> row) {
		List<String> board = new ArrayList<>(n);
		for(int i=0;i<n;i++){
			StringBuilder sBuilder = new StringBuilder();
			for(int j=0;j<n;j++){
				if (j != row.get(i)) {
					sBuilder.append(".");
				}else {
					sBuilder.append("Q");
				}
			}
			board.add(sBuilder.toString());
		}
		return board;
	}
	
	public static void main(String[] args) {
		NQueen test =  new NQueen();
		System.out.println(test.solveNQueens(4));
	}
	
}
