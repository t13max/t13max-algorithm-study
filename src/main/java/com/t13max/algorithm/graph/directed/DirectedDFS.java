package com.t13max.algorithm.graph.directed;

/**
 * 有向图的可达性
 * 标记清除的垃圾回收机制
 * (就是深度优先检索)
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 11:51
 */
public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {//多个顶点为起点的可达性
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s]) dfs(G, s);
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }


}
