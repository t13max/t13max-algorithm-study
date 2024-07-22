package com.t13max.algorithm.string;

/**
 * 低位优先的字符串排序
 *
 * @Author 呆呆
 * @Datetime 2021/9/26 22:25
 */
public class LSD {
    public static void main(String[] args) {
        sort(strs(),7);
    }

    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String aux[] = new String[N];
        for (int d = W - 1; d >= 0; d--) {//每个字符串有多少位 循环多少次 从最低位开始比较 按照顺序排列
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++) {//计算出现频率 a[i]是遍历字符串数组 charAt找字符 d就是倒着排 第几个
                count[a[i].charAt(d) + 1]++;//那个字符的ASIIC码+1的数量+1 计算出频率
            }
            for (int r = 0; r < R; r++) {//将频率转换为索引 就是最后要放的位置
                count[r + 1] += count[r];
            }
            for (int i = 0; i < N; i++) {//将元素分类
                aux[count[a[i].charAt(d)]++] = a[i];//a[i]是那个字符串 a[i].charAt(d)是那个字符 ++就是之前记录的那个了 在count里找到 对应的索引
            }
            for (int i = 0; i < N; i++) {//回写
                a[i] = aux[i];
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static String[] strs(){
        String[] result={
                "4PGC938",
                "2IYE230",
                "3CIO720",
                "1ICK750",
                "1OHV845",
                "4JZY524",
                "1ICK750",
                "3CIO720",
                "1OHV845",
                "1OHV845",
                "2RLA629",
                "2RLA629",
                "3ATW723",
        };
        return result;
    }
}
