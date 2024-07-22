package com.t13max.algorithm.string;


import com.t13max.utils.Alphabet;
import com.t13max.utils.BinaryStdIn;
import com.t13max.utils.BinaryStdOut;

/**
 * DNA的压缩和展开
 * DNA都是ACTG碱基
 * (没测过)
 *
 * @Author 呆呆
 * @Datetime 2021/10/12 22:36
 */
public class GEnome {

    public static void main(String[] args) {
        //compress();
    }

    public static void compress() {
        Alphabet DNA = new Alphabet("ACTG");
        String s = BinaryStdIn.readString();
        int N = s.length();
        for (int i = 0; i < N; i++) {
            int d = DNA.toIndex(s.charAt(i));
            BinaryStdOut.write(d, DNA.lgR());//lgR 字母对应的那个数
        }
        BinaryStdOut.close();
    }

    public static void expand() {
        Alphabet DNA = new Alphabet("ACTG");
        int w = DNA.lgR();
        int N = BinaryStdIn.readInt();
        for (int i = 0; i < N; i++) {
            char c = BinaryStdIn.readChar(w);
            BinaryStdOut.write(DNA.toChar(c));
        }
        BinaryStdOut.close();
    }
}
