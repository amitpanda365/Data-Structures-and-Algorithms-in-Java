package infixPostfix;

import java.util.Stack;

public class PostfixToInfix {

	public static void main(String[] args) {
		
		String postfix = "35*62/+4-";
		int res = evaluate(postfix.toCharArray());
		System.out.println(res);

	}

	private static int evaluate(char[] postfix) {
		int x1, x2, res;		
		int l = postfix.length;
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<l; i++){
			if(isOperand(postfix[i]))
				stack.push((int)postfix[i]-48);
			else{
				x2 = stack.pop();
				x1 = stack.pop();
				switch(postfix[i]){
				case '+' : res = x1 + x2; stack.push(res); break;
				case '-' : res = x1 - x2; stack.push(res); break;
				case '*' : res = x1 * x2; stack.push(res); break;
				case '/' : res = x1 / x2; stack.push(res); break;
				}
			}
		}
		return stack.pop();
	}
	
	public static boolean isOperand(char c){
		if(c=='+' || c=='-' || c=='*' || c=='/'){
			return false;
		}
		return true;
	}
	

}
