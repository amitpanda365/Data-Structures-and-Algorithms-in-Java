
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

class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        return tabulationUtil(text1, text2);
    }

    // Tabulation
    int tabulationUtil(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1][l2];

        for(int ind1 = 0; ind1<l1; ind1++){
            for(int ind2 = 0; ind2<l2; ind2++){
                if(s1.charAt(ind1) == s2.charAt(ind2))
                    dp[ind1][ind2] = 1 + ((ind1-1 < 0 || ind2-1 < 0) ? 0 : dp[ind1-1][ind2-1]);
                else
                    dp[ind1][ind2] = Math.max((ind1 == 0 ? 0 : dp[ind1-1][ind2]), (ind2 == 0 ? 0 : dp[ind1][ind2-1]));
            }
        }
        
        return dp[l1-1][l2-1];
    }

    int tabulationUtil2(String s1, String s2){
        int l1 = s1.length() + 1;
        int l2 = s2.length() + 1;
        int[][] dp = new int[l1][l2];

        for(int ind1 = 1; ind1<l1; ind1++){
            for(int ind2 = 1; ind2<l2; ind2++){
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
            }
        }
        return dp[l1-1][l2-1];
    }

    // Recursion + Memoization
    int util(int ind1, int ind2, String s1, String s2, int[][] dp){

        if(ind1 < 0 || ind2 < 0)
            return 0;
        
        if(dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2))
            return dp[ind1][ind2] = 1 + util(ind1-1, ind2-1, s1, s2, dp);
        else
            return dp[ind1][ind2] = Math.max(util(ind1, ind2-1, s1, s2, dp), util(ind1-1, ind2, s1, s2, dp));
    }
}
