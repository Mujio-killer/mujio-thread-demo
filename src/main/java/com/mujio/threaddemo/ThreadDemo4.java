package com.mujio.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: ThreadPool 通过线程池创建
 * @Author: GZY
 * @Date: 2020/4/29 0029
 */

public class ThreadDemo4 {

    private static int size = 10;

    public static void main(String[] args) {
        //创建一个固定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //阿里要求使用 ThreadPoolExecutor 来创建线程池
        for(int i = 0; i < size; i++)
        {
            RunnableThread  thread = new RunnableThread ();

//                Thread.sleep(1000);
            executorService.execute(thread);
        }
        //关闭线程池
        executorService.shutdown();

    }
}

class RunnableThread  implements Runnable {

    @Override
    public void run() {
        System.out.println("通过线程池创建：" + Thread.currentThread().getName());
    }
}
