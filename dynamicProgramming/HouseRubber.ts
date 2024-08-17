/*
Leet Code 198
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

*/

function rob(nums: number[]): number {
    return robBottomUpSpaceOptimization(nums);
};

function robsMemoization(nums: number[], n:number, dp: number[]): number {
    if(n < 0)
        return 0;
    if(n == 0)
        return nums[0];

    if(dp[n] != -1)
        return dp[n];

   let n1:number = nums[n] + robsMemoization(nums, n-2, dp);
   let n2:number = robsMemoization(nums, n-1, dp);
   return dp[n] = Math.max(n1, n2);
};

function robBottomUp(nums: number[], n:number, dp: number[]): number {
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for(let i:number=2; i<=n; i++){
        dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
    }
    return dp[n];
};

function robBottomUpSpaceOptimization(nums: number[]): number {
    let n:number = nums.length;
    let n0:number = nums[0];
    if(n == 1)
        return n0;
    let n1:number = Math.max(nums[0], nums[1]);
    if(n == 2)
        return n1;
    let n2:number = 0;
    for(let i:number=2; i<n; i++){
        n2 = Math.max(nums[i]+n0, n1);
        n0 = n1;
        n1 = n2;
    }
    return n2;
};
