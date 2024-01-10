public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int startIdx = 0;
        int totalGas = 0;
        int currentGas = 0;

        for (int i = 0; i < n; ++i) {
            int remainingGas = gas[i] - cost[i];
            totalGas += remainingGas;
            currentGas += remainingGas;

            if (currentGas < 0) {
                currentGas = 0;
                startIdx = i + 1;
            }
        }

        return totalGas >= 0 ? startIdx % n : -1;
    }
}
