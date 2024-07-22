package com.t13max.algorithm.sort;

import com.atb.utils.SortUtil;

/**
 * 快速排序
 * <p>
 * 把一个元素放到合适位置 左边都比他小 右边都比他大
 * 在递归分别对两边做相同的操作 整个数组是越来越有序的
 * <p>
 * 重复的元素会影响性能
 * <p>
 * 优化: 三取样切分 熵最优的排序
 */
public class Quick {

    public static void sort(Comparable[] a, int lo, int hi) {
        //StdRandom.shuffle(a);//先打乱
        if (hi <= lo) return;//if(hi<=lo+10) {Insertion.sort(a); return;}小数组 5-15都算小 切换为插入排序
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
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
        Comparable v = a[lo];//最小
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
