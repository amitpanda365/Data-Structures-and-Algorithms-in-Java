
/*
You are given an array 'arr' containing 'n' non-negative integers.
Your task is to partition this array into two subsets such that the absolute difference between subset sums is minimum.
You just need to find the minimum absolute difference considering any valid division of the array elements.
Note:
1. Each array element should belong to exactly one of the subsets.
2. Subsets need not always be contiguous.
For example, for the array : [1, 2, 3], some of the possible divisions are 
   a) {1,2} and {3}
   b) {1,3} and {2}.
3. Subset-sum is the sum of all the elements in that subset. 
Example:
Input: 'n' = 5, 'arr' = [3, 1, 5, 2, 8].
Ouput: 1
Explanation: We can partition the given array into {3, 1, 5} and {2, 8}. 
This will give us the minimum possible absolute difference i.e. (10 - 9 = 1).
*/

public class MinSubsetSumDifference {
    public static int minSubsetSumDifference(int []arr, int n) {
        int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		int target = (sum / 2) + 1;
        boolean[][] dp = new boolean[n+1][target + 1];
		for(int i=0; i<n; i++) {
			dp[i][0] = true;
		}
		if(arr[0] <= target)
			dp[0][arr[0]] = true;
		for(int ind = 1; ind<n; ind++) {
			for(int t=1; t<=target; t++) {
				boolean notTake = dp[ind-1][t];
				boolean take = false;
				if(arr[ind] <= t)
					take = dp[ind-1][t-arr[ind]];
				dp[ind][t] = notTake || take;
			}
		}

        int min = (int)Math.pow(10, 9);

        for(int i=0; i<=target; i++){
            if(dp[n-1][i] == true){
                int partDiff = (sum - i) - i;
                min = Math.min(min, Math.abs(partDiff));
            }
        }

        return min;
    }
}
