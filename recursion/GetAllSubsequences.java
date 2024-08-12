package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetAllSubsequences {

	public static void main(String[] args) {
		int[] a = { 3, 1, 2 };
		print(0, a.length, a, new ArrayList<Integer>());
	}

	private static void print(int i, int n, int[] a, List<Integer> list) {
		if (i == n) {
			System.out.println(list);
			return;
		}
		list.add(a[i]);
		print(i + 1, n, a, list);
		list.remove(list.size() - 1);
		print(i + 1, n, a, list);
	}

}
