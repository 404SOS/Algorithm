package com.aojia.practice.Inet;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author QiTian
 * @date 2022/4/8
 * @Description 模拟qq聊天的服务器
 */
public class TcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream is=null;
        ByteArrayOutputStream bos=null;
        try {
            //1.先建立一个服务端的端口
             serverSocket = new ServerSocket(520);
            while (true){
            //2.通过socket监听客户端的端口信息
                 socket =  serverSocket.accept();
            //3.接收消息采用io 流
                 is =socket.getInputStream();
            //管道流操作
                bos =new ByteArrayOutputStream();
                byte[] buffer =new byte[1024];
                int len;
             //4.将消息通过管道流出
                while ((len=is.read(buffer))!=-1){
                    bos.write(buffer,0,len);
                }
                System.out.println(bos.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
         if (bos!=null){
             try {
                 bos.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         if (is!=null){
             try {
                 is.close();
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
         if (serverSocket!=null){
             try {
                 serverSocket.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
        }
    }
}
