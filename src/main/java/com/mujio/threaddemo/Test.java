package com.mujio.threaddemo;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Description: Test
 * @Author: GZY
 * @Date: 2020/4/29 0029
 */

public class Test {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
