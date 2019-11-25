package basicOperations;

public class StackUsingLL {
	
	Node top;
	
	private class Node{
		int ele;
		Node next;
		
		Node(int ele){
			this.ele = ele;
		}
	}
	
	public void push(int ele){
		
		Node t = new Node(ele);
		t.next = top;
		top = t;
		t = null;
	}
	
	public boolean isFull(){
		Node t = new Node(1);
		return t==null;
	}
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return -1;
		}
		int x = top.ele;
		top = top.next;
		return x;
	}
	
	public int peek(){
		if(isEmpty())
			return -1;
		return top.ele;
		
	}
	
	public int peek(int index){
		if(index < 1)
			return -1;
		
		Node p = top;
		for(int i=1; p!=null && i < index; i++){
			p = p.next;
		}
		
		if(p!=null)
			return p.ele;
		else
			return -1;
		
	}

	@Override
	public String toString() {
		if(isEmpty()){
			return "[]";
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append('[');
		Node p = top;
		
		while(p.next != null){
			sb.append(p.ele);
			sb.append(',');
			p = p.next;
		}
		
		sb.append(p.ele);
		sb.append(']');
		
		return sb.toString();
		
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	

}
