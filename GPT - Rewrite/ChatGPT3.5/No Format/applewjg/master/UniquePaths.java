/*
Author:     King, wangjingui@outlook.com
Date:       Oct 9, 2014
Problem:    Unique Paths
Difficulty: Easy
Source:     https://oj.leetcode.com/problems/unique-paths/
Notes:
A robot is located at the top-left corner of a m x n grid.
The robot can only move either down or right at any point in time. The robot is trying to reach
the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Solution:
1. Use formula C(x,t) = t!/(x!*(t-x)!) (x should be large for calculation).
2. Dynamic programming. UP(i,j) = UP(i-1,j) + UP(i,j-1).
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;

        // Using combinatorial formula
        int totalSteps = m + n - 2;
        int smallerDimension = Math.min(m, n) - 1;
        long result = 1;

        for (int i = 1; i <= smallerDimension; i++) {
            result *= (totalSteps - i + 1);
            result /= i;
        }

        return (int) result;
    }

    public int uniquePathsDP(int m, int n) {
        if (m == 1 || n == 1) return 1;

        // Using dynamic programming
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
