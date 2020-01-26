package openHashing;

public class Chaining {

	private LinkedList[] hashTable = new LinkedList[10];

	public static void main(String[] args) {
		Chaining chain = new Chaining();
		chain.insert(12);
		chain.insert(22);
		chain.insert(34);
		chain.insert(142);
		chain.insert(122);
		chain.insert(42);
		chain.insert(78);
		chain.insert(67);
		System.out.println(chain.delete(142));
		System.out.println(chain.search(122));
	}

	public int hashCode(int ele) {
		return ele % 10;
	}

	public void insert(int ele) {

		int index = hashCode(ele);
		hashTable[index] = hashTable[index] == null ? new LinkedList() : hashTable[index];
		hashTable[index].insertInSortedList(ele);
	}

	public boolean search(int ele) {

		int index = hashCode(ele);
		if (hashTable[index] == null)
			return false;

		return hashTable[index].search(ele);
	}

	public boolean delete(int ele) {

		int index = hashCode(ele);
		if (hashTable[index] == null)
			return false;

		return hashTable[index].delete(ele);
	}

}
