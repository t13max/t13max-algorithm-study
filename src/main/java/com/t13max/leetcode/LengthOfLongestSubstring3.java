package com.t13max.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 * 的长度。
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 *
 * @author: t13max
 * @since: 10:08 2024/7/25
 */
public class LengthOfLongestSubstring3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringOfficial("abcabcbb"));
        System.out.println(lengthOfLongestSubstringOfficial("bbbbb"));
        System.out.println(lengthOfLongestSubstringOfficial("pwwkew"));
    }

    /**
     * 菜猫傻呆呆原版
     *
     * @Author t13max
     * @Date 10:50 2024/7/25
     */
    public static int lengthOfLongestSubstring(String str) {
        char[] chars = str.toCharArray();
        int result = 0;
        Set<Character> contains = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (contains.contains(chars[j])) {
                    break;
                }
                contains.add(chars[j]);
            }
            if (contains.size() > result) {
                result = contains.size();
            }
            contains.clear();
        }
        return result;
    }

    /**
     * 极致优化版
     *
     * @Author t13max
     * @Date 10:45 2024/7/25
     */
    public static int lengthOfLongestSubstringOfficial(String s) {
        //char[] chars = str.toCharArray();不使用toCharArray 字符串底层是字符数组(byte数组)
        int left = 0, length = 0, max = 0;
        //右指针一直走
        for (int right = 0; right < s.length(); right++) {
            //左指针存在重复才加一
            for (int k = left; k < right; k++) {
                //直到找到重复的 跳出循环 左指针加一
                if (s.charAt(k) == s.charAt(right)) {
                    left = k + 1;
                    //计算当前长度(这里计算的比实际长度是少1的 底下++以后正好是正确长度)
                    length = right - left;
                    break;
                }
            }
            //没重复 长度加一
            length++;
            if (max < length) max = length;
        }
        return max;
    }

    /**
     * 滑动窗口版
     *
     * @Author t13max
     * @Date 10:45 2024/7/25
     */
    public static int slideWindow(String str) {
        char[] chars = str.toCharArray();
        int result = 0;
        Set<Character> contains = new HashSet<>();
        int index = 0;
        for (int i = 0; index < chars.length && i < chars.length; i++) {
            while (index < chars.length && !contains.contains(chars[index])) {
                contains.add(chars[index]);
                if (contains.size() > result) {
                    result = contains.size();
                }
                index++;
            }
            contains.remove(chars[i]);
        }
        return result;
    }
}