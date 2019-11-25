package infixPostfix;

import java.util.Stack;

public class InfixToPostfixStudChallenge {

	public static void main(String[] args) {
		
		String pattern = "((a*b)*c)/d^e^f-g^h";
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
				if(stack.isEmpty() || outStackPre(c) > inStackPre(stack.peek()) ){
					if(c != ')')
					stack.push(c);
					i++;
				}
				else{
					char t = stack.pop();
					if(t != '(')
						result.append(t);
				}
			}
		}
		
		while(!stack.isEmpty()){
			result.append(stack.pop());
		}
		return result.toString();
	}
	
	public static boolean isOperand(char c){
		if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^' || c=='(' || c==')'){
			return false;
		}
		return true;
	}
	
	
	//return the precedence of an operator outside stack
	public static int outStackPre(char c){
		if(c=='+' || c=='-')
			return 1;
		else if(c=='*' || c=='/')
			return 3;
		else if(c=='^')
			return 6;
		else if(c=='(')
			return 7;
		else if(c==')')
			return 0;
		
		return -1;
	}
	
	//return the precedence of an operator inside stack
	public static int inStackPre(char c){
		if(c=='+' || c=='-')
			return 2;
		else if(c=='*' || c=='/')
			return 4;
		else if(c=='^')
			return 5;
		else if(c=='(')
			return 0;
		
		return -1;
	}


}
