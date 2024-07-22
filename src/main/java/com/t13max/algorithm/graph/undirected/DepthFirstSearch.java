package com.t13max.algorithm.graph.undirected;

/**
 * 深度优先搜索
 *
 * 深度优先搜索标记与起点连通的所有顶点所需时间和顶点的度数之和成正比
 *
 * @Author 呆呆
 * @Datetime 2021/9/20 19:42
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {//此顶点的所有连接的顶点返回 进行遍历
            if (!marked[w]) dfs(G, w);//每个顶点在递归
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }


}
