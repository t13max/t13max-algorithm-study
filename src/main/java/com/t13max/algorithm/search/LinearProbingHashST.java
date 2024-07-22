package com.t13max.algorithm.search;

/**
 * 基于线性探测的符号表
 *
 * @Author 呆呆
 * @Datetime 2021/9/16 23:05
 */
public class LinearProbingHashST<K, V> {
    private static final int INIT_CAPACITY = 4;
    private int N;
    private int M;//线性探测表的大小
    private K[] keys;
    private V[] values;

    public LinearProbingHashST(int capacity) {
        M = capacity;
        N = 0;
        keys = (K[]) new Object[M];
        values = (V[]) new Object[M];
    }

    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    public int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capacity) {
        LinearProbingHashST<K, V> temp = new LinearProbingHashST<K, V>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        M = temp.M;
    }


    public void put(K key, V value) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;

    }

    public V get(K key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public void delete(K key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        values[i] = null;//找到之后置为null 删除咯
        while (keys[i] != null) {
            K keyToRedo = keys[i];
            V valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo, valueToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) resize(M / 2);//重置大小
    }

    public boolean contains(K key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

}
