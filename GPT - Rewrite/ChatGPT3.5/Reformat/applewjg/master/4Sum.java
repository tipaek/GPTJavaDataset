import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    4Sum
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/4sum/
 Notes:
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.
 Note:
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 Find all unique quadruplets in the array which gives the sum of target.
 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)

 Solution: Similar to 3Sum, 2Sum.
 */

public class FourSum {

    public List<List<Integer>> fourSum(int[] num, int target) {
        int N = num.length;
        List<List<Integer>> res = new ArrayList<>();
        if (N < 4) {
            return res;
        }

        Arrays.sort(num);

        for (int i = 0; i < N - 3; ++i) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue; // avoid duplicates
            }

            for (int j = i + 1; j < N - 2; ++j) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue; // avoid duplicates
                }

                int twoSum = target - num[i] - num[j];
                int left = j + 1, right = N - 1;

                while (left < right) {
                    int sum = num[left] + num[right];

                    if (sum == twoSum) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[left]);
                        tmp.add(num[right]);
                        res.add(tmp);

                        while (left < right && num[left + 1] == num[left]) {
                            left++; // avoid duplicates
                        }

                        while (left < right && num[right - 1] == num[right]) {
                            right--; // avoid duplicates
                        }

                        left++;
                        right--;
                    } else if (sum < twoSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;

        FourSum solution = new FourSum();
        List<List<Integer>> result = solution.fourSum(nums, target);

        System.out.println("The unique quadruplets that sum up to the target are: " + result);
    }
}
