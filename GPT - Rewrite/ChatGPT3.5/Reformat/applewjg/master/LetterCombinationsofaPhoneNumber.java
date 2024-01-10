import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        String[] keyboard = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        letterCombinationsRe(keyboard, res, digits, "");
        return res;
    }

    private void letterCombinationsRe(String[] keyboard, List<String> res, String digits, String s) {
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }
        String letters = keyboard[digits.charAt(s.length()) - '0'];
        for (char letter : letters.toCharArray()) {
            letterCombinationsRe(keyboard, res, digits, s + letter);
        }
    }
}
