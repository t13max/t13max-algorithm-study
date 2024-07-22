package com.t13max.algorithm.sort;

import com.atb.utils.SortUtil;

/**
 * 三项切分快速排序
 */
public class Quick3Way {

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) SortUtil.exch(a, lt++, i++);
            else if (cmp > 0) SortUtil.exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void main(String[] args) {
        Integer[] a = SortUtil.createArray();
        SortUtil.show(a);
        sort(a, 0, a.length - 1);
        SortUtil.show(a);
        SortUtil.isSorted(a);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (SortUtil.less(a[++i], v)) if (i == hi) break; //冗余
            while (SortUtil.less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            SortUtil.exch(a, i, j);
        }
        SortUtil.exch(a, lo, j);
        return j;
    }
}
