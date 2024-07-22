package com.t13max.algorithm.sort;

import com.atb.utils.SortUtil;

/**
 * 归并排序 自顶向下
 * 时间为NlgN
 * 但是需要额外空间 N成正比
 * Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本
 */
public class Merge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a, int low, int hight) {
        if (hight <= low) return;
        int mid = low + (hight - low) / 2;//取中间的坐标
        sort(a, low, mid);    //归并排序左边
        sort(a, mid + 1, hight);//归并排序右边
        merge(a, low, mid, hight);//原地归并左右两边
    }


    public static void main(String[] args) {
        Integer[] a = SortUtil.createArray();
        aux = new Comparable[a.length];
        SortUtil.show(a);
        sort(a, 0, a.length - 1);
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
