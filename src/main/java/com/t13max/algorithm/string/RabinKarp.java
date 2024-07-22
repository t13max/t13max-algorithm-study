package com.t13max.algorithm.string;

import java.math.BigInteger;
import java.util.Random;

/**
 * 指纹字符串查找算法
 *
 * @Author 呆呆
 * @Datetime 2021/10/10 20:06
 */
public class RabinKarp {
    private String pat;     //模式串
    private long patHash;   //模式串的hash
    private int M;          //模式串的长度
    private long Q;         //一个很大的素数
    private int R = 256;    //进制
    private long RM;        //

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        Q = longRandomPrime();
        RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
        patHash = hash(pat, M);
    }

    public static void main(String[] args) {
        RabinKarp rabinKarp = new RabinKarp("NEEDLE");
        int i = rabinKarp.search("HFUIASHNEESDLEDFNEEDDLEANEEDLEPOIJFLKSLDJ");
        System.out.println("匹配的位置为" + i);
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++) {
            h = (R * h + key.charAt(j)) % Q;//(一个字符一个字符的算 永远是 之前的hash值*进制+当前字符的值)取余一个Q
        }
        return h;
    }

    public boolean check(int i) {
        return Boolean.TRUE;
    }

    private boolean check(String txt, int i) {
        for (int j = 0; j < M; j++)
            if (pat.charAt(j) != txt.charAt(i + j))
                return false;
        return true;
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());//生成一个大素数
        return prime.longValue();
    }

    public int search(String txt) {
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash && check(0)) return 0;//一开始就匹配成功
        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash) {
                if (check(i - M + 1)) return i - M + 1;//找到匹配
            }
        }
        return N;//未找到
    }
}
