package com.t13max.algorithm.string;

/**
 * 三向字符串快速排序
 * 和快速排序一样 最好随机化 或者把第一个字符串和随机位置字符串进行交换
 * @Author 呆呆
 * @Datetime 2021/9/27 23:12
 */
public class Quick3String {

    public static void main(String[] args) {
        String[] strs = strs();
        sort(strs);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    private static int charAt(String s, int d) {//校验是否越界
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;//临时存储
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) exch(a, lt++, i++);//小于的 从第0个开始找到一个交换
            else if (t > v) exch(a, i, gt--);//大于的从最后一个开始换
            else i++;//等于的就不用换
        }//然后开始对三部分进行递归排序操作
        sort(a, lo, lt - 1, d);//前面部分的首字母还是乱序 继续递归三向
        if (v >= 0) sort(a, lt, gt, d + 1);//中间的全是一样的 可以开始比较第二个字母了 所以d+1
        sort(a, gt + 1, hi, d);//后面的部分首字母也是乱序 也要继续递归三向
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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
