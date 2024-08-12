package recursion;

public class GetCountOfAllSubSequencesWithSumK {

	public static void main(String[] args) {
		int[] a = { 1, 2, 1 };
		int k = 2;
		System.out.println(count(0, a, 0, k));
	}

	private static int count(int i, int[] a, int currSum, int reqSum) {
		if (i == a.length) {
			if (currSum == reqSum)
				return 1;
			return 0;
		}
		int x = count(i + 1, a, currSum + a[i], reqSum);
		int y = count(i + 1, a, currSum, reqSum);
		return x+y;

	}

}
