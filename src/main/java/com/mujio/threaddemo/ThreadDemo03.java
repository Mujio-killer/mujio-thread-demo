package com.mujio.threaddemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo03 {

    /**
     *      * @param args
     *      
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Callable<Object> oneCallable = ()->{
            Object o = null;
            return o;
        };
        FutureTask<Object> oneTask = new FutureTask<Object>(oneCallable);

        Thread t = new Thread(oneTask);

        System.out.println(Thread.currentThread().getName());

        t.start();

    }

}

class Tickets<Object> implements Callable<Object> {

    //重写call方法
    @Override
    public Object call() throws Exception {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getName() + "-->我是通过实现Callable接口通过FutureTask包装器来实现的线程");
        return null;
    }
}