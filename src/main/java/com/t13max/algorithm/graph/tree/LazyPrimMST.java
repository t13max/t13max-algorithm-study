package com.t13max.algorithm.graph.tree;


import com.t13max.utils.MinPQ;
import com.t13max.utils.Queue;

/**
 * 最小生成树的Prim算法的延迟实现
 *
 * @Author 呆呆
 * @Datetime 2021/9/22 22:17
 */
public class LazyPrimMST {
    private boolean[] marked;//最小生成树的顶点
    private Queue<Edge> mst;//最小生成树的边
    private MinPQ<Edge> pq;//横切边 包括失效的

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();
        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();//从pq中得到权重最小的边 永远取最小的 下面使劲往里加
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;//跳过失效边
            mst.enqueue(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G,int v){
        marked[v]=true;//标记点V并把和V相连所有未标记的点加入pq
        for(Edge e:G.adj(v)){
            if(!marked[e.other(v)]) pq.insert(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

}
