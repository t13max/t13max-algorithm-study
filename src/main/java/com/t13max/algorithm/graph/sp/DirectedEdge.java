package com.t13max.algorithm.graph.sp;

/**
 * 加权有向边
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 19:11
 */
public class DirectedEdge implements Comparable<DirectedEdge> {

    private final int v;//起点
    private final int w;//终点
    private final double weight;//边的权重

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    @Override
    public int compareTo(DirectedEdge that) {//比较权重
        if (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
