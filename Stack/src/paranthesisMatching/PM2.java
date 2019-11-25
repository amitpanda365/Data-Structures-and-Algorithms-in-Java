package paranthesisMatching;

import basicOperations.GenericStack;

public class PM2 {

	public static void main(String[] args) {
		
		String pattern = "{[a+b]*(a-b]}";
		boolean b = isBalance(pattern.toCharArray());
		System.out.println(b);
		
	}

	private static boolean isBalance(char[] pattern) {
		int l = pattern.length;
		GenericStack<Character> stack = new GenericStack<>(l);
		
		for(int i=0; i<l; i++){
			if(pattern[i]=='(' || pattern[i]=='[' || pattern[i]=='{' )
				stack.push(pattern[i]);
			if(pattern[i]==')' || pattern[i]==']' || pattern[i]=='}'){
				if(stack.isEmpty())
					return false;
				char c = stack.pop();
				
				int x = pattern[i] - c;
				if(x==1 || x==2);
				else
					return false;
			}
				
		}
		return stack.isEmpty();
	}

}
