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
        if(k<0 || n == -1)
            return false;
        if(dp[n][k] != -1)
            return dp[n][k] == 1;
            
        boolean notTake = subUtil(n-1, k, arr, dp);
        boolean take = subUtil(n-1, k-arr[n], arr, dp);

        dp[n][k] = (notTake || take) ? 1 : 0;
    
        return notTake || take;
    }
}
