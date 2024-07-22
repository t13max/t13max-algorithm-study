package com.t13max.algorithm.graph.undirected;


import com.t13max.utils.Stack;

/**
 * 深度优先 路径
 *
 * @Author 呆呆
 * @Datetime 2021/9/20 20:17
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;//某个节点的上一节点
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {//此顶点的所有连接的顶点返回 进行遍历
            if (!marked[w]) {//每个顶点在递归
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {//每次都是此顶点的上一个顶点 x!=s用于判断跳出循环
            path.push(x);
        }
        path.push(s);//最后是头 上面用于判断跳出 所以这里加一下头结点
        return path;
    }
}
