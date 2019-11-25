package basicOperations;

public class StackUsingArray {
	
	private int size;
	private int top;
	private int[] elements;
	
	public StackUsingArray(int size){
		this.size = size;
		elements = new int[size];
		top = -1;
	}
	
	public void push(int ele){
		if(isFull())
			throw new IndexOutOfBoundsException();
		elements[++top] = ele;
	}
	
	public int pop(){
		if(isEmpty())
			throw new IndexOutOfBoundsException();
		int x = elements[top];
		elements[top--]=0;
		return x;
	}
	
	public int peek(){
		if(isEmpty())
			throw new IndexOutOfBoundsException();
		
		return elements[top];
	}
	
	public int peek(int index){
		if(isEmpty() || index>top)
			throw new IndexOutOfBoundsException();
		return elements[top-index];
		
	}
	
	public boolean isFull(){
		return top == size-1;
	}
	
	public boolean isEmpty(){
		return top == -1;
	}

	@Override
	public String toString() {
		if(isEmpty())
			return "[]";
		
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for(int i=0;i<top;i++){
			sb.append(elements[i]);
			sb.append(',');
		}
		sb.append(elements[top]);
		sb.append(']');
		
		return sb.toString();
	}

}
