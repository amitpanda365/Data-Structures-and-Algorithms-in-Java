package paranthesisMatching;

import basicOperations.GenericStack;

public class PM1 {

	public static void main(String[] args) {
		
		String pattern = "((a+b)*(a-b))";
		boolean b = isBalance(pattern.toCharArray());
		System.out.println(b);

	}

	private static boolean isBalance(char[] pattern) {
		
		int l = pattern.length;
		GenericStack<Character> stack = new GenericStack<>(l);
		
		for(int i=0; i<l; i++){
			if(pattern[i]=='(')
				stack.push(pattern[i]);
			if(pattern[i]==')'){
				if(stack.isEmpty())
					return false;
				stack.pop();
			}
				
		}
		return stack.isEmpty();
	}

}
