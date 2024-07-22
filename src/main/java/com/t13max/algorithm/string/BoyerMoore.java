package com.t13max.algorithm.string;

/**
 * N/M次比较
 * 倒着匹配 速度更快
 *
 * @Author 呆呆
 * @Datetime 2021/10/10 19:09
 */
public class BoyerMoore {
    private int[] right;
    private String pat;

    public BoyerMoore(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;//初始化为负一 到时候直接减这个就能把两种情况合并 --1就相当于加1了
        }
        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j;//包含在模式中的字符的值设置为他在其中出现的最右的位置
        }
    }

    public int search(String txt) {
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {//倒着来
                if (pat.charAt(j) != txt.charAt(i + j)) {//不相等 准备跳
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            }
            if (skip == 0) return i;//找到匹配
        }
        return N;//未找到匹配
    }

    public static void main(String[] args) {
        BoyerMoore boyerMoore = new BoyerMoore("NEEDLE");
        int i = boyerMoore.search("HFUIASHNEESDLEDFNEEDDLEANEEDLEPOIJFLKSLDJ");
        System.out.println("匹配的位置为" + i);
    }
}
