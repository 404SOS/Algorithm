package com.aojia.practice.Inet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * @author QiTian
 * @date 2022/4/9
 * @Description udp模式下的 面向无连接的 实现多线程 聊天
 */
public class UdpTalkSend implements Runnable {
    int fromPort;
    String toIp;
    int toPort;

    //都要面向socket编程
    DatagramSocket socket =null;
    //使用控制台读取数据 System.in
    BufferedReader  read;
    public UdpTalkSend(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(fromPort);
            read = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //run 方法主要是发送消息
        while(true){
            try {
                String data =read.readLine();//读取控制台中的信息
                byte[] bytes =data.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,new InetSocketAddress(this.toIp,this.toPort));
                socket.send(packet);

                if (packet.getData().equals("bye")){
                    break;  //设置一个退出死循环的条件
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        socket.close();
    }
}
