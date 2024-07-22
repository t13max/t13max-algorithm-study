package com.t13max.algorithm.string;

/**
 * 三向单词查找树的符号表
 * 链接数在3N~3Nw之间1
 *
 * @Author 呆呆
 * @Datetime 2021/9/29 21:18
 */
public class TST<V> {
    private Node root;

    public static void main(String[] args) {
        TST tst = createTST();
        System.out.println(tst.get("shells"));
        System.out.println(tst.get("by"));
        System.out.println(tst.get("ads"));
    }

    private class Node<V> {
        char c;//因为要比较 所以 当前节点的字符要记录下来
        Node left, mid, right;//三向
        V val;//值
    }

    public V get(String key) {
        Node x = get(root, key, 0);//找到key对应的那个节点
        if (x == null) return null;//为空说明没找到 返回null
        return (V) x.val;//强转 value
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;//为空 没找到
        char c = key.charAt(d);
        if (c < x.c) return get(x.left, key, d);//小于 去左节点接着找
        else if (c > x.c) return get(x.right, key, d);//大于 去又节点 接着找
        else if (d < key.length() - 1) return get(x.mid, key, d+1);//长度不对 继续递归匹配下一字符
        else return x;//成功匹配 返回
    }

    public void put(String key, V val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, V val, int d) {
        char c = key.charAt(d);
        if (x == null) {//x为空新建
            x = new Node();
            x.c = c;//给c赋值
        }
        if (c < x.c) x.left = put(x.left, key, val, d);//小于往左加
        else if (c > x.c) x.right = put(x.right, key, val, d);//大于往右加
        else if (d < key.length() - 1) x.mid = put(x.mid, key, val, d + 1);//字符相等 并且长度不等 往中间加 而且递归下一个字符
        else x.val = val;//字符相等 长度也对等 就这个节点了 赋值 好耶
        return x;
    }

    public String longestPrefixOf(String query) {
        if (query == null) {
            throw new IllegalArgumentException("calls longestPrefixOf() with null argument");
        }
        if (query.length() == 0) return null;
        int length = 0;
        Node<V> x = root;
        int i = 0;
        while (x != null && i < query.length()) {//循环
            char c = query.charAt(i);//一个一个开始匹配
            if (c < x.c) x = x.left;//小于大于分别要去left right节点接着找
            else if (c > x.c) x = x.right;
            else {//只有等于才可以匹配下一个字符
                i++;
                if (x.val != null) length = i;//不为空说明有值 先赋值再说
                x = x.mid;//接着找 看有没有 没了就那样了 有继续呗 反正要的事最长前缀
            }
        }
        return query.substring(0, length);
    }

    public static TST createTST() {
        TST<String> tst = new TST<>();
        tst.put("shells", "shells");
        tst.put("by", "by");
        tst.put("are", "are");
        tst.put("shela", "shela");
        tst.put("shells", "shells_1");
        tst.put("sheore", "sheore");
        tst.put("shurely", "shurely");
        tst.put("sthe", "sthe");
        tst.put("the", "the");
        return tst;
    }
}
