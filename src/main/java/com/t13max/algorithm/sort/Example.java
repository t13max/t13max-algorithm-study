package com.t13max.algorithm.sort;


import com.t13max.utils.SortUtil;

/**
 *
 */
public class Example {

    public static void sort(Comparable[] a) {

    }

    public static void main(String[] args) {
        Integer[] a = SortUtil.createArray();
        SortUtil.show(a);
        sort(a);
        SortUtil.show(a);
        SortUtil.isSorted(a);
    }


}
