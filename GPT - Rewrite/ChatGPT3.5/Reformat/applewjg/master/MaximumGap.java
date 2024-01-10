import java.util.Arrays;

public class Solution {
    public int maximumGap_1(int[] num) {
        Arrays.sort(num);
        int res = 0;
        for (int i = 1; i < num.length; ++i) {
            res = Math.max(res, num[i] - num[i - 1]);
        }
        return res;
    }

    class Node {
        int low;
        int high;

        public Node() {
            low = -1;
            high = -1;
        }
    }

    public int maximumGap_2(int[] num) {
        int n = num.length;
        if (n < 2)
            return 0;

        int minVal = num[0], maxVal = num[0];
        for (int i = 1; i < n; ++i) {
            minVal = Math.min(minVal, num[i]);
            maxVal = Math.max(maxVal, num[i]);
        }

        Node[] pool = new Node[n + 2];
        for (int i = 0; i < n + 2; ++i)
            pool[i] = new Node();

        for (int i = 0; i < n; ++i) {
            int idx = (int) (Long.valueOf(num[i] - minVal) * Long.valueOf(n + 1) / Long.valueOf(maxVal + 1 - minVal));
            if (pool[idx].low == -1) {
                pool[idx].low = pool[idx].high = num[i];
            } else {
                pool[idx].low = Math.min(pool[idx].low, num[i]);
                pool[idx].high = Math.max(pool[idx].high, num[i]);
            }
        }

        int pre = pool[0].high;
        int res = 0;

        for (int i = 1; i < n + 2; ++i) {
            if (pool[i].low != -1) {
                res = Math.max(res, pool[i].low - pre);
                pre = pool[i].high;
            }
        }

        return res;
    }
}
