package com.t13max.utils;

import java.util.Comparator;
import java.util.Date;

/**
 * 多键数组 传一个比较方法 Comparator
 *
 * @Author 呆呆
 * @Datetime 2021/9/12 23:18
 */
public class Transaction {
    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public static class WhoOrder implements Comparator<Transaction> {
        public int compare(Transaction v, Transaction w) {
            return v.who.compareTo(w.who);
        }
    }

    public static class WhenOrder implements Comparator<Transaction> {
        public int compare(Transaction v, Transaction w) {
            return v.when.compareTo(w.when);
        }
    }

    public static class AmountOrder implements Comparator<Transaction> {
        public int compare(Transaction v, Transaction w) {
            if (v.amount < w.amount) return -1;
            if (v.amount > w.amount) return 1;
            return 0;
        }
    }

}
