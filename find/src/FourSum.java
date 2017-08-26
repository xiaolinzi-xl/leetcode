package find;

import java.util.HashMap;

public class FourSum {
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D){
		HashMap<Integer, Integer> record = new HashMap<>();
		for(int i=0;i<C.length;i++){
			for(int j=0;j<D.length;j++){
				if (record.containsKey(C[i]+D[j])) {
					record.put(C[i]+D[j], record.get(C[i]+D[j])+1);
				}else{
					record.put(C[i]+D[j], 1);
				}
			}
		}
		int res = 0;
		for(int i=0;i<A.length;i++){
			for(int j=0;j<B.length;j++){
				if (record.containsKey(-A[i]-B[j])) {
					res += record.get(-A[i]-B[j]);
				}
			}
		}
		return res;
	}
}
