/*
Author:     Andy, nkuwjg@gmail.com
Date:       Dec 13, 2014
Problem:    Two Sum
Difficulty: Medium
Source:     https://oj.leetcode.com/problems/two-sum/
Notes:
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Solution: Hash table. O(n)

Note: Hash Table solution has been updated. In case that the two elements are the same,
all the indices should be stored in the map.
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i + 1};
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return null;
    }
}
