package openHashing;

public class LinkedList {

	Node first;
	private int count;

	private class Node {
		private int ele;
		private Node next;

		Node(int ele) {
			this.ele = ele;
			count++;
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

	public boolean delete(int ele) {

		if (first == null)
			return false;

		if (first.ele == ele) {
			count --;
			if (first.next == null) {
				first = null;
				return true;
			} else {
				first = first.next;
				return true;
			}
		}

		Node p = first;
		Node q = null;
		while (p != null && p.ele <= ele) {
			q = p;
			p = p.next;
			if (p == null) {
				q.next = null;
				count --;
				return true;
			}
			if (p.ele == ele) {
				q.next = p.next;
				count--;
				return true;
			}
		}
		return false;
	}

	public boolean search(int ele) {

		if (first == null)
			return false;

		Node p = first;

		while (p != null && p.ele <= ele) {

			if (p.ele == ele)
				return true;
			p = p.next;

		}
		return false;
	}
}
