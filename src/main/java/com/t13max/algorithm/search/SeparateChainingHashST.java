package com.t13max.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于拉链法的散列表
 * N/M
 * 在顺序不重要的时候最快
 * 有问题根本运行不了 傻逼
 * 散列表
 * 代码简单 查找时间最优
 * 软缓存
 *
 * @Author 呆呆
 * @Datetime 2021/9/16 22:36
 */
public class SeparateChainingHashST<K, V> {
    private static final int INIT_CAPACITY = 4;
    private int N;//键值对总数
    private int M;//散列表大小
    private SeparateChainingHashST<K, V>[] st;//存放链表对象的数组

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);//动态调整数组大小更加可靠
    }

    public SeparateChainingHashST(int m) {
        M = m;
        st = (SeparateChainingHashST<K, V>[]) new SeparateChainingHashST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SeparateChainingHashST();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public V get(K key) {
        return (V) st[hash(key)].get(key);
    }

    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (value == null) {
            delete(key);
            return;
        }
        if (N >= 10 * M) resize(2 * M);
        int i = hash(key);
        if (!st[i].contains(key)) N++;
        st[i].put(key, value);
    }

    public boolean contains(K key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) N--;
        st[i].delete(key);

        // halve table size if average length of list <= 2
        if (M > INIT_CAPACITY && N <= 2 * M) resize(M / 2);
    }

    private void resize(int chains) {
        SeparateChainingHashST<K, V> temp = new SeparateChainingHashST<K, V>(chains);
        for (int i = 0; i < M; i++) {
            for (K key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.M = temp.M;
        this.N = temp.N;
        this.st = temp.st;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<K> keys() {
        List<K> list = new ArrayList<K>();
        for (int i = 0; i < M; i++) {
            for (K key : st[i].keys())
                list.add(key);
        }
        return list;
    }

    /*public Iterable<K> keys(){
        return
    }*/
}
