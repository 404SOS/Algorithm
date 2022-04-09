package com.aojia.practice.Inet;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author QiTian
 * @date 2022/4/9
 * @Description udp模式下的 面向无连接的 实现多线程 聊天
 */
public class UdpTalkReceive implements Runnable {
    String fromWho;//消息来自谁
    int port;// 自己的端口
    DatagramSocket socket =null;
    public UdpTalkReceive(String fromMsg, int port) {
        this.fromWho = fromMsg;
        this.port = port;
        try {
             socket =new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
      while (true){
          try {
              //接收包
              byte[] container =new byte[1024];
              DatagramPacket packet =new DatagramPacket(container,0,container.length);
              socket.receive(packet);

              byte[] data =packet.getData();//接收到的包 转成string 读出来
              String receiveData =new String(data,0,data.length);
              System.out.println(fromWho+":"+receiveData);
              //退出while的判断
              if (receiveData.equals("bye")){
                  break;
              }

          } catch (IOException e) {
              e.printStackTrace();
          }
      }
        socket.close();
    }
}
