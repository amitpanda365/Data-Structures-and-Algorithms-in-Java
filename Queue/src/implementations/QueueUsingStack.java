package implementations;

import java.util.Stack;

public class QueueUsingStack {
	
	private Stack<Integer> s1;
	private Stack<Integer> s2;
	private int count;
	public QueueUsingStack() {
		s1 = new Stack();
		s2 = new Stack();
		count = 0;
	}

	public void enQueue(int ele){
		s1.push(ele);
		count ++;
	}
	
	public int deQueue(){
		if(s2.isEmpty()){
			if(s1.isEmpty()){
				System.out.println("stack is empty");
				return -1;
			}
			else {
				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}
			}
		}
		
		count --;
		return s2.pop();
	}
	
	
	public boolean isEmpty(){
		return s2.isEmpty() && s1.isEmpty();
	}		

}
   