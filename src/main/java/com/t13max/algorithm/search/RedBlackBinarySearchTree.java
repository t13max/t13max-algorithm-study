package com.t13max.algorithm.search;

import java.util.NoSuchElementException;

/**
 * 红黑树
 * 高度不会超过2*lgN
 * 运行时间为对数级别
 * p287性能表
 * <p>
 * 保证最坏情况下的性能 且操作支持的操作多
 * 删除操作太复杂太牛逼了
 * 2-3查找树
 *
 * @Author 呆呆
 * @Datetime 2021/9/15 22:33
 */
public class RedBlackBinarySearchTree<K extends Comparable, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int N;
        private boolean color;

        public Node(K key, V value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    public int size() {
        return size(root);
    }

    public int size(Node root) {
        if (root == null) return 0;
        else return root.N;
    }

    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
        root.color = BLACK;//根节点是黑色
    }

    public Node put(Node h, K key, V value) {
        if (h == null) return new Node(key, value, 1, RED);//找到了合适的位置 发现是空的 新建 新插入的用红链接和父结点相连
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, value);//key更小 往左边插
        else if (cmp > 0) h.right = put(h.right, key, value);//往右边插
        else h.value = value;//命中 修改
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);//左黑右红 要旋转
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);//左边连续两个红的 要旋转
        if (isRed(h.left) && isRed(h.right)) flipColors(h);//如果左右都红 要变色
        h.N = size(h.left) + size(h.right) + 1;//大小是左边加右边加自己
        return h;

    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
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

    public boolean isEmpty() {
        return root == null;
    }

    public void delete(K key) {
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    public Node delete(Node h, K key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left)) h = moveRedLeft(h);//左左都是黑色 是2-节点 要借一个
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && h.right == null) return null;
            if (!isRed(h.right) && !isRed(h.right.left)) h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                h.value = get(h.right, min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            } else {
                h.right = delete(h.right, key);
            }
        }
        return balance(h);
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    private Node moveRedRight(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;//在根节点 直接变成3-节点
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;//最终要还原
    }

    private Node deleteMin(Node h) {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left)) h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

    // delete the key-value pair with the maximum key rooted at h
    private Node deleteMax(Node h) {
        if (isRed(h.left))
            h = rotateRight(h);

        if (h.right == null)
            return null;

        if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);

        h.right = deleteMax(h.right);

        return balance(h);
    }

    private Node balance(Node h) {
        // assert (h != null);
        //if (!isRed(h)) h = rotateLeft(h);//???
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

}
