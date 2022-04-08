package com.aojia.practice.Inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author QiTian
 * @date 2022/4/8
 * @Description  //今天来个测试ip
 * InetAddress是个静态方法 不能new 对象
 */
public class TestiInetAddress {
    public static void main(String[] args) {
        try {
            //测试本机ip
            InetAddress inetAddress1=InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);
            InetAddress inetAddress2=InetAddress.getByName("localhost");
            System.out.println(inetAddress2);
            InetAddress inetAddress3=InetAddress.getLocalHost();
            System.out.println(inetAddress3);

            //查询网站ip地址
            InetAddress inetAddress4=InetAddress.getByName("www.taobao.com");
            System.out.println(inetAddress4);
            //常用方法
            System.out.println(inetAddress4.getHostAddress()); //ip
            System.out.println(inetAddress4.getHostName());//域名

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
