import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//import java.util.Queue;
import java.util.Scanner;

public class Tiaoshiban {
	
	public static int[] marked = new int[100001];
	
	public static List<Integer> yueshu(int n) {
        List<Integer> list = new ArrayList<>();
		for(int i=(int) Math.sqrt(n);i>1;i--){
			if (n % i == 0) {
				list.add(i);
				if (n/i != i) {
					list.add(n/i);
				}
			}
		}
		return list;
	}
    
//    public static int search(int n,int m,int count){
//        if(n > m)
//            return Integer.MAX_VALUE;
//        if(n == m){
//            return count;
//        }
//        int ans = Integer.MAX_VALUE;
//        List<Integer> list = yueshu(n);
//        for(int i=0;i<list.size();i++){
//            ans = Math.min(search(n+list.get(i),m,count+1),ans);
//        }
//        return ans;
//    }
    
//	70%通过率
    public static void search2(int n,int m,int count){
//        if(marked[n] != Integer.MAX_VALUE){
//            marked[n] = Math.min(marked[n], count);
//            return ;
//        }
        List<Integer> list = yueshu(n);
        int len = list.size();
        for(int i=0;i<len;i++){
        	int x = list.get(i);
        	if (n+x < m) {
        		if (marked[n+x] != Integer.MAX_VALUE) {
					marked[n+x] = Math.min(marked[n+x],marked[n] + 1);
				}else {
					marked[n+x] = count + 1;
				}
        		search2(n+x, m, count+1);
			}else if (n+x == m) {
				marked[n+x] = Math.min(marked[n+x], marked[n]+1);
				return;
			}else {
				continue;
			}
        }
    }
    
    public static int search(int n,int m){
        int[] visited = new int[m+1];
        Arrays.fill(visited,m+1);
        visited[n] = 0;
        for(int i=n;i<m;i++){
            if(visited[i] == m+1)
                continue;
            List<Integer> yueshu = yueshu(i);
            for(int j=0;j<yueshu.size();j++){
                int tmp = i + yueshu.get(j);
                int count = visited[i] + 1;
                if(tmp<=m){
                    visited[tmp] = Math.min(count,visited[tmp]);
                }
            }
        }
        if(visited[m] == m+1)
            return -1;
        return visited[m];
    }
    
    
//    基于广度优先搜索
    public static int search3(int n,int m){
    	 if(n == m)
             return 0;
    	LinkedList<Shiban> queue = new LinkedList<>();
    	queue.add(new Shiban(n, 0));
    	boolean[] visited = new boolean[m+1];
    	while (!queue.isEmpty()) {
			Shiban node = queue.removeFirst();
			List<Integer> list = yueshu(node.n);
			for(int i=0;i<list.size();i++){
				int tmp = node.n + list.get(i);
				if (tmp > m) {
					continue;
				}
				if (tmp == m) {
					return node.length + 1;
				}
				if (!visited[tmp]) {
					queue.addLast(new Shiban(tmp, node.length+1));
					visited[tmp] = true;
				}
			}
		}
    	return -1;
    }
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.close();
//		Arrays.fill(marked,Integer.MAX_VALUE);
//		marked[n] = 0;
//		search2(n, m, 0);
//		if(marked[m] == Integer.MAX_VALUE){
//            System.out.println(-1);
//            return ;
//        }
//        System.out.println(marked[m]);
//		for(int i=n;i<=m;i++){
//			System.out.print(marked[i] + " ");
//		}
//		System.out.println(search(n, m));
		System.out.println(search3(n, m));
//		System.out.println(yueshu(16));
	}
}

class Shiban{
	public int n;
	public int length;
	
	public Shiban(int n,int length){
		this.n = n;
		this.length = length;
	}
}
