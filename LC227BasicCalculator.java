import java.util.*;

public class LC227BasicCalculator {
	public int calculate(String s) {
		Stack<Integer> numStack = new Stack();
		Stack<Character> operStack = new Stack();

		int i = 0;
		while(i < s.length()) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {
				StringBuffer sb = new StringBuffer();
				while(i < s.length() && Character.isDigit(s.charAt(i))) {
					sb.append(s.charAt(i));
					i++;
				}
				numStack.push(Integer.parseInt(sb.toString()));
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				operStack.push(c);
				i++;
			} else {
				i++;
			}

		}

		int operand1 = 0;
		int operand2 = 0;
		int result = 0;
		while(operStack.size() > 0) {
			char c = operStack.pop();
			if(c == '+') {
				operand1 = numStack.pop();
				operand2 = numStack.pop();
				result = operand1 + operand2;
				numStack.push(result);
			} else if(c == '-') {
				operand1 = numStack.pop();
				operand2 = numStack.pop();
				result = operand1 - operand2;
				numStack.push(result);
			} else if(c == '*') {
				operand1 = numStack.pop();
				operand2 = numStack.pop();
				result = operand1 * operand2;
				numStack.push(result);
			} else if(c == '/') {
				operand1 = numStack.pop();
				operand2 = numStack.pop();
				result = operand2 / operand1;
				numStack.push(result);
			}
		}

		result = numStack.pop();
		return result;
	}
	
	public static void main(String args[]) {
		LC227BasicCalculator obj = new LC227BasicCalculator();
		System.out.println(obj.calculate("3+5 /2"));
	}
}

