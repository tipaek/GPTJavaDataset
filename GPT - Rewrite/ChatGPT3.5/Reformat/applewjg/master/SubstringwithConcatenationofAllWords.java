import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:     Andy, nkuwjg@gmail.com
 * Date:       Dec 20, 2014
 * Problem:    Substring with Concatenation of All Words
 * Difficulty: Easy
 * Source:     https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * Notes:
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all
 * starting indices of substring(s) in S that is a concatenation of each word in L exactly once
 * and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * <p>
 * Solution: 1. Brute + HashMap.
 * 2. Sliding Window + HashMap. from Sun Mian.
 */
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        return findSubstringSlidingWindow(S, L);
    }

    public List<Integer> findSubstringBruteForce(String S, String[] L) {
        List<Integer> res = new ArrayList<>();
        if (L.length == 0 || S == null || S.length() == 0) return res;
        int M = S.length(), N = L.length;
        int K = L[0].length();
        HashMap<String, Integer> need = new HashMap<>();
        for (String str : L) {
            need.put(str, need.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i <= M - N * K; ++i) {
            HashMap<String, Integer> found = new HashMap<>();
            int j = 0;
            for (j = 0; j < N; ++j) {
                String s = S.substring(i + j * K, i + (j + 1) * K);
                if (!need.containsKey(s)) break;
                if (found.getOrDefault(s, 0) >= need.get(s)) break;
                found.put(s, found.getOrDefault(s, 0) + 1);
            }
            if (j == N) res.add(i);
        }
        return res;
    }

    public List<Integer> findSubstringSlidingWindow(String S, String[] L) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> need = new HashMap<>();
        for (String str : L) {
            need.put(str, need.getOrDefault(str, 0) + 1);
        }
        int n = L[0].length(), m = L.length;
        for (int i = 0; i < n; ++i) {
            Map<String, Integer> find = new HashMap<>();
            for (int start = i, end = i, count = 0; end + n <= S.length(); end += n) {
                String str = S.substring(end, end + n);
                if (need.get(str) == null) {
                    start = end + n;
                    find.clear();
                    count = 0;
                    continue;
                }
                while (find.getOrDefault(str, 0) >= need.get(str)) {
                    String subStart = S.substring(start, start + n);
                    find.put(subStart, find.get(subStart) - 1);
                    start += n;
                    --count;
                }
                find.put(str, find.getOrDefault(str, 0) + 1);
                ++count;
                if (count == m) {
                    list.add(start);
                }
            }
        }
        return list;
    }
}
