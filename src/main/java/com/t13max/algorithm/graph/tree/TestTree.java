package com.t13max.algorithm.graph.tree;

import java.util.Iterator;

/**
 * @Author 呆呆
 * @Datetime 2021/10/23 17:11
 */
public class TestTree {
    public static void main(String[] args) {
        EdgeWeightedGraph edgeWeightedGraph=EdgeWeightedGraph.createEdgeWeightedGraph();
        LazyPrimMST lazyPrimMST=new LazyPrimMST(edgeWeightedGraph);
        print(lazyPrimMST.edges());
        System.out.println("----------------------------------");
        PrimMST primMST=new PrimMST(edgeWeightedGraph);
        print(primMST.getEdge());
        System.out.println("----------------------------------");
        KruskalMST kruskalMST=new KruskalMST(edgeWeightedGraph);
        print(kruskalMST.edges());//区别就是Iterable接口是专门创建新的迭代器的，Iterator接口是一个专门设计迭代器的
    }

    public static void print(Iterable<Edge> integers){
        for (Edge e:integers){
            System.out.println(e);
        }
    }

    public static void print(Iterator<Edge> edges) {
        while (edges.hasNext()){
            System.out.println(edges.next());
        }
    }

    public static void print(Edge[] edges) {
        for (Edge e : edges) {
            System.out.println(e);
        }
    }

}
