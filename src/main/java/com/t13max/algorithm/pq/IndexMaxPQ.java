package com.t13max.algorithm.pq;

/**
 * 索引优先队列
 * 没测过好不好使 还是看看书吧
 *
 * @Author 呆呆
 * @Datetime 2021/9/12 21:57
 */
public class IndexMaxPQ<Key extends Comparable<Key>> {
    private int[] pq;
    private int[] qp;//逆序 好家伙 直接把俩字母反过来写
    private int N = 0;
    private Key[] keys;//有优先级之分的元素

    public IndexMaxPQ(int maxN) {
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            qp[i] = -1;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void insert(int k, Key key) {
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }

    public Key min() {
        return keys[pq[1]];
    }

    public int delMin() {
        int minIndex = pq[1];
        exch(1, N--);
        sink(1);
        keys[pq[N + 1]] = null;
        qp[pq[N + 1]] = -1;
        return minIndex;
    }

    public int minIndex() {
        return pq[1];
    }

    public void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public void delete(int k) {
        int index = qp[k];
        exch(index, N--);
        swim(index);
        sink(index);
        keys[k] = null;
        qp[k] = -1;
    }

    /**
     * 下面四个方法不知道行不行 上面的照着写也不一定对 哈哈
     */
    private boolean less(int i, int j) {
        return keys[i].compareTo(keys[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = keys[i];
        keys[i] = keys[j];
        keys[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && !less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && !less(j, j + 1)) j++;
            if (less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void show() {
        for (Key key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}
