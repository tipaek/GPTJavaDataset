public class Solution {
    public boolean isPalindrome(int x) {
        return isPalindromeSolution2(x);
    }

    public boolean isPalindromeSolution1(int x) {
        if (x < 0)
            return false;
        int divisor = 1;
        while (x / divisor >= 10) {
            divisor *= 10;
        }
        while (divisor > 1) {
            if (x % 10 != x / divisor) {
                return false;
            }
            x = (x % divisor) / 10;
            divisor /= 100;
        }
        return true;
    }

    public boolean isPalindromeSolution2(int x) {
        if (x < 0)
            return false;
        return x == reverse(x);
    }

    public int reverse(int x) {
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
