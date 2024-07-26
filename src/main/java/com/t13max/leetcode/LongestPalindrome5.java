package com.t13max.leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的 回文子串
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * @author: t13max
 * @since: 11:07 2024/7/26
 */
public class LongestPalindrome5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {

        String result = s.length() == 1 ? s : "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length(); j++) {
                if (check(s, i, j)) {
                    if (result.length() <= j - i) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }

    private static boolean check(String s, int i, int index) {
        for (int j = 0; j < (index - i) / 2 + 1; j++) {
            if (s.charAt(i + j) != s.charAt(index - j)) {
                return false;
            }
        }
        return true;
    }
}
