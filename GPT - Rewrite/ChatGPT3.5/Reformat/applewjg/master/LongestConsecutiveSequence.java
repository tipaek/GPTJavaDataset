import java.util.HashMap;

public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> unmap = new HashMap<>();
        int res = 0;

        for (int val : num) {
            if (unmap.containsKey(val))
                continue;

            int left = unmap.getOrDefault(val - 1, 0);
            int right = unmap.getOrDefault(val + 1, 0);
            int len = left + right + 1;

            unmap.put(val, len);
            unmap.put(val - left, len);
            unmap.put(val + right, len);

            res = Math.max(res, len);
        }

        return res;
    }
}
