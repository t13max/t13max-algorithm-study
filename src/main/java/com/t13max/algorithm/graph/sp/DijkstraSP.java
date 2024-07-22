package com.t13max.algorithm.graph.sp;

import com.atb.utils.IndexMinPQ;
import com.atb.utils.Stack;


/**
 * Dijkstra算法
 *
 * @Author 呆呆
 * @Datetime 2021/9/23 22:48
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo;//到达起点的路上的上一节点
    private double[] distTo;//到达起点的最小权重之和
    private IndexMinPQ<Double> pq;//保存被放松的节点 就是把边往里加 找到最小的拿出来(删掉) 索引优先队列 维护一个索引+一个你想保存的东西

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;//所有赋值为正无穷
        }
        distTo[s] = 0.0;//起点为0.0
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {//计算当前顶点的权重加上某条边的权重和那个顶点的权重比较
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;//到达此顶点的边也变成这条边
                if (pq.contains(w)) pq.change(w, distTo[w]);//如果w已经在里面了 <就形成环了>什么玩意儿???  明明是 如果存在就要替换成这个
                else pq.insert(w, distTo[w]);//不存在就新插入
            }
        }
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {//从哪来的 一路回去 入栈
            path.push(e);
        }
        return path;
    }

    /**
     * 验证这个节点是否在这个图里面 是否超出了大小 是否合法
     *
     * @return void
     * @Author 呆呆
     * @Date 2021/10/24 13:20
     * @Param [v]
     **/
    private void validateVertex(int v) {
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }
}
