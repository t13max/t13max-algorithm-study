package com.t13max.algorithm.graph.sp;


import com.t13max.utils.Queue;
import com.t13max.utils.StdOut;

import java.util.Stack;

/**
 * 基于队列的BellmanFord算法
 * 不是特别懂 哎
 * @Author 呆呆
 * @Datetime 2021/9/24 22:17
 */
public class BellmanFordSP {
    private static final double EPSILON = 1E-14;
    private double[] distTo;//到起点的权重
    private DirectedEdge[] edgeTo;//上一
    boolean[] onQ;//是否在队列中
    private Queue<Integer> queue;//队列
    private int cost;//relax的调用次数
    private Iterable<DirectedEdge> cycle;//是否有负权重的环

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<>();
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        queue.enqueue(s);//入队
        onQ[s] = true;//在队列中
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight() + EPSILON) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQ[w]) {//不在就加进去
                    queue.enqueue(w);
                    onQ[w] = true;//在队列里了
                }
            }
            if (cost++ % G.V() == 0) {
                findNegativeCycle();
                if (hasNegativeCycle()) return;  //负权重环
            }
        }
    }

    /**
     * Is there a negative cycle reachable from the source vertex {@code s}?
     *
     * @return {@code true} if there is a negative cycle reachable from the
     * source vertex {@code s}, and {@code false} otherwise
     */
    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    /**
     * Returns a negative cycle reachable from the source vertex {@code s}, or {@code null}
     * if there is no such cycle.
     *
     * @return a negative cycle reachable from the soruce vertex {@code s}
     * as an iterable of edges, and {@code null} if there is no such cycle
     */
    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }

    // by finding a cycle in predecessor graph
    private void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++)
            if (edgeTo[v] != null)
                spt.addEdge(edgeTo[v]);

        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(spt);
        cycle = finder.cycle();
    }

    /**
     * Returns the length of a shortest path from the source vertex {@code s} to vertex {@code v}.
     *
     * @param v the destination vertex
     * @return the length of a shortest path from the source vertex {@code s} to vertex {@code v};
     * {@code Double.POSITIVE_INFINITY} if no such path
     * @throws UnsupportedOperationException if there is a negative cost cycle reachable
     *                                       from the source vertex {@code s}
     * @throws IllegalArgumentException      unless {@code 0 <= v < V}
     */
    public double distTo(int v) {
        validateVertex(v);
        if (hasNegativeCycle())
            throw new UnsupportedOperationException("Negative cost cycle exists");
        return distTo[v];
    }

    /**
     * Is there a path from the source {@code s} to vertex {@code v}?
     *
     * @param v the destination vertex
     * @return {@code true} if there is a path from the source vertex
     * {@code s} to vertex {@code v}, and {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * Returns a shortest path from the source {@code s} to vertex {@code v}.
     *
     * @param v the destination vertex
     * @return a shortest path from the source {@code s} to vertex {@code v}
     * as an iterable of edges, and {@code null} if no such path
     * @throws UnsupportedOperationException if there is a negative cost cycle reachable
     *                                       from the source vertex {@code s}
     * @throws IllegalArgumentException      unless {@code 0 <= v < V}
     */
    public Iterable<DirectedEdge> pathTo(int v) {
        validateVertex(v);
        if (hasNegativeCycle())
            throw new UnsupportedOperationException("Negative cost cycle exists");
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    // check optimality conditions: either
    // (i) there exists a negative cycle reacheable from s
    //     or
    // (ii)  for all edges e = v->w:            distTo[w] <= distTo[v] + e.weight()
    // (ii') for all edges e = v->w on the SPT: distTo[w] == distTo[v] + e.weight()
    private boolean check(EdgeWeightedDigraph G, int s) {

        // has a negative cycle
        if (hasNegativeCycle()) {
            double weight = 0.0;
            for (DirectedEdge e : negativeCycle()) {
                weight += e.weight();
            }
            if (weight >= 0.0) {
                System.err.println("error: weight of negative cycle = " + weight);
                return false;
            }
        }

        // no negative cycle reachable from source
        else {

            // check that distTo[v] and edgeTo[v] are consistent
            if (distTo[s] != 0.0 || edgeTo[s] != null) {
                System.err.println("distanceTo[s] and edgeTo[s] inconsistent");
                return false;
            }
            for (int v = 0; v < G.V(); v++) {
                if (v == s) continue;
                if (edgeTo[v] == null && distTo[v] != Double.POSITIVE_INFINITY) {
                    System.err.println("distTo[] and edgeTo[] inconsistent");
                    return false;
                }
            }

            // check that all edges e = v->w satisfy distTo[w] <= distTo[v] + e.weight()
            for (int v = 0; v < G.V(); v++) {
                for (DirectedEdge e : G.adj(v)) {
                    int w = e.to();
                    if (distTo[v] + e.weight() < distTo[w]) {
                        System.err.println("edge " + e + " not relaxed");
                        return false;
                    }
                }
            }

            // check that all edges e = v->w on SPT satisfy distTo[w] == distTo[v] + e.weight()
            for (int w = 0; w < G.V(); w++) {
                if (edgeTo[w] == null) continue;
                DirectedEdge e = edgeTo[w];
                int v = e.from();
                if (w != e.to()) return false;
                if (distTo[v] + e.weight() != distTo[w]) {
                    System.err.println("edge " + e + " on shortest path not tight");
                    return false;
                }
            }
        }

        StdOut.println("Satisfies optimality conditions");
        StdOut.println();
        return true;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

}
