package singly;


public class SinglyLinkedList {

	Node first;
	Node last;
	private int count;

	private class Node {
		private int ele;
		private Node next;

		Node(int ele) {
			this.ele = ele;
			count++;
		}

	}

	public boolean add(int ele) {

		if (first == null) {
			first = last = new Node(ele);
			return true;
		}

		last.next = new Node(ele);
		last = last.next;
		return true;
	}

	public int findMax() {
		if (first == null)
			return -1;
		Node p = first.next;
		int max = first.ele;
		while (p != null) {
			if (p.ele > max)
				max = p.ele;
			p = p.next;
		}

		return max;
	}

	public int findMaxUsingRecursion() {
		return findMaxUsingRecursion(first);
	}

	private int findMaxUsingRecursion(Node n) {

		if (n == null)
			return -1;

		int x = findMaxUsingRecursion(n.next);

		return x > n.ele ? x : n.ele;
	}

	public void display() {
		displayRecursively(first);
		System.out.println();
	}

	public void displayReverse() {
		displayReverseRecursively(first);
		System.out.println();
	}

	private void displayReverseRecursively(Node n) {
		if (n != null) {
			displayReverseRecursively(n.next);
			System.out.print(n.ele + " ");
		}
	}

	private void displayRecursively(Node n) {
		if (n != null) {
			System.out.print(n.ele + " ");
			displayRecursively(n.next);
		}
	}

	public String toString() {
		if (count == 0)
			return "[]";
		Node p = first;
		String s = "[";
		for (int i = 0; i < count - 1; i++) {
			s += p.ele + ", ";
			p = p.next;
		}
		s += p.ele + "]";
		return s;

	}

	public boolean search(int ele) {

		if (first == null)
			return false;

		Node p = first;
		while (p != null) {
			if (p.ele == ele) {
				return true;
			}

			p = p.next;

		}
		return false;
	}

	public boolean searchAndMoveToHead(int ele) {

		if (first == null)
			return false;

		Node p1 = first;
		Node p2 = null;

		while (p1 != null) {
			if (p1.ele == ele) {
				p2.next = p1.next;
				p1.next = first;
				first = p1;
				return true;
			}

			p2 = p1;
			p1 = p1.next;

		}
		return false;
	}

	public int size() {
		return count;
	}

	public boolean insert(int ele, int index) {

		if (index > size() || index < 0)
			throw new IndexOutOfBoundsException(index + "");

		Node n = new Node(ele);

		if (index == 0) {
			n.next = first;
			first = n;
			return true;
		} else {
			Node p = first;
			for (int i = 0; i < index - 1; i++) {
				p = p.next;
			}

			n.next = p.next;
			p.next = n;
			// last.next = n;
			return true;
		}

	}

	public boolean insertInSortedList(int ele) {
		Node n = new Node(ele);
		Node p = first;
		Node q = count == 1 ? p : null;

		if (first == null) {
			first = n;
			return true;
		}
		if (p.ele > ele) {
			first = n;
			first.next = p;
			return true;
		}
		while (p != null && p.ele < ele) {
			q = p;
			p = p.next;
		}
		q.next = n;
		n.next = p;
		return true;
	}

	public void removeDuplicates() {
		Node p = first;
		Node q = p.next;

		while (q != null) {
			if (p.ele != q.ele) {
				p = q;
				q = q.next;
			} else {
				p.next = q.next;
				q = q.next;
				count--;
			}
		}
	}

	public void createList(int[] arr) {
		if (arr.length == 0)
			return;
		first = new Node(arr[0]);
		last = first;

		for (int i = 1; i < arr.length; i++) {
			last.next = new Node(arr[i]);
			last = last.next;
		}
	}

	public boolean isLoop() {
		int c = 0;
		Node p = first;
		Node q = first.next;
		while (q != null) {
			c++;
			p = p.next;
			q = q.next;
			q = q.next;
			if (p == q) {
				System.out.println(c);
				return true;
			}
		}

		return false;
	}

	public void reverse() {
		Node p = null;
		Node q = null;
		Node r = first;

		while (r != null) {
			p = q;
			q = r;
			r = r.next;
			q.next = p;
		}
		last = first;
		first = q;
	}

	public void reverseUsingRecursion() {
		reverseUsingRecursion(null, first);
	}

	public void reverseUsingRecursion(Node p, Node q) {

		if (q != null) {
			reverseUsingRecursion(q, q.next);
			q.next = p;
			last = q;
		} else {
			first = p;
		}

	}

}
