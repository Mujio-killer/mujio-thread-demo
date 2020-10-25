package com.mujio.filedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description: HAUtil
 * @Author: GZY
 * @Date: 2020/5/6 0006
 */

public class HAUtil {

    private static final Logger LOG = LoggerFactory.getLogger(HAUtil.class);
    // 用于判断 是否配置了虚拟IP
    private static final String virtualIP = "";
    // 配置了虚拟IP时判断 是否是主服务
    private static boolean isAlived = true;

    public static boolean isMasterServer() {
        // 未配置虚拟IP时为单机，当作主服务
        if (virtualIP.equals("")) return true;
        // 配置虚拟IP时，判断VIP是否在本机
        else return isAlived;
    }

    public static void isAlived() throws IOException {
        // 获取判断脚本
        String shfile = "D:\\006_Workspace\\03_Idea\\mujio-thread-demo\\src\\main\\java\\sh\\getVirtualIP.sh"
                .replace("file:","");
        // 创建执行脚本的进程
        ProcessBuilder pb = new ProcessBuilder("sh", shfile, virtualIP)
                // 合并标准输出和错误输出
                .redirectErrorStream(true);

        Process p;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            // 执行脚本
            p = pb.start();
            // 获取执行输出
            is = p.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String read = "";
            boolean isval = false;
            // 读取执行结果
            while (( read = br.readLine()) != null) {
                isval = true;
                LOG.info(read);
                // 若脚本输出为 0 ，表示配置了虚拟IP且为主服务
                if(read.equals("0")) {
                    isAlived = true;
                }else {
                    isAlived = false;
                }
            }
            // 若isval为 false ，表示未能读取到脚本执行结果
            if(!isval) {
                isAlived = false;
            }
        }catch (IOException e) {
            LOG.error("Get virtualIP Failed :",  e.getMessage());
            isAlived = false;
        } finally {
            // 关闭流
            is.close();
            isr.close();
            br.close();
        }
    }
}
