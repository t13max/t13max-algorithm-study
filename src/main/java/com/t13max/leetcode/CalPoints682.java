package com.t13max.leetcode;

/**
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * <p>
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * <p>
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 *
 * @author: t13max
 * @since: 10:33 2024/7/29
 */
public class CalPoints682 {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println(calPoints(new String[]{"1", "C"}));
    }

    public static int calPoints(String[] operations) {
        int[] scoreArray = new int[operations.length];
        int index = 0;
        for (String operation : operations) {
            switch (operation) {
                case "+" -> scoreArray[index] = scoreArray[index - 1] + scoreArray[index - 2];
                case "D" -> scoreArray[index] = scoreArray[index - 1] * 2;
                case "C" -> {
                    scoreArray[index - 1] = 0;
                    index -= 2;
                }
                default -> scoreArray[index] = Integer.parseInt(operation);
            }
            index++;
        }

        int res = 0;
        for (int score : scoreArray) {
            res += score;
        }
        return res;
    }
}
