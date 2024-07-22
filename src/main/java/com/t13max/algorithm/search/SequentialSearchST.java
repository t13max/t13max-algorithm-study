package com.t13max.algorithm.search;

/**
 * 基于无序链表的顺序查找
 *
 *
 * @Author 呆呆
 * @Datetime 2021/9/13 22:23
 */
public class SequentialSearchST<K, V> {
    private Node first;

    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public V get(K key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)){
                return x.value;
            }
        }
        return null;
    }

    public void put(K key,V value){
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)){
                x.value=value;//命中 更新
                return;
            }
        }
        first=new Node(key,value,first);//未命中 新增
    }

}
