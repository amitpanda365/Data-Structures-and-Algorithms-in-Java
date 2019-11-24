package circular;

public class CircularLL {

	public int count;
	public Node head;
	public Node last;

	class Node {

		public Node next;
		public int ele;

		public Node(int ele) {
			this.ele = ele;
			count++;
		}

		@Override
		public String toString() {
			return "Node [next=" + next + ", ele=" + ele + "]";
		}

	}

	public void insert(int ele) {

		if (head == null) {
			head = new Node(ele);
			last = head;
			head.next = head;
			return;
		}

		last.next = new Node(ele);
		last = last.next;
		last.next = head;

	}

	public void insert(int ele, int index) {

		if (index < 0 || index >= count)
			throw new IndexOutOfBoundsException();
		if (index == 0) {
			Node p = last.next = new Node(ele);
			p.next = head;
			head = p;
			return;
		}
		Node p = head;
		for (int i = 0; i < index - 1; i++) {
			p = p.next;
		}

		Node q = p.next;
		System.out.println("hi");
		p.next = new Node(ele);
		p = p.next;
		p.next = q;

	}

	public void delete(int index) {
		if (index < 0 || index >= count)
			throw new IndexOutOfBoundsException();

		if (index == 0) {
			if (count == 1) {
				head = null;
				last = null;
			} else {
				last.next = last.next.next;
				head = last.next;
				count--;
			}
			return;
		}

		Node p = head;
		for (int i = 0; i < index - 1; i++) {
			p = p.next;
		}
		if (index == count - 1)
			last = p;
		p.next = p.next.next;
		count--;
	}

	public void create(int[] arr) {
		int l = arr.length;
		if (l == 0)
			return;
		head = new Node(arr[0]);
		last = head;

		for (int i = 1; i < l; i++) {
			last.next = new Node(arr[i]);
			last = last.next;
		}

		last.next = head;
	}

	public void display() {
		System.out.println(head);
		if (head != null)
			display(head);
		else
			System.out.println("[]");
	}

	private void display(Node p) {

		do {
			System.out.print(p.ele + " ");
			p = p.next;
		} while (p != head);

	}

	public void displayRcursively() {
		displayRcursively(head);
	}

	static int flag = 0;

	private void displayRcursively(Node p) {

		if (p != head || flag == 0) {
			flag = 1;
			System.out.print(p.ele + " ");
			displayRcursively(p.next);
		}
		flag = 0;
	}
}
