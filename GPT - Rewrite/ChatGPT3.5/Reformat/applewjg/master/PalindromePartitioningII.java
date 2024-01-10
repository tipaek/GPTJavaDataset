public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = -1;
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = n - 1; i >= 0; --i) {
            dp[i] = n - 1 - i;

            for (int j = i; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j < i + 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }

                if (isPalindrome[i][j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}
