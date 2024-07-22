package com.t13max.algorithm.graph.undirected;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 广度优先 路径
 *
 * @Author 呆呆
 * @Datetime 2021/9/20 20:36
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        LinkedList<Integer> list = new LinkedList<>();//整一个可以先进先出的队列
        marked[s] = true;//起点置为true
        list.addLast(s);//把起点压入栈
        while (!list.isEmpty()) {
            int v = list.removeFirst();//开始循环遍历
            for (int w : G.adj(v)) {//拿到栈第一个节点的所有相连节点
                edgeTo[w] = v;//记录上一节点
                marked[w] = true;//置为true
                list.addLast(w);//入栈
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {//每次都是此顶点的上一个顶点
            path.push(x);
        }
        path.push(s);//最后是头
        return path;
    }
}
