package com.t13max.design.chain;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 请求沿链传递 直到有一个Handler能处理
 *
 * @Author 呆呆
 * @Datetime 2022/4/21 7:15
 */
public class Main {

    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        Handler h3 = new ConcreteHandler3();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(30);
        }

        for (int i : arr) {
            h1.handleRequest(i);
            System.out.println();
        }
    }
}
