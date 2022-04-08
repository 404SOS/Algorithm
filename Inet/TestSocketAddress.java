package com.aojia.practice.Inet;

import java.net.InetSocketAddress;

/**
 * @author QiTian
 * @date 2022/4/8
 * @Description 测试地址和端口
 */
public class TestSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8081);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost",8080);
        System.out.println(socketAddress);
        System.out.println(socketAddress1);

        System.out.println(socketAddress1.getHostName());//获取域名
        System.out.println(socketAddress1.getAddress());//获取ip地址
        System.out.println(socketAddress1.getPort());//获取端口号

    }
}
