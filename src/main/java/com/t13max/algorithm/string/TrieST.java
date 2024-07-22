package com.t13max.algorithm.string;

import com.atb.utils.Queue;

/**
 * 基于单词查找树的符号表
 * 未命中查找为log R底 N
 * 链接总数在RN~RNw之间
 *
 * @Author 呆呆
 * @Datetime 2021/9/28 22:23
 */
public class TrieST<V> {
    private static int R = 256;//基数
    private Node root;//根节点

    public static void main(String[] args) {
        TrieST trieST = createTrieST();
        System.out.println(trieST.get("shore"));
        System.out.println(trieST.get("sells"));
        System.out.println(trieST.get("asd"));
        System.out.println("--------------------------------------");
        trieST.keyWithPrefix("sh").forEach(System.out::println);
        System.out.println("--------------------------------------");
        trieST.keys().forEach(System.out::println);
        System.out.println("--------------------------------------");
        trieST.keysThatMatch("s....").forEach(System.out::println);
        System.out.println("--------------------------------------");
        System.out.println(trieST.longestPrefixOf("byppppppppp"));
        System.out.println("--------------------------------------");
        trieST.delete("shore");
        System.out.println(trieST.get("shore"));
    }

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public V get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (V) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;//长度对应上了 找到啦
        char c = key.charAt(d);//继续匹配下一个字符
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, V val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, V val, int d) {
        if (x == null) x = new Node();//为空就新建
        if (d == key.length()) {//有值就是替换
            x.val = val;
            return x;
        }
        char c = key.charAt(d);//继续匹配下一个字符
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public Iterable<String> keys() {
        return keyWithPrefix("");
    }

    public Iterable<String> keyWithPrefix(String pre) {
        Queue<String> q = new Queue();
        collect(get(root, pre, 0), pre, q);//get那个key的节点 然后对这个节点开始收集所有key
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) return;//为空返回
        if (x.val != null) q.enqueue(pre);//不为空加入队列
        for (char c = 0; c < R; c++) {//循环对他的所有分支进行收集
            collect(x.next[c], pre + c, q);//前缀要带上对应分支的字符
        }
    }

    private void collect(Node x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) return;
        if (d == pat.length() && x.val != null) q.enqueue(pre);
        if (d == pat.length()) return;
        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                collect(x.next[c], pre + c, pat, q);
            }
        }
    }

    //通配符匹配
    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<>();
        collect(root, "", pat, q);
        return q;
    }

    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);//匹配的长度
        return s.substring(0, length);//根据长度截取
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) return length;//如果节点为空  后面的都匹配不上了 只能到这了
        if (x.val != null) length = d;//有值 长度就等于d
        if (d == s.length()) return length;//d和要匹配的一样 就可以返回了
        char c = s.charAt(d);//后面还有 继续匹配
        return search(x.next[c], s, d + 1, length);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;//节点为空 没找到这个key
        if (d == key.length()) x.val = null;//找到了 把值改为null就是删除了
        else {
            char c = key.charAt(d);//长度不对 后面还有 继续递归
            x.next[c] = delete(x.next[c], key, d + 1);
        }
        if (x.val != null) return x;//有值 返回此节点
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) return x;//父结点还有存在的意义
        }
        return null;//没意义就是null了
    }

    public static TrieST createTrieST() {
        TrieST<String> trieST = new TrieST<>();
        trieST.put("by", "by");
        trieST.put("sea", "sea");
        trieST.put("sells", "sells");
        trieST.put("she", "she");
        trieST.put("shells", "shells");
        trieST.put("shore", "shore");
        trieST.put("the", "the");
        return trieST;
    }
}
