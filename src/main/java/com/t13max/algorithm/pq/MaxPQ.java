package com.t13max.algorithm.pq;

/**
 * 优先队列 Max Priority Queue
 * 数组实现(无序) insert就push pop就选择排序的方法找到最大的与边界交换然后删除
 * 数组实现(有序) insert的时候把所有大的右移使数组有序 删除就和栈的pop一样
 * 链表表示法
 * 插入不超过lgN+1(假设只有一个元素 lg1==0 需要比较一次,所以记住 lgN+1) 删除需要2*lgN 一次找出较大的子节点 一次确定是否需要上浮
 * 多叉堆
 * 调整数组大小 加一个空参构造方法 insert的时候翻倍 delmax的时候减半
 * 堆的构造: 从右往左sink() 后面已经是一个堆了 只需要2*N次比较 和N次交换
 *
 * @Author 呆呆
 * @Datetime 2021/9/12 20:28
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];//第零个不用 从1开始
    }



    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;//先++在取值 N初始为零
        swim(N);
        show();
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);//删了一个,大小要减一
        pq[N + 1] = null;//防止对象游离 已经没用了再也访问不到他了 但是JVM垃圾回收还不知道
        sink(1);//把最后一个拿到了第一个 让他开始下沉
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void show() {
        for (Key key : pq) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}
