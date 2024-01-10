import java.util.Arrays;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    3Sum Closest
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/3sum-closest/
 Notes:
 Given an array S of n integers, find three integers in S such that the sum is closest to
 a given number, target. Return the sum of the three integers.
 You may assume that each input would have exactly one solution.
 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 Solution: Similar to 3Sum, taking O(n^2) time complexity.
 */

public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {
        int N = num.length;
        if (N < 3) {
            return 0;
        }

        int result = num[0] + num[1] + num[2];
        Arrays.sort(num);

        for (int i = 0; i < N - 2; ++i) {
            int left = i + 1, right = N - 1;

            while (left < right) {
                int threeSum = num[i] + num[left] + num[right];

                if (threeSum == target) {
                    return target;
                } else if (threeSum < target) {
                    ++left;
                } else {
                    --right;
                }

                if (Math.abs(threeSum - target) < Math.abs(result - target)) {
                    result = threeSum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;

        ThreeSumClosest solution = new ThreeSumClosest();
        int closestSum = solution.threeSumClosest(nums, target);

        System.out.println("The sum closest to the target is: " + closestSum);
    }
}
