package com.t13max.algorithm.graph.tree;


import com.t13max.utils.MinPQ;
import com.t13max.utils.Queue;
import com.t13max.utils.UF;

import java.util.Iterator;

/**
 * kruskal算法
 *
 * @Author 呆呆
 * @Datetime 2021/9/22 23:34
 */
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : G.edges()) pq.insert(e);
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v=e.either(),w=e.other(v);
            if(uf.connected(v,w)) continue;
            uf.union(v,w);
            mst.enqueue(e);
        }
    }

    public Iterator<Edge> edges(){
        return mst.iterator();
    }
}
