package com.t13max.algorithm.string;


import com.t13max.algorithm.graph.directed.Digraph;
import com.t13max.algorithm.graph.directed.DirectedDFS;
import com.t13max.utils.Bag;

import java.util.Stack;

/**
 * 正则表达式的模式匹配
 * 构造长度为M的正则表达式对应的NFA所需的时间和空间与M成正比
 *
 * @Author 呆呆
 * @Datetime 2021/10/11 23:06
 */
public class NFA {
    private char[] re;//匹配转换
    private Digraph G;//epsilon转换
    private int M;//状态数量

    public NFA(String regexp) {
        Stack<Integer> ops = new Stack<>();
        re = regexp.toCharArray();
        M = re.length;
        G = new Digraph(M + 1);
        for (int i = 0; i < M; i++) {
            int lp = i;//左括号的位置
            if (re[i] == '(' || re[i] == '|') {
                ops.push(i);
            } else if (re[i] == ')') {
                int or = ops.pop();//先出栈 在判断
                if (re[or] == '|') {//是或者 那就是或者的下一位到右括号
                    lp = ops.pop();//再出一栈 左括号 出栈
                    G.addEdge(lp, or + 1);//左括号到或+1
                    G.addEdge(or, i);//或到i
                } else {
                    lp = or;//没有或 那左括号就是右括号出栈对应左括号
                }
            }
            if (i < M - 1 && re[i + 1] == '*') {//下一位是* 任意 那就是再指回去
                G.addEdge(lp, i + 1);//那就i到i+1 和i+1到i 两个顶点互相指
                G.addEdge(i + 1, lp);
            }
            if (re[i] == '(' || re[i] == '*' || re[i] == ')') {//指向下一位
                G.addEdge(i, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        NFA nfa = new NFA("((A*B|AC)D)");
        boolean result = nfa.recognizes("AAAABD");
        System.out.println(result ? "匹配" : "不匹配");
    }

    public boolean recognizes(String txt) {
        Bag<Integer> pc = new Bag<>();
        DirectedDFS dfs = new DirectedDFS(G, 0);//有向图可达
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) pc.add(v);//pc记录的是起点0开始的可达性
        }
        for (int i = 0; i < txt.length(); i++) {//循环遍历每个字符都是在这个有向图中是可达的
            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v < M)
                    if (re[v] == txt.charAt(i) || re[v] == '.')//'.'是任意字符
                        match.add(v + 1);//看看pc里的点和要匹配的字符串能不能对上
            }
            pc = new Bag<>();
            dfs = new DirectedDFS(G, match);//多个顶点为起点的可达性
            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) pc.add(v);
            }
        }
        for (int v : pc) {//上面是看看能到哪 这是看看符不符合
            if (v == M) return true;//检查v有没有符合的
        }
        return false;
    }
}
