package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetAnyOneSubSequencesWithSumK {

	public static void main(String[] args) {
		int[] a = { 1, 2, 1 };
		int k = 2;
		print(0, a, 0, k, new ArrayList<Integer>());
	}

	private static boolean print(int i, int[] a, int currSum, int reqSum, List<Integer> list) {
		if (i == a.length) {
			if (currSum == reqSum) {
				System.out.println(list);
				return true;
			}
			return false;
		}
		list.add(a[i]);
		if (print(i + 1, a, currSum + a[i], reqSum, list) == true)
			return true;
		list.remove(list.size() - 1);
		if (print(i + 1, a, currSum, reqSum, list) == true)
			return true;
		return false;
	}

}
