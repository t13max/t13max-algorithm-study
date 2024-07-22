package com.t13max.algorithm.graph.directed;


/**
 * @Author 呆呆
 * @Datetime 2021/10/23 15:27
 */
public class TestDirectedGraph {
    public static void main(String[] args) {
        Digraph digraph = Digraph.createSimpleDigraph();
        Digraph digraph666 = Digraph.createDigraph();
        DepthFirstOrder depthFirstOrder=new DepthFirstOrder(digraph);
        print(depthFirstOrder.pre());
        print(depthFirstOrder.post());
        print(depthFirstOrder.reversePost());
        System.out.println("----------------------------");
        Topological topological=new Topological(digraph);
        print(topological.order());
        System.out.println("----------------------------");
        //DirectedDFS directedDFS=new DirectedDFS(digraph,0);
        System.out.println("----------------------------");
        KosarajuSCC kosarajuSCC=new KosarajuSCC(digraph666);
        print();
        print(kosarajuSCC.id());
    }
    public static void print(Iterable<Integer> integers){
        for (Integer num:integers){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void print(int[] integers) {
        for (Integer num : integers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void print(){
        for(int i=0;i<12;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
