package com.t13max.leetcode;

import java.util.*;

/**
 * 给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
 * <p>
 * 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。
 * <p>
 * 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
 * <p>
 * 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
 * <p>
 * 1 <= bombs.length <= 100
 * bombs[i].length == 3
 * 1 <= xi, yi, ri <= 10的五次方
 *
 * @author: t13max
 * @since: 11:50 2024/7/22
 */
public class MaximumDetonation2101 {

    public static void main(String[] args) {
        //int[][] bombs = new int[][]{{1, 1, 100000}, {100000, 100000, 1}};
        //System.out.println(new MaximumDetonation2101().maximumDetonation(bombs));
    }

    public int maximumDetonation(int[][] bombs) {

        int result = 1;

        //遍历一遍 找到最多的那个
        for (int[] bomb : bombs) {
            //缓存已经触发爆炸的炸弹
            Set<int[]> contains = new HashSet<>();
            //检测这颗炸弹触发的其他炸弹
            check(bombs, contains, bomb);
            //最终比较数量
            if (contains.size() > result) {
                result = contains.size();
            }
        }

        return result;
    }

    private void check(int[][] bombs, Set<int[]> contains, int[] cur) {

        //先把自己加进来
        contains.add(cur);

        //遍历一遍 找到当前炸弹所有能引爆的炸弹
        for (int[] bomb : bombs) {
            //已经存在了 则跳过
            if (contains.contains(bomb)) {
                continue;
            }
            //a方+b方小于r方 todo t13max 注意 注意一下入参的大小 平方超int最大值了
            if (((long) (bomb[0] - cur[0]) * (bomb[0] - cur[0]) + (long) (bomb[1] - cur[1]) * (bomb[1] - cur[1])) <= (long) cur[2] * cur[2]) {
                //这颗也被引爆了 则递归检查这颗可以引爆的其他炸弹
                check(bombs, contains, bomb);
            }
        }
    }

    /**
     * 官方版
     * 先建立有向图 减少计算
     *
     * @Author t13max
     * @Date 13:37 2024/7/22
     */
    public int maximumDetonationOfficial(int[][] bombs) {
        int n = bombs.length;
        // 维护引爆关系有向图
        Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && isConnected(bombs, i, j)) {
                    edges.putIfAbsent(i, new ArrayList<Integer>());
                    edges.get(i).add(j);
                }
            }
        }
        int res = 0;   // 最多引爆数量
        for (int i = 0; i < n; ++i) {
            // 遍历每个炸弹，广度优先搜索计算该炸弹可引爆的数量，并维护最大值
            boolean[] visited = new boolean[n];
            int cnt = 1;
            Queue<Integer> queue = new ArrayDeque<Integer>();
            queue.offer(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int cidx = queue.poll();
                for (int nidx : edges.getOrDefault(cidx, new ArrayList<Integer>())) {
                    if (visited[nidx]) {
                        continue;
                    }
                    ++cnt;
                    queue.offer(nidx);
                    visited[nidx] = true;
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    // 判断炸弹 u 能否引爆炸弹 v
    public boolean isConnected(int[][] bombs, int u, int v) {
        long dx = bombs[u][0] - bombs[v][0];
        long dy = bombs[u][1] - bombs[v][1];
        return (long) bombs[u][2] * bombs[u][2] >= dx * dx + dy * dy;
    }

}
