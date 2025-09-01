package com.t13max.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 *
 * @author t13max
 * @since 12:43 2025/9/1
 */
public class FindIndex35 {


    public static int findIndex(int[] array, int target) {
        int length = array.length;
        return findIndex(array, 0, length - 1, target);
    }

    public static int findIndex(int[] array, int start, int end, int target) {
        if (end < start) return 0;

        int index = (start + end) / 2;

        if (array[index] == target) {
            return index;
        } else if (array[index] > target) {
            return findIndex(array, 0, index - 1, target);
        } else {
            if (index + 1 > end) {
                return index + 1;
            }
            return findIndex(array, index + 1, end, target);
        }
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 6};
        System.out.println(findIndex(array, 5));//2
        System.out.println(findIndex(array, 2));//1
        System.out.println(findIndex(array, 7));//4

        int[] array1 = new int[]{1};
        System.out.println(findIndex(array1, 0));//0
        System.out.println(findIndex(array1, 1));//0
        System.out.println(findIndex(array1, 2));//1

        int[] array2 = new int[]{1, 3};
        System.out.println(findIndex(array2, 0));//0
        System.out.println(findIndex(array2, 1));//0
        System.out.println(findIndex(array2, 2));//1
        System.out.println(findIndex(array2, 3));//1
        System.out.println(findIndex(array2, 4));//2
    }

}
