package com.t13max.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 *
 * @author: t13max
 * @since: 10:35 2024/7/23
 */
public class TowSum1 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int target = 3;

        int[] result = towSum(array, target);
        if (result == null) {
            System.out.println("无答案");
            return;
        }
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] towSum(int[] array, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < array.length; i++) {
            int num = array[i];

            Integer other = tempMap.get(num);
            if (other == null) {
                tempMap.put(target - num, i);
                continue;
            }
            if (array[other] + num == target) {
                result[0] = i;
                result[1] = other;
                return result;
            }
        }
        return null;
    }
}
