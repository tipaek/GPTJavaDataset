/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 25, 2015
 Problem:    Valid Number
 Difficulty: Hard
 Source:     https://oj.leetcode.com/problems/valid-number/
 Notes:
 Validate if a given string is numeric.
 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Note: It is intended for the problem statement to be ambiguous. You should gather all
 requirements up front before implementing one.

 Solution: This finite-state machine solution. Learn from fuwutu & snakeDling.
*/

public class Solution {
    public boolean isNumber(String s) {
        int start = 0, end = s.length() - 1;
        boolean dot = false, exp = false, digit = false;

        // Trim leading and trailing whitespaces
        while (start <= end && s.charAt(start) == ' ') ++start;
        while (start <= end && s.charAt(end) == ' ') --end;

        // Check for optional sign
        if (start <= end && (s.charAt(start) == '+' || s.charAt(start) == '-')) ++start;

        // Check if there's anything left after trimming
        if (start > end) return false;

        // Process the remaining characters
        for (; start <= end; ++start) {
            if (Character.isDigit(s.charAt(start))) {
                digit = true;
            } else if (s.charAt(start) == 'e' || s.charAt(start) == 'E') {
                if (exp || !digit || start == end) return false;
                exp = true;
            } else if (s.charAt(start) == '.') {
                if (dot || exp) return false;
                if (!digit && start == end) return false;
                dot = true;
            } else if (s.charAt(start) == '+' || s.charAt(start) == '-') {
                if (start == end) return false;
                if (s.charAt(start - 1) != 'e' && s.charAt(start - 1) != 'E') return false;
            } else {
                return false;
            }
        }

        return true;
    }
}
