package dynamicProgramming;

import java.util.Arrays;

/*
 * Geek is going for a training program.
 * He can perform any of these activities: Running, Fighting, and Learning Practice.
 * Each activity has some point on each day. As Geek wants to improve all his skills,
 * he can't do the same activity on two consecutive days. 
 * Help Geek to maximize his merit points as you are given a 2D array of points 
 * arr, corresponding to each day and activity.
 * 
 * Example:
	Input: n=3 and arr[]= [[1,2,5],[3,1,1],[3,3,3]]
	Output:11
	Explanation:Geek will learn a new move and earn 5 point
	 then on second day he will do running and earn 3 point 
	 and on third day he will do fighting and earn 3 points so, maximum point is 11.
 */

public class GeekTraining {

	public static void main(String[] args) {

		int[][] tasks = { { 10, 6, 12 }, { 11, 18, 13 }, { 5, 12, 9 }, { 12, 5, 17 } };
		System.out.println("findMax " + findMax(tasks, tasks.length - 1, 3));
		int[][] dp = new int[tasks.length][4];
		for (int[] a : dp)
			Arrays.fill(a, -1);
		System.out.println("findMaxMemoization " + findMaxMemoization(tasks, tasks.length - 1, 3, dp));
		for (int[] a : dp)
			Arrays.fill(a, -1);
		System.out.println("findMaxTabulation " + findMaxTabulation(tasks, dp));
		System.out.println("findMaxTabulationSpaceOptimized "+ findMaxTabulation(tasks));
	}

	private static int findMax(int[][] tasks, int n, int prev) {

		if (n == 0) {
			int max = 0;
			for (int i = 0; i <= 2; i++) {
				if (i != prev)
					max = Math.max(max, tasks[n][i]);
			}
			return max;
		}

		int max = 0;
		for (int i = 0; i <= 2; i++) {
			if (i != prev) {
				max = Math.max(max, tasks[n][i] + findMax(tasks, n - 1, i));
			}
		}

		return max;
	}

	private static int findMaxMemoization(int[][] tasks, int n, int prev, int[][] dp) {

		if (dp[n][prev] != -1)
			return dp[n][prev];

		if (n == 0) {
			int max = 0;
			for (int i = 0; i <= 2; i++) {
				if (i != prev)
					max = Math.max(max, tasks[n][i]);
			}
			return max;
		}

		int max = 0;
		for (int i = 0; i <= 2; i++) {
			if (i != prev) {
				max = Math.max(max, tasks[n][i] + findMaxMemoization(tasks, n - 1, i, dp));
			}
		}

		return dp[n][prev] = max;
	}

	private static int findMaxTabulation(int[][] tasks, int[][] dp) {
		dp[0][0] = Math.max(tasks[0][1], tasks[0][2]);
		dp[0][1] = Math.max(tasks[0][0], tasks[0][2]);
		dp[0][2] = Math.max(tasks[0][0], tasks[0][1]);
		dp[0][3] = Math.max(tasks[0][0], Math.max(tasks[0][1], tasks[0][2]));

		for (int i = 1; i < tasks.length; i++) {
			for (int prev = 0; prev < 4; prev++) {
				int max = 0;
				for (int j = 0; j <= 2; j++) {
					if (j != prev)
						max = Math.max(max, tasks[i][j] + dp[i - 1][j]);
				}
				dp[i][prev] = max;
			}
		}
		return dp[tasks.length - 1][3];
	}
	
	private static int findMaxTabulation(int[][] tasks) {
		int n = tasks.length;
		int[] dp = new int[4];
		dp[0] = Math.max(tasks[0][1], tasks[0][2]);
		dp[1] = Math.max(tasks[0][0], tasks[0][2]);
		dp[2] = Math.max(tasks[0][0], tasks[0][1]);
		dp[3] = Math.max(tasks[0][0], Math.max(tasks[0][1], tasks[0][2]));
		
		for (int i = 1; i < n; i++) {
			int[] temp = new int[4];
			for (int prev = 0; prev < 4; prev++) {
				int max = 0;
				for (int j = 0; j <= 2; j++) {
					if (j != prev)
						max = Math.max(max, tasks[i][j] + dp[j]);
				}
				temp[prev] = max;
			}
			dp = temp;
		}
		return dp[3];
	}

}
