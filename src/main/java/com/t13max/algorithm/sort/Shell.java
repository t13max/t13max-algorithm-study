package com.t13max.algorithm.sort;


import com.t13max.utils.SortUtil;

/**
 * 希尔排序(基于插入排序)
 */
public class Shell {

    public static void sort(Comparable[] a) {

        int h = 1;
        while (h < a.length / 3) {
            h = h * 3 + 1;//直到这个h的大小接近数组的三分之一
        }

        while (h >= 1) { //循环几次
            for (int i = h; i < a.length; i++) {//里面就是正常的插入排序
                for (int j = i; j >= h && SortUtil.less(a[j], a[j - h]); j -= h) {
                    SortUtil.exch(a, j, j - h);
                }
            }
            h = h / 3;
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
