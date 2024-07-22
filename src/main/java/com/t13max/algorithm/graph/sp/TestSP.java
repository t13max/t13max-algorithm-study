package com.t13max.algorithm.graph.sp;

/**
 * @Author 呆呆
 * @Datetime 2021/10/24 12:54
 */
public class TestSP {
    public static void main(String[] args) {
        EdgeWeightedDigraph edgeWeightedDigraph = EdgeWeightedDigraph.createEdgeWeightedDigraph();
        EdgeWeightedDigraph acyclic = EdgeWeightedDigraph.createAcyclic();
        DijkstraSP dijkstraSP = new DijkstraSP(edgeWeightedDigraph, 0);
        print(dijkstraSP.pathTo(1));
        print(dijkstraSP.pathTo(6));
        AcyclicSP acyclicSP=new AcyclicSP(acyclic);
        print(acyclicSP.pathTo(0));
        print(acyclicSP.pathTo(2));
        print(acyclicSP.pathTo(6));
        BellmanFordSP bellmanFordSP = new BellmanFordSP(edgeWeightedDigraph,0);
        print(bellmanFordSP.pathTo(1));
        print(bellmanFordSP.pathTo(6));
    }

    public static void print(Iterable<DirectedEdge> integers) {
        for (DirectedEdge e : integers) {
            System.out.println(e + " ");
        }
        System.out.println("-----------------------------");
    }
}
