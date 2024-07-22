package com.t13max.algorithm.graph.directed;


import com.t13max.utils.Bag;

/**
 * 有向图
 *
 * @Author 呆呆
 * @Datetime 2021/9/20 21:54
 */
public class Digraph {
    private final int V;//顶点数目
    private int E;//边数目
    private Bag<Integer>[] adj;//里面是一个链表 记录的是所有和他相连的边 链表的的顺序没任何关系 只是加入顺序

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);//单向
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {//从第一个顶点开始遍历
            for (int w : adj[v]) {//把他所有指向的顶点拎出来遍历
                R.addEdge(w, v);//反向加入
            }
        }
        return R;
    }

    public static Digraph createDigraph() {
        Digraph digraph = new Digraph(13);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 5);
        //digraph.addEdge(0, 6);
        digraph.addEdge(2, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(3, 5);
        digraph.addEdge(4, 2);
        digraph.addEdge(4, 3);
        digraph.addEdge(5, 4);
        digraph.addEdge(6, 0);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        digraph.addEdge(7, 8);
        digraph.addEdge(8, 7);
        digraph.addEdge(8, 9);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(10, 12);
        digraph.addEdge(11, 4);
        digraph.addEdge(11, 12);
        digraph.addEdge(12, 9);
        return digraph;
    }

    public static Digraph createSimpleDigraph() {
        Digraph digraph = new Digraph(13);
        digraph.addEdge(0, 6);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 5);
        digraph.addEdge(2, 3);
        digraph.addEdge(2, 0);
        digraph.addEdge(3, 5);
        digraph.addEdge(5, 4);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        digraph.addEdge(8, 7);
        digraph.addEdge(9, 12);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(11, 12);
        return digraph;
    }
}
