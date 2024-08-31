/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:
Input: coins = [2], amount = 3
Output: -1
Example 3:
Input: coins = [1], amount = 0
Output: 0
*/

class CoinChange2 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] a : dp)
            Arrays.fill(a, -1);
        int res = coinUtil(n-1, amount, coins, dp);
        return res == max ? -1 : res;
    }

    static int max = (int)Math.pow(10, 7);

    int coinUtil(int n, int amount, int[] coins, int[][] dp){
        if(amount == 0)
            return 0;
        if(n < 0)
            return max;

        if(dp[n][amount] != -1)
            return dp[n][amount];

        int a = max;
        if(coins[n] <= amount)
            a = 1 + coinUtil(n, amount-coins[n], coins, dp);
        int b = coinUtil(n-1, amount, coins, dp);

        return dp[n][amount] = Math.min(a, b);
    }
}
