package dynamicProgramming;

/*
You are given an array 'ARR' of 'N' positive integers. 
Your task is to find if we can partition the given array into two 
subsets such that the sum of elements in both subsets is equal.
For example, let’s say the given array is [2, 3, 3, 3, 4, 5], 
then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.
Follow Up:
Can you solve this using not more than O(S) extra space, 
where S is the sum of all elements of the given array?
*/

import java.util.*;

public class CanPartition {
	public static boolean canPartition(int[] arr, int n) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += arr[i];
		}

		if (total % 2 != 0)
			return false;
		int k = total / 2;

		boolean[] dp = new boolean[k + 1];
		boolean[] temp = new boolean[k + 1];
		dp[0] = true;
		if (arr[0] <= k)
			dp[arr[0]] = true;

		for (int i = 1; i < n; i++) {
			temp[0] = true;
			for (int j = 1; j <= k; j++) {
				boolean notTake = dp[j];
				boolean take = false;
				if (arr[i] <= j)
					take = dp[j - arr[i]];
				temp[j] = notTake || take;
			}
			dp = temp.clone();
		}

		return dp[k];
	}
}
