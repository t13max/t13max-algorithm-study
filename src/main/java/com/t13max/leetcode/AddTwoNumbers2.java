package com.t13max.leetcode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author: t13max
 * @since: 11:05 2024/7/24
 */
public class AddTwoNumbers2 {

    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));*/
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))));
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        int add;
        ListNode cur =result;
        while (l1 != null || l2 != null) {
            add = l1 == null ? 0 : l1.val;
            add += l2 == null ? 0 : l2.val;
            add+=cur.val;
            cur.val = add % 10;
            if (add >= 10) {
                cur.next = new ListNode(1);
            } else if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null)) {
                cur.next = new ListNode();
            }
            cur = cur.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        /*@Override
        public String toString() {
            ListNode cur = this;
            StringBuilder result = new StringBuilder(cur.val);
            while (cur.next != null) {
                cur = next;
                result.append(" ").append(cur.val);
            }
            return result.toString();
        }*/
    }
}
