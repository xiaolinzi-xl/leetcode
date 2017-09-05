import java.util.ArrayList;
import java.util.List;
/**
 * 回溯法是暴力解法
 * @author xiaolinzi
 *
 */
public class LetterCombinations {
	
	static List<String> ans = new ArrayList<>();
	
//	0-9字符的映射
	private static final String[] letterMap = {" ","","abc","def","ghi","jkl","mno","pqrs",
					"tuv","wxvz"};
	
	
	public static List<String> letterCombinations(String digits) {
		if (digits.isEmpty()) {
			return ans;
		}
		findCombinations(digits, 0, "");
		return ans;
	}
	
	private static void findCombinations(String digits,int index,String s) {
		if (index == digits.length()) {
			ans.add(s);
			return;
		}
		char c = digits.charAt(index);
		assert(c>='0' && c<='9' && c!='1');
		String letters = letterMap[c-'0'];
		for(int i=0;i<letters.length();i++) {
			findCombinations(digits, index+1, s+letters.charAt(i));
		}
		return;
	}
	
	public static void main(String[] args) {
		String digits = "23";
	
		List<String> anStrings = letterCombinations(digits);
		System.out.println(anStrings.toString());
	}
}
