package infixPostfix;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		
		String pattern = "a+b*c-d/e";
		String postfix = convertInfixToPostfix(pattern.toCharArray());
		System.out.println(postfix);

	}

	private static String convertInfixToPostfix(char[] pattern) {
		
		int l = pattern.length;
		
		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int i = 0;
		char c;
		while(i<l){
			c = pattern[i];
			
			if(isOperand(c)){
				result.append(c);
				i++;
			}
			else{
				if(stack.isEmpty() || pre(c) > pre(stack.peek()) ){
					stack.push(c);
					i++;
				}
				else{
					result.append(stack.pop());
				}
			}
		}
		
		while(!stack.isEmpty()){
			result.append(stack.pop());
		}
		return result.toString();
	}
	
	public static boolean isOperand(char c){
		if(c=='+' || c=='-' || c=='*' || c=='/'){
			return false;
		}
		return true;
	}
	
	
	//return the precedence of an operator
	public static int pre(char c){
		if(c=='+' || c=='-')
			return 1;
		if(c=='*' || c=='/')
			return 2;
		return 0;
	}

}
