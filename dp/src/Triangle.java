import java.util.List;
/**
 * 题目描述：从顶层走到底层，求路径和最小。要求只能走邻近的路。
 * @author xiaolinzi
 *
 * 解答：f(i,j)表示从i，j位置出发的最短路径和。
 * f(i,j) = min{f(i+1,j),f(i+1,j+1)} + (i,j)
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		for(int i=triangle.size()-2;i>=0;i--){
			for(int j=0;j<triangle.get(i).size();j++){
				int oldValue = triangle.get(i).get(j);
				triangle.get(i).set(j,Math.min(triangle.get(i+1).get(j), 
						triangle.get(i+1).get(j+1))+oldValue);
			}
		}
		return triangle.get(0).get(0);
	}
}
