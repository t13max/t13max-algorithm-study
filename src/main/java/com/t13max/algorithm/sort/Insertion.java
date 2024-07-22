package com.t13max.algorithm.sort;

import com.atb.utils.SortUtil;

import java.util.Comparator;

/**
 * 插入排序
 * <p>
 * 平均 N**2/4次比较 N**2/4次交换
 * 最坏 N**2/2次比较 N**2/2次交换
 * 最好 N-1次比较 0次交换
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {//循环n-1次 从第二个元素开始往前面插
            for (int j = i; j > 0 && SortUtil.less(a[j], a[j - 1]); j--) {//当前这个与前面所有进行比较 其实就是插入到合适的位置 前面永远是有序的 一个一个往前比 小的就交换直到挪到合适的位置
                SortUtil.exch(a, j, j - 1);
            }
        }
    }

    public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--) {
                exch(a, j, j - 1);
            }
        }
        assert isSorted(a, lo, hi, comparator);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length, comparator);
    }

    private static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1], comparator)) return false;
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = SortUtil.createArray();
        SortUtil.show(a);
        sort(a);
        SortUtil.show(a);
        SortUtil.isSorted(a);
    }

}
