import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute_1(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] free = new boolean[num.length];
        Arrays.fill(free, true);
        permuteRe(num, res, path, free);
        return res;
    }

    void permuteRe(int[] num, List<List<Integer>> res, List<Integer> path, boolean[] free) {
        if (path.size() == num.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < num.length; ++i) {
            if (free[i]) {
                free[i] = false;
                path.add(num[i]);
                permuteRe(num, res, path, free);
                path.remove(path.size() - 1);
                free[i] = true;
            }
        }
    }

    public boolean nextPermutation(int[] num) {
        int last = num.length - 1;
        int i = last;
        while (i > 0 && num[i - 1] >= num[i])
            --i;
        for (int l = i, r = last; l < r; ++l, --r) {
            num[l] = num[l] ^ num[r];
            num[r] = num[l] ^ num[r];
            num[l] = num[l] ^ num[r];
        }
        if (i == 0) {
            return false;
        }
        int j = i;
        while (j <= last && num[i - 1] >= num[j])
            ++j;
        num[i - 1] = num[i - 1] ^ num[j];
        num[j] = num[i - 1] ^ num[j];
        num[i - 1] = num[i - 1] ^ num[j];
        return true;
    }

    public List<List<Integer>> permute_2(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        do {
            List<Integer> path = new ArrayList<>();
            for (int i : num)
                path.add(i);
            res.add(path);
        } while (nextPermutation(num));
        return res;
    }
}
