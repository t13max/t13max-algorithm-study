package com.t13max.algorithm.graph.directed;

/**
 * 顶点可达性
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 13:51
 */
public class TransitiveClosure {
    private DirectedDFS[] all;

    public TransitiveClosure(Digraph G) {
        all = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DirectedDFS(G, v);
        }
    }

    public boolean reachable(int v, int w) {
        return all[v].marked(w);
    }
}
