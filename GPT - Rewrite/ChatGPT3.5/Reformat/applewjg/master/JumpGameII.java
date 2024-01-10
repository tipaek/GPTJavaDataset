public class Solution {
    public int jump(int[] A) {
        int n = A.length;
        int last = 0, cur = 0, jumps = 0;

        for (int i = 0; i < n; ++i) {
            if (i > last) {
                jumps++;
                last = cur;

                if (cur >= n - 1) {
                    return jumps;
                }
            }

            cur = Math.max(cur, i + A[i]);
        }

        return jumps;
    }
}
