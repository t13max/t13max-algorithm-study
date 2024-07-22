package com.t13max.algorithm.graph.directed;

/**
 * 计算强连通分量的Kosaraju算法
 * 反向图的逆后续深度优先搜索的构造方法中每一次递归
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 13:37
 */
public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());//反向图
        for (int s :order.reversePost()) {//逆序是反的 是最后一个节点在第一位 但是逆后续 是第一个节点在第一位
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    public void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int[] id() {
        return id;
    }

    public int count() {
        return count;
    }
}
