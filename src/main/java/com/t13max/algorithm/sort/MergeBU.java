package com.t13max.algorithm.sort;

import com.atb.utils.SortUtil;

/**
 * 归并排序 自底向上
 */
public class MergeBU {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        for (int sz = 1; sz < a.length; sz = sz + sz) {
            for (int lo = 0; lo < a.length - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
            }
        }
    }


    public static void main(String[] args) {
        Integer[] a = SortUtil.createArray();
        aux = new Comparable[a.length];
        SortUtil.show(a);
        sort(a);
        SortUtil.show(a);
        SortUtil.isSorted(a);
    }

    /**
     * 原地归并抽象方法
     * 两边都是有序的 但是整体无序
     * 做一次归并
     */
    public static void merge(Comparable[] a, int low, int mid, int hight) {
        int i = low, j = mid + 1;
        for (int k = low; k <= hight; k++) {//复制一份到
            aux[k] = a[k];
        }
        for (int k = low; k <= hight; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hight) a[k] = aux[i++];
            else if (SortUtil.less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

}
