import java.util.Stack;

public class BinarySeacrhTree {

	public Node root;

	class Node {
		Node leftChild;
		int ele;
		Node rightChild;

		Node(int ele) {
			this.ele = ele;
		}
	}

	public Node insert(Node p, int key) {

		if (p == null) {
			Node t = new Node(key);
			return t;
		}
		if (key < p.ele)
			p.leftChild = insert(p.leftChild, key);
		else if (key > p.ele)
			p.rightChild = insert(p.rightChild, key);
		return p;
	}

	public Node search(Node t, int key) {

		while (t != null) {
			if (t.ele == key)
				return t;
			else if (t.ele > key)
				t = t.leftChild;
			else
				t = t.rightChild;
		}

		return null;
	}

	int height(Node p) {
		if (p == null)
			return 0;
		int x = height(p.leftChild);
		int y = height(p.rightChild);

		return x > y ? x + 1 : y + 1;
	}

	Node inPredecessor(Node p) {
		while (p != null && p.rightChild != null)
			p = p.rightChild;
		return p;
	}

	Node inSuccessor(Node p) {
		while (p != null && p.leftChild != null)
			p = p.leftChild;
		return p;
	}

	public void pre(Node p) {
		if (p != null) {
			System.out.println(p.ele);
			pre(p.leftChild);
			pre(p.rightChild);
		}
	}

	Node delete(Node p, int key) {

		Node q = null;

		if (p == null)
			return null;

		if (p.leftChild == null && p.rightChild == null && p.ele == key)
			return null;

		if (key < p.ele)
			p.leftChild = delete(p.leftChild, key);

		else if (key > p.ele)
			p.rightChild = delete(p.rightChild, key);

		else {
			if (height(p.leftChild) > height(p.rightChild)) {
				q = inPredecessor(p.leftChild);
				p.ele = q.ele;
				p.leftChild = delete(p.leftChild, q.ele);
			} else {
				q = inSuccessor(p.rightChild);
				p.ele = q.ele;
				p.rightChild = delete(p.rightChild, q.ele);
			}

		}

		return p;
	}

	public void generateBSTfromPre(int[] pre) {

		int length = pre.length;

		if (length == 0)
			return;

		root = new Node(pre[0]);
		Stack<Node> stack = new Stack<>();
		int i = 1;
		Node p = root;

		while (i < length) {

			if (pre[i] < p.ele) {
				p.leftChild = new Node(pre[i]);
				stack.push(p);
				p = p.leftChild;
				i++;
			} else {
				if (stack.isEmpty() || (pre[i] > p.ele && pre[i] < stack.peek().ele)) {
					p.rightChild = new Node(pre[i]);
					p = p.rightChild;
					i++;
				} else
					p = stack.pop();
			}

		}

	}

	public void generateBSTfromPost(int[] post) {
		int length = post.length;
		if (length == 0)
			return;

		int i = length - 1;
		Stack<Node> stack = new Stack();
		root = new Node(post[i--]);
		Node p = root;

		while (i >= 0) {

			if (post[i] > p.ele) {
				p.rightChild = new Node(post[i--]);
				stack.push(p);
				p = p.rightChild;
			} else {
				if (stack.isEmpty() || (post[i] < p.ele && post[i] > stack.peek().ele)) {
					p.leftChild = new Node(post[i--]);
					p = p.leftChild;
				} else
					p = stack.pop();
			}
		}
	}

}
