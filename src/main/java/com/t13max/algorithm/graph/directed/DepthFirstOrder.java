package com.t13max.algorithm.graph.directed;


import com.t13max.algorithm.graph.sp.DirectedEdge;
import com.t13max.algorithm.graph.sp.EdgeWeightedDigraph;
import com.t13max.utils.Queue;
import com.t13max.utils.Stack;

/**
 * 有向图中基于深度优先搜索的顶点排序
 * 画图就好了 简单明了
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 13:12
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;//前序
    private Queue<Integer> post;//后序
    private Stack<Integer> reversePost;//逆后续

    public DepthFirstOrder(Digraph G) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    public DepthFirstOrder(EdgeWeightedDigraph G) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    private void dfs(Digraph G, int v) {
        pre.enqueue(v);//循环递归之前加入队列
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
        post.enqueue(v);//循环递归之后加入队列
        reversePost.push(v);//逆后续(栈是先进后出的) 递归之后加入栈 并且因为是栈 后进先出 所以第一位的是头结点
    }

    private void dfs(EdgeWeightedDigraph G, int v) {
        marked[v] = true;
        pre.enqueue(v);
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }


    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
