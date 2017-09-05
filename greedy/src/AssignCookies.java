/**
 * 贪心算法
 */
import java.util.Arrays;

public class AssignCookies {
	
	public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int res = 0;
        
        for(int i=0;i<s.length&&res<g.length;i++){
        	if (s[i] >= g[res]) {
				res++;
			}
        }
        return res;
    }
	
}
