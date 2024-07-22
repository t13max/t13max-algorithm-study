package com.t13max.algorithm.sort;


import com.t13max.utils.SortUtil;

/**
 * 选择排序
 * 循环N次 每次找到最小的一个和未排序的部分的第一个交换
 * <p>
 * N**2/2次比较 N次交换
 */
public class Selection {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (SortUtil.less(a[j], a[min])) {
                    min = j;
                }
            }
            SortUtil.exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] a = SortUtil.createArray();
        SortUtil.show(a);
        sort(a);
        SortUtil.show(a);
        SortUtil.isSorted(a);
    }


}
