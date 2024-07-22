package com.t13max.algorithm.sort;


import com.t13max.utils.SortUtil;

/**
 * 堆排序 那个N减一就好了 nb
 * 比较次数比较少 如果比较代价大 用堆排序
 */
public class Heap {

    public static void sort(Comparable[] a) {
        int N = a.length - 1;
        for (int k = N / 2; k >= 1; k--) {//构造堆 让根节点大于左右子节点
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);//把最大的放最后
            sink(a, 1, N);//前N-1个再堆有序
        }
    }

    public static void main(String[] args) {
        Integer[] a = SortUtil.createHeapArray();
        SortUtil.show(a);
        sort(a);
        SortUtil.show(a);
    }

    public static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sink(Comparable[] a, int k, int maxN) {
        while (2 * k <= maxN) {//循环 子节点的子节点
            int j = 2 * k;
            if (j < maxN && less(a, j, j + 1)) j++;//找到大的那个
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    public static void show(Comparable[] a) {
        for (Comparable key : a) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}
