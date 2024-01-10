import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combineRe(n, k, 1, path, result);
        return result;
    }

    private void combineRe(int n, int k, int start, List<Integer> path, List<List<Integer>> result) {
        int m = path.size();
        if (m == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - (k - m) + 1; ++i) {
            path.add(i);
            combineRe(n, k, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        int n = 4;
        int k = 2;

        Combinations solution = new Combinations();
        List<List<Integer>> combinations = solution.combine(n, k);

        System.out.println("All possible combinations: " + combinations);
    }
}
