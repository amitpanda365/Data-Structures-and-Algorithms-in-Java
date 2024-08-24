import java.util.* ;
import java.io.*; 

public class SubsetSumToK {
  
    /*
    Problem statement
    You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

    Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

    For Example :
    If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
    */
    public static boolean subsetSumToK(int n, int k, int arr[]){
       int[][] dp = new int[n][k+1];
       for(int[] a : dp)
        Arrays.fill(a, -1);
       return subUtil(n-1, k, arr, dp);
    }

    static boolean subUtil(int n, int k, int arr[], int[][] dp){
        if(k == 0)
            return true;
        if(n == 0)
            return arr[0] == k;
        if(dp[n][k] != -1)
            return dp[n][k] == 1;
            
        boolean notTake = subUtil(n-1, k, arr, dp);
        boolean take = false;
        if(arr[n] <= k)
            take = subUtil(n-1, k-arr[n], arr, dp);

        dp[n][k] = (notTake || take) ? 1 : 0;
    
        return notTake || take;
    }

  public static boolean subsetSumToKTabluation(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= k)
            dp[0][arr[0]] = true;

        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(arr[i] <= j)
                    take = dp[i-1][j-arr[i]];
                dp[i][j] = notTake || take;
            }
        }

        return dp[n-1][k];
    }
}
