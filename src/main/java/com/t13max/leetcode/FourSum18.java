package com.t13max.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * 提示：
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * @Author t13max
 * @Date 10:20 2025/9/2
 */
public class FourSum18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //枝剪 快速失败
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        while (true) {
                            int old = nums[right];
                            right--;
                            if (old != nums[right]) {
                                break;
                            }
                            if (right < left) {
                                break;
                            }
                        }
                        while (true) {
                            int old = nums[left];
                            left++;
                            if (old != nums[left]) {
                                break;
                            }
                            if (right < left) {
                                break;
                            }
                        }
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSumLeetCode(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {

        //System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));//[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        //System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));//[[2,2,2,2]]
        //System.out.println(fourSum(new int[]{0, 0, 0, 0}, 0));//[[0,0,0,0]]
        //System.out.println(fourSum(new int[]{-1,0,1,2,-1,-4}, -1));//[[-4,0,1,2],[-1,-1,0,1]]
        //System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));//[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        //System.out.println(fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));//[[-2,-1,1,2],[-1,-1,1,1]]
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));//[]
    }
}
