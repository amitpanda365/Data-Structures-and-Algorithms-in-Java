/*
Problem statement
You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.
Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.

Example:
Input: 'arr' = [1, 1, 4, 5]
Output: 3

Explanation: The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.
*/

import java.util.*;
import java.io.*;

public class CountSubsetWithSumK {
    public static int findWays(int num[], int tar) {
        return findWaysUtil(tar, num);
    }

    static int mod =(int)(Math.pow(10,9)+7);

    static int findWaysUtil(int n, int tar, int[] nums, int[][] dp){
        if(tar < 0)
            return 0;
        if(n == 0){
            if(tar == 0 && nums[0] == 0)
                return 2;
            if(tar == 0 || nums[0] == tar)
                return 1;
            return 0;
        }

        if(dp[n][tar] != -1)
            return dp[n][tar];
        return dp[n][tar] = (findWaysUtil(n-1, tar, nums, dp) + findWaysUtil(n-1, tar-nums[n], nums, dp)) % mod;
    }

    static int findWaysUtil(int tar, int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][tar+1];
        int t = 0;
        if(nums[0] == 0)
            dp[0][0] = 2;
        else 
            dp[0][0] = 1;
        
        if(nums[0] != 0 && nums[0] <= tar)
            dp[0][nums[0]] = 1;
        
        for(int i=1; i<n; i++){
            for(int j=0; j<= tar; j++){
                int notTaken = dp[i-1][j];
                int taken = 0;
                if(nums[i] <= j)
                    taken = dp[i-1][j-nums[i]];
                dp[i][j] = (notTaken + taken) % mod;
            }
        }
        return dp[n-1][tar];
    }


}
