package com.t13max.leetcode;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * 提示：
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *
 * @Author t13max
 * @Date 11:11 2025/9/3
 */
public class SearchRotateSortArray33 {


    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    public static int search(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int index = (start + end) / 2;
        int startNum = nums[start];
        int endNum = nums[end];
        int indexNum = nums[index];
        if (indexNum == target) {
            return index;
        } else if (indexNum >= startNum) {
            if (endNum == target) {
                return end;
            } else if (startNum == target) {
                return start;
            } else if (target >= startNum && target < indexNum) {
                return search(nums, start + 1, index - 1, target);
            } else {
                return search(nums, index + 1, end - 1, target);
            }
        } else {
            if (endNum == target) {
                return end;
            } else if (startNum == target) {
                return start;
            } else if (target > indexNum && target <= endNum) {
                return search(nums, index + 1, end - 1, target);
            } else {
                return search(nums, start + 1, index - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));//4
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));//1
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));//5
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));//-1
        System.out.println(search(new int[]{1}, 0));//-1
        System.out.println(search(new int[]{1, 3, 5}, 1));//0
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));//4
        System.out.println(search(new int[]{8, 1, 2, 3, 4, 5, 6, 7}, 6));//6
        System.out.println(search(new int[]{5, 1, 2, 3, 4}, 1));//1
    }
}
