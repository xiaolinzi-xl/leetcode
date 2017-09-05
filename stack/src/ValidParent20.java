import java.util.Stack;

public class ValidParent20 {
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '['
					|| s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}else {
				if (stack.size() == 0) {
					return false;
				}
				char c = stack.pop();
				char match;
				if (s.charAt(i) == '}') {
					match = '{';
				}else if (s.charAt(i) == ')') {
					match = '(';
				}else {
					assert(s.charAt(i) == ']');
					match = '[';
				}
				if (c != match) {
					return false;
				}
			}
		}
		if (stack.size() != 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String string = "{[()]}";
		System.out.println(isValid(string));
	}
}
