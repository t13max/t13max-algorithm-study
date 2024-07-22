package com.t13max.utils;

import java.util.Random;

/**
 * 为什么不继承呢?
 * 稳定性 插入排序和归并排序是稳定的
 * p218有几个排序的总结
 * Array.sort对原始数据类型用三项切分快速排序 对引用数据类型用归并排序
 * Kendall距离
 *
 * VisuAlgo, algorithm,Data Structure
 */
public class SortUtil {
    public static Integer[] createArray(){
        Integer[] a=new Integer[15];
        Random r=new Random();
        for(int i=0;i<a.length;i++){
            a[i]=r.nextInt(100);
        }
        return a;
    }

    public static Integer[] createHeapArray() {
        Integer[] a = new Integer[15];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }
        a[0]=0;//第一个元素不管
        return a;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                System.out.println(false);
                return false;
            }
        }
        System.out.println(true);
        return true;
    }
}
