package com.aojia.practice.Inet;

/**
 * @author QiTian
 * @date 2022/4/9
 * @Description 使用多线程 模拟齐天的接收和发送消息 udp模式
 */
public class Qitian {
    public static void main(String[] args) {
        new Thread(new UdpTalkSend(1314,"localhost",1)).start();
        new Thread(new UdpTalkReceive("王莹",2)).start();
    }
}
