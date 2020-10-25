package com.mujio.threaddemo;

import javax.annotation.security.RunAs;

/**
 * @Description: 线程实现方法之实现Runnable接口，实现run()
 * @Author: GZY
 * @Date: 2020/4/29 0029
 */

public class ThreadDemo2 implements Runnable {

    public void run() {
        //定义线程需要执行的逻辑
        System.out.println("ThreadDemo2 run");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadDemo2 threadDemo2 = new ThreadDemo2();

        Thread thread = new Thread(threadDemo2);

        thread.start();

        System.out.println(Thread.currentThread().toString());
    }
}
