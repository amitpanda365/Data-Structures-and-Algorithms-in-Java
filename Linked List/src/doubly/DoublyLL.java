package doubly;

public class DoublyLL {
	
	class Node {
		Node prev;
		int ele;
		Node next;
		
		Node(int ele){
			this.ele = ele;
			count++;
		}
		
	}
	
	Node first;
	Node last;
	int count;
	
	public void create(int[] arr){
		
		if(arr.length == 0)
			return;
		first= new Node(arr[0]);
		last = first;
		
		Node t;
		
		for(int i=1; i<arr.length; i++){
			t = new Node(arr[i]);
			t.prev = last;
			last.next = t;
			last = last.next;
		}
	}
	
	public void insert(int ele){
		if(first == null){
			first= new Node(ele);
			last = first;
			return;
		}
		
		Node t = new Node(ele);
		last.next = t;
		t.prev = last;
		last = last.next;
	}
	
	public void insert(int ele, int index){
		
		if(index < 0 || index > count)
			throw new IndexOutOfBoundsException();
		Node t = new Node(ele);
		if(index == 0){
			t.next = first;
			first.prev = t;
			first = t;
			return;
		}
		
		Node p = first;
		for(int i=0; i<index-1; i++){
			p = p.next;
		}
		
		Node q = p.next;
		p.next = t;
		t.prev = p;
		if(q!=null){
			t.next = q;
			q.prev = t;
		}
		else{
			last =t;
		}
		
	}
	
	public void delete(int index){
		
		if(index >= count)
			throw new IndexOutOfBoundsException();
		if(index == 0) {
			if(first.next == null){
				first =null;
			}
			else {
				first = first.next;
				first.prev = null;
			}
			return;
		}
		else {
			Node p = first;
			for(int i=0; i < index; i++){
				p = p.next;
			}
			
			p.prev.next = p.next;
			if(p.next != null){
				p.next.prev = p.prev;
			}
			else {
				last = p.prev;
			}
			
		}
			
	}
	
	public void reverse(){
		Node p = first;
		
		while(p!=null){
			
			if(p.next == null){
				first = p;
			}
			if(p.prev == null){
				last = p;
			}
			Node t = p.next;
			p.next = p.prev;
			p.prev = t;
			p = p.prev;
			
			
		}
	}
	
	public void display(){
		System.out.println(first.ele +" "+last.ele);
		Node p = first;
		while(p!=null){
			System.out.print(p.ele+" ");
			p = p.next;
		}
		
	}

}
