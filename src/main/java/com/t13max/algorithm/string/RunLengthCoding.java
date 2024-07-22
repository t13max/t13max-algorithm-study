package com.t13max.algorithm.string;

import com.atb.utils.BinaryStdIn;
import com.atb.utils.BinaryStdOut;

/**
 * 游程编码
 * (没测过)
 *
 * @Author 呆呆
 * @Datetime 2021/10/12 23:09
 */
public class RunLengthCoding {

    public static void expand() {
        boolean b = false;
        while (!BinaryStdIn.isEmpty()) {//一个一个读
            char cnt = BinaryStdIn.readChar();
            for (int i = 0; i < cnt; i++) {//记录多少次 就写多少个
                BinaryStdOut.write(b);
            }
            b = !b;
        }
        BinaryStdOut.close();
    }

    public static void compress() {
        char cnt = 0;
        boolean b, old = false;
        while (!BinaryStdIn.isEmpty()) {
            b = BinaryStdIn.readBoolean();//一行 用true false 就是 1 0
            if (b != old) {//和前一个不同了
                BinaryStdOut.write(cnt);//记录之前的个数
                cnt = 0;//清零
                old = !old;//变另一个了
            } else {
                if (cnt == 255) {
                    BinaryStdOut.write(cnt);
                    cnt = 0;
                    BinaryStdOut.write(cnt);
                }
            }
            cnt++;
        }
        BinaryStdOut.write(cnt);//全读完了 最后一个写入
        BinaryStdOut.close();
    }
}
