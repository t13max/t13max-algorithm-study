package com.t13max.algorithm.string;

/**
 * 暴力子字符串
 * Knuth-Morris-Pratt子字符串查找算法
 * DFA 确定有点状态自动机
 *
 * @Author 呆呆
 * @Datetime 2021/10/8 23:06
 */
public class KMP {

    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];//需要回退的位数 是下一个要比较的位置
        dfa[pat.charAt(0)][0] = 1;//第一个字符的0设置为1
        for (int x = 0, j = 1; j < M; j++) {//j是模式中的第几个 虽然不知道为啥 但是x记录的总是上个可以直接照搬的记录状态
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];//复制匹配失败情况下的值
            }
            dfa[pat.charAt(j)][j] = j + 1;//设置匹配成功情况下的值 //正确的字符的对应位置设置为j+1 就是下一个
            x = dfa[pat.charAt(j)][x];//更新重启状态  匹配失败 回到的状态就那一个 在那个状态的所有字符的状态都直接复制过来就行了
        }
    }

    public int search(String txt) {
        int i, j, N = txt.length(), M = pat.length();
        for (j = 0, i = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];//对应字符的对应状态(12345的那个) 看看是否有一个能到达最终状态
        }
        if (j == M) return i - M;    //找到匹配
        else return N;          //未找到匹配
    }

    public static void main(String[] args) {
        KMP kmp1 = new KMP("ABABAC");
        KMP kmp = new KMP("NEEDLE");
        System.out.println("正确答案为" + "HFUIASHNEESDLEDFNEEDDLEA".length());
        System.out.println("---------------------------");
        System.out.println("KMP算法匹配的位置为" + kmp.search("HFUIASHNEESDLEDFNEEDDLEANEEDLEPOIJFLKSLDJ"));
        System.out.println("---------------------------");
        System.out.println("暴力子字符串查找的位置为" + violenceSearch("NEEDLE", "HFUIASHNEESDLEDFNEEDDLEANEEDLEPOIJFLKSLDJ"));
        System.out.println("---------------------------");
        System.out.println("显示回退暴力子字符串查找的位置为" + violenceSearch_666("NEEDLE", "HFUIASHNEESDLEDFNEEDDLEANEEDLEPOIJFLKSLDJ"));
    }

    //暴力子字符串查找
    public static int violenceSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {//文本长度减去模式长度 大于了说明永远不可能匹配了 不需要在匹配了
            int j;
            for (j = 0; j < M; j++) {//一位一位的比较
                if (txt.charAt(i + j) != pat.charAt(j)) break;
            }
            if (j == M) return i;
        }
        return N;//未找到
    }

    //暴力子字符串查找 显示回退
    public static int violenceSearch_666(String pat, String txt) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {//如果找到了会因为j<M跳出循环
            if (txt.charAt(i) == pat.charAt(j)) j++;//匹配上了继续比
            else {//没匹配上回退
                i -= j;
                j = 0;
            }
        }
        if (j == M) return i - M;//找到啦
        else return N;//未找到
    }
}
