package find;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class NumberOfBoomerangs {
	 public static int numberOfBoomerangs(int[][] points) {
		 int res = 0;
		 for(int i=0;i<points.length;i++){
			 HashMap<Integer, Integer> record = new HashMap<>();
			 for(int j=0;j<points.length;j++){
				 if (j != i) {
					int dis = (points[i][0]-points[j][0])* (points[i][0]-points[j][0])
							+ (points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
					if (record.containsKey(dis)) {
						record.put(dis, record.get(dis)+1);
					}else{
						record.put(dis, 1);
					}
				}
			 }
			 Set<Integer> keySet = record.keySet();
			 Iterator<Integer> it = keySet.iterator();
			 while(it.hasNext()){
				 int value = record.get(it.next());
				 res += (value)*(value-1);
			 }
		 }
		 return res;
	 }
	 
	 public static void main(String[] args) {
		int[][] arr = {{0,0},{1,0},{2,0}};
		System.out.println(numberOfBoomerangs(arr));
	}
}
