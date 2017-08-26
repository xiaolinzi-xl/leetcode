package array;

import java.util.ArrayList;
import java.util.List;

public class FindAgrams {
	public static List<Integer> find(String s,String p) {
		List<Integer> ans = new ArrayList<>();
		for(int i=0;i<=s.length()-p.length();i++){
			String tmp = s.substring(i, i + p.length());
			int[] num = new int[26];
		    for(int j=0;j<p.length();j++){
		    	num[p.charAt(j)-'a']++;
	    	}
			int len = 0;
			for(int j=0;j<tmp.length();j++){
				if(num[tmp.charAt(j)-'a'] > 0){
				    num[tmp.charAt(j)-'a']--;
				    len++;
				}
			}
			if (len == p.length()) {
				ans.add(i);
			}
		}
		return ans;
	}
}
