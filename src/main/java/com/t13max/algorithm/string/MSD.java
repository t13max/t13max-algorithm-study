package com.t13max.algorithm.string;

/**
 * 高位优先的字符串排序
 * 平均需要检查NlogN
 * --------------R
 * 访问数组次数为8N+3R到7wN+3wR之间 w是字符串的平均长度
 *
 * @Author 呆呆
 * @Datetime 2021/9/26 22:56
 */
public class MSD {
    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;

    private static int charAt(String s, int d) {//校验是否越界
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, Integer d) {//第d个字符 从第0个开始
        /*if (hi < lo + M) {
            Insertion.sort(a,lo,hi,d); return;//小数组直接来插入排序
        }*/
        if (lo > hi) return;
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        for (int r = 0; r < R; r++) {//对每个字符都试一下 相同的要在接着排比较下一位
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    public static void main(String[] args) {
        String[] a = strs();
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static String[] strs() {
        String[] result = {
                "she",
                "sells",
                "seashells",
                "by",
                "the",
                "sea",
                "shore",
                "the",
                "shells",
                "she",
                "sells",
                "are",
                "surely",
                "seashells",
        };
        return result;
    }
}
