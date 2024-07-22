package com.t13max.algorithm.graph.directed;


import com.t13max.utils.Stack;

/**
 * 寻找有向环
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 12:17
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {//找有向环 所以是从每个起点都出发试一下
            if (!marked[i]) dfs(G, i);
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : G.adj(v)) {//此顶点的所有连接的顶点返回 进行遍历
            if (this.hasCycle()) {//有环return
                return;
            } else if (!marked[w]) {//每个顶点在递归 没被标记过 第一次到
                edgeTo[w] = v;//记录此顶点的上一个顶点
                dfs(G, w);//继续递归
            } else if (onStack[w]) {//被标记过 而且还在环栈里
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {//w用于判断跳出循环
                    cycle.push(x);
                }
                cycle.push(w);//插入最后一个
                cycle.push(v);//一圈回到v
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
