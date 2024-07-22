package com.t13max.algorithm.graph.undirected.cc;

import com.atb.graph.undirected.Graph;

/**
 * 是否为无环图
 * 假设不存在自环或平行边
 *
 * @Author 呆呆
 * @Datetime 2021/9/20 21:16
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) dfs(G, i, i);
        }
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {//此顶点的所有连接的顶点返回 进行遍历
            if (!marked[w]) {//每个顶点在递归
                dfs(G, w, v);//每次递归都吧上一个顶点带过去 用于判断是否成环
            } else if (w != u) {//发现被置为true了 而且还不等于上一个顶点
                hasCycle = true;//说明有环
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
