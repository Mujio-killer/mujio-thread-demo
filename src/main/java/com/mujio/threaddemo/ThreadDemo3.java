package com.mujio.threaddemo;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: 线程实现方法之实现 Callable 接口，实现 call()
 * @Author: GZY
 * @Date: 2020/4/29 0029
 */

public class ThreadDemo3 {


    public static void main(String[] args) {
       /* CallableDemo<Object> demo = new CallableDemo<>();
        //FutureTask的构造方法可以接收一个Callable接口的实现类
        FutureTask<Object> task = new FutureTask<>(demo);

        Thread thread = new Thread(task);
        System.out.println(Thread.currentThread().getName());
        thread.start();
        try {
            Object o = task.get();
            System.out.println("task的get方法可以获取线程执行结束的返回值： " + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
       int a = 2;
        // 未配置虚拟IP时为单机，当作主服务
        if (a==1) System.out.println(1);
            // 配置虚拟IP时，判断VIP是否在本机
        else System.out.println(2);;

    }


}

class CallableDemo<Object> implements Callable<Object> {

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "这里需要用FutureTask来包装");
        return null;
    }
}