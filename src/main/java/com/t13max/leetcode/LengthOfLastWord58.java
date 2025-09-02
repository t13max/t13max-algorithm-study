package com.t13max.leetcode;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为 5。
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为 4。
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为 6 的“joyboy”。
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 *
 * @Author t13max
 * @Date 10:06 2025/9/2
 */
public class LengthOfLastWord58 {
    public static int lengthOfLastWord(String s) {
        char[] array = s.toCharArray();
        int length = 0;
        boolean stop = false;
        for (char c : array) {
            if (c == ' ') {
                stop = true;
                continue;
            }
            if (stop) {
                stop = !stop;
                length = 0;
            }
            length++;
        }
        return length;
    }

    /**
     * 反向遍历
     *
     * @Author t13max
     * @Date 10:15 2025/9/2
     */
    public int lengthOfLastWordLeetCode(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));//5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));//4
        System.out.println(lengthOfLastWord("luffy is still joyboy"));//6
    }

}
