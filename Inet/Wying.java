package com.aojia.practice.Inet;

/**
 * @author QiTian
 * @date 2022/4/9
 * @Description 使用多线程 模拟王莹的接收和发送消息 udp模式
 */
public class Wying {
    public static void main(String[] args) {
        new Thread(new UdpTalkSend(1312,"localhost",2)).start();
        new Thread(new UdpTalkReceive("齐天",1)).start();
    }
}
