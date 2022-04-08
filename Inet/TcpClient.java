package com.aojia.practice.Inet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


/**
 * @author QiTian
 * @date 2022/4/8
 * @Description 模拟qq聊天客户端 使用socket连接
 */
public class TcpClient {

    public static void main(String[] args) {
        Socket socket=null;
        OutputStream os=null;
        try {
            //1.先连接服务器的ip地址，然后对应其端口号
            InetAddress serverIp = InetAddress.getByName("localhost");
            int port =520;
         //2.创建socket连接
           socket = new Socket(serverIp, port);
         //3.聊天  使用io流传输
             os= socket.getOutputStream();
             os.write("琳琅之上！".getBytes());//使用byte数组传参
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
