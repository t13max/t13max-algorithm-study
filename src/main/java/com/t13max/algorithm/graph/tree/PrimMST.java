package com.t13max.algorithm.graph.tree;

import com.t13max.utils.IndexMinPQ;

/**
 * Prim算法的即时实现
 * 空间和V成正比 时间和ElogV
 *
 * @Author 呆呆
 * @Datetime 2021/9/22 23:06
 */
public class PrimMST {
    private Edge[] edgeTo;//距离树最近的边
    private double[] distTo;//权重
    private boolean[] marked;//v在树种则为true
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(G.V());
        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e :
                G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;//另一个顶点也在 那就是无效的 w-v失效
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;//连接w和树的最佳边变为e
                distTo[w] = e.weight();//修改权重
                if (pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Edge[] getEdge() {
        return edgeTo;
    }
}
