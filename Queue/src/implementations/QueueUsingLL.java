package implementations;


public class QueueUsingLL {
	
	private Node front;
	private Node rear;
	private int count;
	
	private class Node {
		int ele;
		Node next;
		
		Node(int ele){
			this.ele = ele;
		}
	}
	
	public void enQueue(int ele){
		if(front == null){
			front = new Node(ele);
			rear = front;
			return;
		}
		
		rear.next = new Node(ele);
		rear = rear.next;
		return;
	}
	
	public int deQueue(){
		
		if(isEmpty()){
			System.out.println("Queue is empty");
		}
		
		int ele = front.ele;
		front = front.next;
		return ele;
		
	}

	public boolean isEmpty() {
		return front == null;
	}
	
	

}
