package com.t13max.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉查找树
 * 链表插入的灵活性和数组查找的高效性相结合
 * 查找和插入的比较次数为2*lgN
 * p263有三个查找的总结
 * 不递归也可实现
 * <p>
 * 没测过以书为准
 *
 * @Author 呆呆
 * @Datetime 2021/9/14 22:13
 */
public class BinarySearchTree<K extends Comparable, V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int N;

        public Node(K key, V value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node root) {
        if (root == null) return 0;
        else return root.N;

    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node root, K key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) return get(root.left, key);
        else if (cmp > 0) return get(root.right, key);
        else return root.value;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node root, K key, V value) {
        if (root == null) return new Node(key, value, 1);//空树 创建一个节点 当做根节点
        int cmp = key.compareTo(root.key);
        if (cmp < 0) root.left = put(root.left, key, value);
        else if (cmp > 0) root.right = put(root.right, key, value);
        else root.value = value;
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left == null) return root;
        return min(root.left);//无限递归取左 左为空就是当前节点
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node root) {
        if (root.right == null) return root;
        return max(root.right);
    }

    public K floor(K key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, K key) {//找小于key的最大键
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public K select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);//计算这个节点的左子树大小
        if (t > k) return select(x.left, k);//左边大,递归左子树
        else if (t < k) return select(x.right, k - t - 1);//左边小,在右子树 减去左子树大小 减去节点 貌似是
        else return x;//就你了
    }

    public int rank(K key) {
        return rank(root, key);
    }

    private int rank(Node x, K key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);//key更小 接着找
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);//key更大 计算此节点+左子树+右子树
        else return size(x.left);//相等 那就计算这个节点的左子树
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root.left == null) return root.right;//直到找到为空的 说明是最小 返回右节点
        root.left = deleteMin(root.left);
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node root, K key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) root.left = delete(root.left, key);
        else if (cmp > 0) root.right = delete(root.right, key);
        else {//找到啦!
            if (root.right == null) return root.left;//右边为空返回左边
            if (root.left == null) return root.right;//左边为空返回右边
            Node t = root;
            root = min(t.right);//找到大于他最小的那个
            root.right = deleteMin(t.right);//删掉
            root.left = t.left;//左边还是原来的左边
        }
        root.N = size(root.left) + size(root.right) + 1;//重新计算大小
        return root;

    }

    public void print() {
        print(root);
        System.out.println();
    }

    private void print(Node root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.key + " ");
        print(root.right);
    }

    public Iterable<K> keys() {
        return keys(min(), max());
    }

    public Iterable<K> keys(K lo, K hi) {
        List<K> list = new ArrayList<>();
        keys(root, list, lo, hi);
        return list;
    }

    private void keys(Node root, List<K> list, K lo, K hi) {
        if (root == null) return;
        int cmplo = lo.compareTo(root.key);
        int cmphi = hi.compareTo(root.key);
        if (cmplo < 0) keys(root.left, list, lo, hi);//接着递归
        if (cmplo <= 0 && cmphi >= 0) list.add(root.key);//往里加
        if (cmphi > 0) keys(root.right, list, lo, hi);//接着递归
    }
}
