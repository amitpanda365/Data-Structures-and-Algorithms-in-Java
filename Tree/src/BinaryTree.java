import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

	private Queue<Node> queue = new LinkedList<>();

	public Node root;

	private class Node {
		Node leftChild;
		int ele;
		Node rightChild;

		Node(int ele) {
			this.ele = ele;
		}
	}

	public void create() {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter root");
		int ele = scn.nextInt();
		root = new Node(ele);
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.println("enter left child of " + temp.ele);
			ele = scn.nextInt();
			if (ele != -1) {
				temp.leftChild = new Node(ele);
				queue.offer(temp.leftChild);
			}
			System.out.println("enter right child of " + temp.ele);
			ele = scn.nextInt();
			if (ele != -1) {
				temp.rightChild = new Node(ele);
				queue.offer(temp.rightChild);
			}
		}
		scn.close();
	}

	public void preOrder(Node t) {
		if (t != null) {
			System.out.print(t.ele + " ");
			preOrder(t.leftChild);
			preOrder(t.rightChild);
		}
	}

	public void inOrder(Node t) {
		if (t != null) {
			inOrder(t.leftChild);
			System.out.print(t.ele + " ");
			inOrder(t.rightChild);
		}
	}

	public void postOrder(Node t) {
		if (t != null) {
			postOrder(t.leftChild);
			postOrder(t.rightChild);
			System.out.print(t.ele + " ");
		}
	}

	public void iterativePreOrder() {
		Node t = root;
		Stack<Node> stack = new Stack<>();

		while (t != null || !stack.isEmpty()) {
			if (t != null) {
				System.out.print(t.ele + " ");
				stack.push(t);
				t = t.leftChild;
			} else {
				t = stack.pop();
				t = t.rightChild;
			}

		}
		System.out.println();
	}

	// Iterative post order traversal using two stacks
	public void iterativePostOrder() {

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);

		while (!s1.isEmpty()) {
			Node t = s1.pop();
			s2.push(t);
			if (t.leftChild != null)
				s1.push(t.leftChild);
			if (t.rightChild != null)
				s1.push(t.rightChild);
		}

		// s2.forEach(n -> System.out.print(n.ele+" "));
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().ele + " ");
		}

		System.out.println();
	}

	// Iterative post order traversal using one stacks
	public void iterativePostOrderUsingOneStack() {

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);

		while (!s1.isEmpty()) {
			Node t = s1.pop();
			s2.push(t);
			if (t.leftChild != null)
				s1.push(t.leftChild);
			if (t.rightChild != null)
				s1.push(t.rightChild);
		}

		// s2.forEach(n -> System.out.print(n.ele+" "));
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().ele + " ");
		}

		System.out.println();
	}

	public int countNode(Node p) {

		if (p == null)
			return 0;

		return countNode(p.leftChild) + countNode(p.rightChild) + 1;
	}

}