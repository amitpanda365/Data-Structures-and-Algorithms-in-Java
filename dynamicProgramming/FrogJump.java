package dynamicProgramming;

import java.util.Arrays;

/*
 * Given a number of stairs and a frog, the frog wants to climb from the 
 * 0th stair to the (N-1)th stair. 
 * At a time the frog can climb either one or two steps.
 * A height[N] array is also given. Whenever the frog jumps from a stair i to stair j,
 * the energy consumed in the jump is abs(height[i]- height[j]), 
 * where abs() means the absolute difference. 
 * We need to return the minimum energy that can be used by the frog
 * to jump from stair 0 to stair N-1.
 * Example - Input = [10, 20, 30, 10], Output = 20
 */

public class FrogJump {

	public static void main(String[] args) {
		int[] a = { 30, 10, 60, 10, 60, 50 };
		System.out.println("min recursive " + findMin(a, a.length - 1));
		int[] dp = new int[a.length];
		Arrays.fill(dp, -1);
		System.out.println("min Memoization " + findMinMemoization(a, a.length - 1, dp));
		Arrays.fill(dp, -1);
		System.out.println("min Tabulation " + findMinTabulation(a, a.length, dp));
		System.out.println("min Tabulation with Space Optimized " + findMinTabulationSpaceOptimized(a, a.length));
		
	}
	private static int findMin(int[] a, int n) {
		if (n == 0) {
			return 0;
		}

		int x = findMin(a, n - 1) + Math.abs(a[n] - a[n - 1]);
		int y = Integer.MAX_VALUE;
		if (n > 1)
			y = findMin(a, n - 2) + Math.abs(a[n] - a[n - 2]);
		return Math.min(x, y);
	}

	private static int findMinMemoization(int[] a, int n, int[] dp) {
		if (n == 0) {
			return 0;
		}

		if (dp[n] != -1)
			return dp[n];

		int x = findMinMemoization(a, n - 1, dp) + Math.abs(a[n] - a[n - 1]);
		int y = Integer.MAX_VALUE;
		if (n > 1)
			y = findMinMemoization(a, n - 2, dp) + Math.abs(a[n] - a[n - 2]);
		return dp[n] = Math.min(x, y);
	}

	private static int findMinTabulation(int[] a, int n, int[] dp) {

		dp[0] = 0;
		
		for (int i = 1; i < n; i++) {
			int x = dp[i-1] + Math.abs(a[i] - a[i-1]);
			int y = Integer.MAX_VALUE;
			if(i > 1)
				y = dp[i-2] + Math.abs(a[i] - a[i-2]);
			dp[i] = Math.min(x, y);
		}

		return dp[n - 1];
	}
	
	private static int findMinTabulationSpaceOptimized(int[] a, int n) {
		
		int prev = 0;
		int prev2 = 0;
		
		for (int i = 1; i < n; i++) {
			int x = prev + Math.abs(a[i] - a[i-1]);
			int y = Integer.MAX_VALUE;
			if(i > 1)
				y = prev2 + Math.abs(a[i] - a[i-2]);
			int curri = Math.min(x, y);
			prev2 = prev;
			prev = curri;
		}
		
		return prev;
	}

}
