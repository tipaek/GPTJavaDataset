import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        List<Integer> path = new ArrayList<>();
        combinationSumRe(num, target, 0, path, result);
        return result;
    }

    private void combinationSumRe(int[] candidates, int target, int start, List<Integer> path,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && target >= candidates[i]; ++i) {
            if (i != start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            combinationSumRe(candidates, target - candidates[i], i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;

        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> combinations = solution.combinationSum2(candidates, target);

        System.out.println("Unique combinations with sum equal to target: " + combinations);
    }
}
