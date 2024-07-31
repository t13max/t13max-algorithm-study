package com.t13max.leetcode;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * @author: t13max
 * @since: 11:13 2024/7/31
 */
public class ZConvert6 {

    public static void main(String[] args) {
        System.out.println(convert2("PAYPALISHIRING", 3));
        System.out.println(convert2("PAYPALISHIRING", 4));
        System.out.println(convert2("A", 1));
        System.out.println(convert2("ABC", 1));
    }

    /**
     * 官方压缩矩阵版
     *
     * @Author t13max
     * @Date 13:44 2024/7/31
     */
    public static String convert2(String s, int numRows) {
        int n = s.length(), r = numRows;
        //只有一行 或者长度小于行数
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        StringBuilder[] array = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            array[i] = new StringBuilder();
        }

        int y = 0;//纵坐标
        //枚举所有字母
        for (int i = 0; i < s.length(); i++) {
            array[y].append(s.charAt(i));
            if (i % t < r - 1) {
                ++y;
            } else {
                --y;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : array) {
            result.append(stringBuilder);
        }
        return result.toString();
    }

    /**
     * 傻呆呆菜猫版
     *
     * @Author t13max
     * @Date 13:44 2024/7/31
     */
    public static String convert(String s, int numRows) {

        int n = s.length(), r = numRows;
        //只有一行 或者长度小于行数
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] array = new char[r][c];
        int y = 0;//横坐标
        int x = 0;//纵坐标
        //枚举所有字母
        for (int i = 0; i < s.length(); i++) {
            array[y][x] = s.charAt(i);
            if (i % t < r - 1) {
                ++y; // 向下移动
            } else {
                --y;
                ++x; // 向右上移动
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (char j : array[i]) {
                if (j != 0) {
                    result.append(j);
                }
            }
        }
        return result.toString();
    }
}
