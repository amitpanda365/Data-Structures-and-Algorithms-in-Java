package implementations;

public class QueueUsingArray {

	private int size;
	private int front;
	private int rear;
	private int count;
	private int[] elements;
	
	public QueueUsingArray(int size){
		this.size = size;
		elements = new int[size];
		front = rear = 0;
	}
	
	public boolean enqueue(int ele) {
		if(isFull())
			System.out.println("Queue is full");
		rear = (rear + 1) % size;
		elements[rear] = ele;
		count ++;
		return true;
	}
	

	public int deQueue(){
		if(isEmpty())
			System.out.println("Queue is empty");
		int ele = elements[front];
		front = (front + 1) % size;
		count --;
		return ele;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return (rear + 1) % size == front;
	}
	
	public int size(){
		return count;
	}
}
