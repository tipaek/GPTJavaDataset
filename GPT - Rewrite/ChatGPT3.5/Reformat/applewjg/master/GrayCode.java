import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < (1 << n); ++i) {
            int grayCode = (i >> 1) ^ i;
            result.add(grayCode);
        }

        return result;
    }
}
