import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        combinationSumRe(candidates, target, 0, path, result);
        return result;
    }

    private void combinationSumRe(int[] candidates, int target, int start, List<Integer> path,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && target >= candidates[i]; ++i) {
            path.add(candidates[i]);
            combinationSumRe(candidates, target - candidates[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;

        CombinationSum solution = new CombinationSum();
        List<List<Integer>> combinations = solution.combinationSum(candidates, target);

        System.out.println("Unique combinations with sum equal to target: " + combinations);
    }
}
