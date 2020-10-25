package com.mujio.filedemo;

import java.io.IOException;

/**
 * @Description: SHTest
 * @Author: GZY
 * @Date: 2020/5/6 0006
 */

public class SHTest {

    public static void main(String[] args) {
        try {
            HAUtil.isAlived();
            System.out.println(HAUtil.isMasterServer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
