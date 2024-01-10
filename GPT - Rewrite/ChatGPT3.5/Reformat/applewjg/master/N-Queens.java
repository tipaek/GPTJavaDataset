public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<>();
        List<char[]> sol = new ArrayList<>();
        solveNQueensRe(n, 0, 0, 0, sol, res);
        return res;
    }

    public void solveNQueensRe(int n, int row, int ld, int rd, List<char[]> sol, List<String[]> res) {
        if (row == (1 << n) - 1) {
            String[] temp = new String[n];
            for (int i = 0; i < n; ++i)
                temp[i] = String.valueOf(sol.get(i));
            res.add(temp);
            return;
        }

        int avail = ~(row | ld | rd);
        for (int i = n - 1; i >= 0; --i) {
            int pos = 1 << i;
            if ((avail & pos) != 0) {
                char[] str = new char[n];
                Arrays.fill(str, '.');
                str[i] = 'Q';
                sol.add(str);
                solveNQueensRe(n, row | pos, (ld | pos) << 1, (rd | pos) >> 1, sol, res);
                sol.remove(sol.size() - 1);
            }
        }
    }
}
