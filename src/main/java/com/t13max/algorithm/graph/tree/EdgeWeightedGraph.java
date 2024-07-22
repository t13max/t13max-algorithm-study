package com.t13max.algorithm.graph.tree;


import com.t13max.utils.Bag;

/**
 * 加权无向图
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 22:28
 */
public class EdgeWeightedGraph {
    private final int V;//顶点数目
    private int E;//边数目
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

    public static EdgeWeightedGraph createEdgeWeightedGraph() {
        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(8);
        edgeWeightedGraph.addEdge(new Edge(4, 5, 0.35));
        edgeWeightedGraph.addEdge(new Edge(4, 7, 0.37));
        edgeWeightedGraph.addEdge(new Edge(5, 7, 0.28));
        edgeWeightedGraph.addEdge(new Edge(0, 7, 0.16));
        edgeWeightedGraph.addEdge(new Edge(1, 5, 0.32));
        edgeWeightedGraph.addEdge(new Edge(0, 4, 0.38));
        edgeWeightedGraph.addEdge(new Edge(2, 3, 0.17));
        edgeWeightedGraph.addEdge(new Edge(1, 7, 0.19));
        edgeWeightedGraph.addEdge(new Edge(0, 2, 0.26));
        edgeWeightedGraph.addEdge(new Edge(1, 2, 0.36));
        edgeWeightedGraph.addEdge(new Edge(1, 3, 0.29));
        edgeWeightedGraph.addEdge(new Edge(2, 7, 0.34));
        edgeWeightedGraph.addEdge(new Edge(6, 2, 0.40));
        edgeWeightedGraph.addEdge(new Edge(3, 6, 0.52));
        edgeWeightedGraph.addEdge(new Edge(6, 0, 0.58));
        edgeWeightedGraph.addEdge(new Edge(6, 4, 0.93));
        return edgeWeightedGraph;
    }
}
