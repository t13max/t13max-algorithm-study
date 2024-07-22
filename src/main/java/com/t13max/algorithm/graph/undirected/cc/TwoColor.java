package com.t13max.algorithm.graph.undirected.cc;


import com.t13max.algorithm.graph.undirected.Graph;

/**
 * 是否为二分图(双色问题)
 *
 * @Author 呆呆
 * @Datetime 2021/9/20 21:27
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable;

    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) dfs(G, i);
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {//此顶点的所有连接的顶点返回 进行遍历
            if (!marked[w]) {//每个顶点在递归
                color[w] = !color[v];//和前一个颜色不同
                dfs(G, w);
            } else if (color[w] == color[v]) {//找到了一个到过的节点 发现颜色还是一样的
                isTwoColorable = false;//说明不是 和上一个颜色相同了
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}
