package com.t13max.algorithm.graph.sp;


/**
 * Dijkstra 找到任意两点之间的最短路径
 *
 * @Author 呆呆
 * @Datetime 2021/9/23 23:03
 */
public class DijkstraAllPairSP {
    private DijkstraSP[] all;

    public DijkstraAllPairSP(EdgeWeightedDigraph G) {
        all = new DijkstraSP[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DijkstraSP(G, v);
        }
    }

    public Iterable<DirectedEdge> path(int s, int t) {
        return all[s].pathTo(t);
    }

    public double dist(int s, int t) {
        return all[s].distTo(t);
    }
}
