package dynamicProgramming;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "yzmaksabcxe";
		int l1 = s1.length() + 1;
		int l2 = s2.length() + 1;
		int[][] dp = new int[l1][l2];
		int maxLength = 0;
		int maxRow = 0;
		int maxCol = 0;

		for (int ind1 = 1; ind1 < l1; ind1++) {
			for (int ind2 = 1; ind2 < l2; ind2++) {
				if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
					dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
					if (maxLength < dp[ind1][ind2]) {
						maxLength = dp[ind1][ind2];
						maxRow = ind1;
						maxCol = ind2;
					}
				} else
					dp[ind1][ind2] = 0;
			}
		}

		StringBuilder maxSubStringByRow = new StringBuilder();
		StringBuilder maxSubStringByCol = new StringBuilder();
		maxRow = maxRow - maxLength;
		maxCol -= maxLength;

		for (int i = maxLength; i > 0; i--) {
			maxSubStringByRow.append(s1.charAt(maxRow++));
		}
		for (int i = maxLength; i > 0; i--) {
			maxSubStringByCol.append(s2.charAt(maxCol++));
		}

		System.out.println("maxLength " + maxLength);
		System.out.println("maxSubString " + maxSubStringByRow);
		System.out.println("maxSubStringByCol " + maxSubStringByCol);

		/*
		 * Output - 
		 * maxLength 3
		 * maxSubString abc
		 * maxSubStringByCol abc
		 */
	}

}
