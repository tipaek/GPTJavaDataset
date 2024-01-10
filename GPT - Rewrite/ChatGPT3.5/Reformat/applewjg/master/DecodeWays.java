public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int N = s.length();
        int prev1 = 1, prev2 = 1;

        for (int i = 1; i < N; ++i) {
            if (s.charAt(i) == '0')
                prev2 = 0;

            int num = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (num < 10 || num > 26) {
                prev1 = 0;
            }

            int tmp = prev2;
            prev2 = prev2 + prev1;
            prev1 = tmp;
        }
        return prev2;
    }
}
