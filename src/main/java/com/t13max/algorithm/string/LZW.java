package com.t13max.algorithm.string;

import com.atb.utils.BinaryStdIn;
import com.atb.utils.BinaryStdOut;

/**
 * LZW算法的压缩
 *
 * @Author 呆呆
 * @Datetime 2021/10/14 22:51
 */
public class LZW {
    private static final int R = 256;//输入的字符数
    private static final int L = 4096;//编码总数 2^12
    private static final int W = 12;//编码宽度

    public static void compress() {
        String input = BinaryStdIn.readString();//读一个字符串
        TST<Integer> st = new TST<>();//新建一个三向单词查找树
        for (int i = 0; i < R; i++) {
            st.put("" + (char) i, i);//给每一个字符设置值
        }
        int code = R + 1;
        while (input.length() > 0) {
            String s = st.longestPrefixOf(input);//找到最长前缀
            BinaryStdOut.write(st.get(s), W);
            int t = s.length();
            if (t < input.length() && code < L) {
                st.put(input.substring(0, t + 1), code++);//把s加入符号表
            }
            input = input.substring(t);//从输入中读取s    substring是从第几位开始 前面不要了!!!
        }
        BinaryStdOut.write(R, W);//R是80 保留的结束编码 W是编码宽度
        BinaryStdOut.close();
    }

    public static void expand() {
        String[] st = new String[L];
        int i;
        for (i = 0; i < R; i++) {
            st[i] = "" + (char) i;
        }
        st[i++] = "";//R是结束编码
        int codeword = BinaryStdIn.readInt(W);//取一个数字 第一个字符 'A'
        String val = st[codeword];//在字符串数组里找到
        while (true) {
            BinaryStdOut.write(val);
            codeword = BinaryStdIn.readInt(W);//已经是第 "二" 字符了 'B'
            if (codeword == R) {//结束编码
                break;
            }
            String s = st[codeword];
            if (i == codeword) {//特殊情况 要加的那个刚好是刚读到的
                s = val + val.charAt(0);
            }
            if (i < L) {
                st[i++] = val + s.charAt(0);//把"AB"加进去了
            }
            val = s;
        }
        BinaryStdOut.close();

    }

}
