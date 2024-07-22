package com.t13max.algorithm.graph.directed;


import com.t13max.algorithm.graph.sp.EdgeWeightedDigraph;
import com.t13max.algorithm.graph.sp.EdgeWeightedDirectedCycle;

/**
 * 拓扑排序
 * 拓扑排序就是逆后续排列
 * 所需时间和V+E成正比
 * 任务调度 完成一些活有可能需要有前提 需要先完成其他的东西
 * 后序 因为后完成的要先被记录下来 逆 因为最终的顺序是倒过来的
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 13:20
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle directedCycle = new DirectedCycle(G);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Topological(EdgeWeightedDigraph G) {
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }

    public boolean hasOrder() {
        return order != null;
    }

}
