package com.mujio.threaddemo;

/**
 * @Description: Thread线程实现方法之继承Thread，重写run()
 * @Author: GZY
 * @Date: 2020/4/29 0029
 */

public class ThreadDemo1 extends Thread {
/*    public ThreadDemo1() {
        //子类构造方法，可缺省。重写时可以
    }*/
    public void run() {
        //定义线程需要执行的逻辑
        System.out.println("ThreadDemo1 run");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        //设置线程名称
        threadDemo1.setName("自定义线程");

        threadDemo1.start();

        System.out.println(Thread.currentThread().toString());
    }
}
