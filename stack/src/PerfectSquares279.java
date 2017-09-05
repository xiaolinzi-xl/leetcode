import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class PerfectSquares279 {
	public static int numSquares(int n) {
		LinkedList<Node> queue = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		visited[n] = true;
		queue.add(new Node(n, 0));
		
		// ͼ�Ĺ����������ͼ�����·�����ʺ���Ȩͼ
		while (!queue.isEmpty()) {
			Node node = queue.removeFirst();
			int num = node.num;
			int step = node.length;
			
			for(int i=1;;i++) {
				int a = num - i * i;
				if (a < 0) 
					break;
				if (a == 0) 
					return step + 1;
				if (!visited[a]) {
					queue.addLast(new Node(a, step+1));
					visited[a] = true;
				}
			}
		}
		return -1; // �쳣
	}
	
	public static void main(String[] args) {
//		System.out.println(numSquares(18));
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MyComp());
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			priorityQueue.add(random.nextInt(100));
		}
//		Ĭ���Ǵ�С����ģ�
		while(!priorityQueue.isEmpty()) {
			System.out.print(priorityQueue.poll() + " ");
		}
	}
}

class Node{
	int num;
	int length;
	public Node(int num,int length) {
		this.num = num;
		this.length = length;
	}
}

class MyComp implements Comparator<Integer>{
	@Override
	public int compare(Integer x, Integer y) {
//		return (x < y) ? -1 : ((x == y) ? 0 : 1);  // ����
		return (x < y) ? 1 : ((x == y) ? 0 : -1); // ����
	}
}