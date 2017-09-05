import java.util.Arrays;
import java.util.HashSet;

public class LongestSub {
	public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0){
            return 0;
        }
        int[] num = new int[s.length()];
        for(int i=0;i<num.length;i++)
            num[i] = 1;
        for(int i=0;i<s.length();i++){
            HashSet<Character> count = new HashSet<>();
            count.add(s.charAt(i));
            for(int j=i+1;j<s.length();j++){
                if(!count.contains(s.charAt(j))){
                    num[i]++;
                    count.add(s.charAt(j));
                }else{
                    break;
                }
            }
        }
        Arrays.sort(num);
        return num[num.length-1];
	}
	
	public static int lengthOfLongestSubstring2(String s){
		int[] freq = new int[256];
		int l = 0,r = -1; // s[l,r]Ϊ��������
		int res = 0;
		
		while(l < s.length()){
			if (r+1<s.length() && freq[s.charAt(r+1)] == 0) {
				freq[s.charAt(++r)]++;
			}else{
				freq[s.charAt(l++)]--;
			}
			res = Math.max(res, r-l+1);
		}
		return res;
	}
}
