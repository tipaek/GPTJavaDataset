public class Solution {
    public int numDistinct(String S, String T) {
        int M = S.length();
        int N = T.length();
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 1; i <= M; ++i) {
            for (int j = N; j >= 1; --j) {
                dp[j] += (S.charAt(i - 1) == T.charAt(j - 1)) ? dp[j - 1] : 0;
            }
        }
        return dp[N];
    }
}
