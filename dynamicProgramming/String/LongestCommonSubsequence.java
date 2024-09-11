
/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
*/

package dynamicProgramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s1 = "mabcdeyx";
		String s2 = "abcenx";
		int l1 = s1.length() + 1;
		int l2 = s2.length() + 1;
		int[][] dp = new int[l1][l2];
		int maxLength = 0;

		for (int ind1 = 1; ind1 < l1; ind1++) {
			for (int ind2 = 1; ind2 < l2; ind2++) {
				if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
					dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
				else
					dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
			}
		}
		maxLength = dp[l1 - 1][l2 - 1];
		String s = "";
		int j = 1;
		for (int i = 0; i < l2; i++) {
			if (dp[l1 - 1][i] == j) {
				s += s2.charAt(i - 1);
				j++;
				if (j > maxLength)
					break;
			}

		}
		System.out.println("Length of longest common subsequence" + " " + maxLength);
		System.out.println("Longest common subsequence " + s);

	}

}
