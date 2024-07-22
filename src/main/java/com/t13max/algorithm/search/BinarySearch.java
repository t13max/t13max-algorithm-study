package com.t13max.algorithm.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 基于有序数组的二分查找
 * 最多lgN+1次比较
 * <p>
 *
 * @Author 呆呆
 * @Datetime 2021/9/13 22:40
 */
public class BinarySearch<K extends Comparable, V> {
    private K[] keys;//key的数组
    private V[] values;//value的数组
    private int N;//大小

    public BinarySearch(int capacity) {
        keys = (K[]) new Comparable[capacity];//调整数组大小的标准代码在1.1节 我估计就是添加的时候不够了就乘2 删除了少于一半就减小之类的
        values = (V[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public V get(K key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return values[i];
        else return null;
    }

    //基于有序数组的二分查找
    public int rank(K key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;//保证mid永远在剩余的里面的中间的位置
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;//没找到
    }

    //递归的二分查找
    public int rank(K key, int lo, int hi) {
        System.out.println("递归的二分查找还没测过!");
        if (hi < lo) return lo;//没找到 返回比他小一点的那个
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) return rank(key, lo, mid - 1);
        else if (cmp > 0) return rank(key, mid + 1, hi);
        else return mid;
    }

    public void put(K key, V value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {//命中 修改值
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {//插入 后面保持有序 N不用减一,因为总数要加一N的位置刚好是最后一个要挪到的位置
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];//保持有序
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(K key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {//命中 删掉
            for (int j = i; j < N; j++) {
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];//保持有序
            }
            N--;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public K min() {
        return keys[0];
    }

    public K max() {
        return keys[N - 1];
    }

    public K select(int i) {
        return keys[i];
    }

    //上限
    public K ceiling(K key) {
        int i = rank(key);
        return keys[i];
    }

    //下限
    public K floor(K key) {
        System.out.println("floor方法还没写好!");
        return key;
    }

    public Iterator<K> keys(K lo, K hi) {
        System.out.println("keys方法还没写好!");
        List<K> list = new ArrayList<K>();
        for (int i = rank(lo); i < rank(hi); i++) {
            list.add(keys[i]);
        }
        if (contains(hi)) {
            list.add((keys[rank(hi)]));
        }
        return list.iterator();
    }

    public boolean contains(K key) {
        System.out.println("contains方法还没写好!");
        return false;
    }


}
