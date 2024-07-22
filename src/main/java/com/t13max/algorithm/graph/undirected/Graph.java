package com.t13max.algorithm.graph.undirected;

import com.atb.utils.Bag;
import com.atb.utils.In;

/**
 * 都没测过555555
 * 无向图
 *
 * @Author 呆呆
 * @Datetime 2021/9/20 13:02
 */
public class Graph {
    private final int V;//顶点数目 vertices
    private int E;//边数目
    private Bag<Integer>[] adj;//里面是一个链表 记录的是所有和他相连的边 链表的的顺序没任何关系 只是加入顺序

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Bag<Integer>[]) new Object[V];//和某顶点相邻的所有顶点
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();//和某顶点相邻的所有顶点
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {//添加边 所以不存在重复的问题 一条边只会被添加一次 不是顶点
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public static Graph createGraph(){
        Graph graph=new Graph(6);
        graph.addEdge(0,5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.addEdge(3,5);
        graph.addEdge(3,4);
        return graph;
    }
}
