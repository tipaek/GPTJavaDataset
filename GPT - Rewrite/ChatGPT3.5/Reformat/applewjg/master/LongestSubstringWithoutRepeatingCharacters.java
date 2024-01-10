import java.util.Arrays;

public class Solution {
    public int lengthOfLongestSubstring_1(String s) {
        boolean[] seen = new boolean[256];
        Arrays.fill(seen, false);
        int n = s.length();
        if (n <= 1)
            return n;
        int start = 0, end = 0, maxLength = 0;
        while (end < n && start + maxLength < n) {
            if (!seen[s.charAt(end)]) {
                seen[s.charAt(end++)] = true;
            } else {
                seen[s.charAt(start++)] = false;
            }
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring_2(String s) {
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        int n = s.length();
        if (n <= 1)
            return n;
        lastIndex[s.charAt(0)] = 0;
        int start = 0, maxLength = 1, current = 0;
        while (++current < n) {
            if (lastIndex[s.charAt(current)] >= start) {
                start = lastIndex[s.charAt(current)] + 1;
            }
            maxLength = Math.max(maxLength, current - start + 1);
            lastIndex[s.charAt(current)] = current;
        }
        return maxLength;
    }
}
