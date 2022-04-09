package com.aojia.practice.Inet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author QiTian
 * @date 2022/4/9
 * @Description TCP实现文件传输
 */
public class TcpFileServer {
    public static void main(String[] args) throws Exception {
        //建立服务端连接
        ServerSocket serverSocket = new ServerSocket(2000);
        Socket socket =serverSocket.accept();//监听客户端
        //获取输入流
        InputStream is =socket.getInputStream();
        //文件输出流
        FileOutputStream fos =new FileOutputStream(new File("C:\\Users\\HP\\IdeaProjects\\Algorithm\\src\\com\\aojia\\practice\\Inet\\qitian.png"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);//将文件输出
        }

        //将文件输出成功后需要告诉客户端 这边已经接收完毕
        OutputStream os =socket.getOutputStream();
        os.write("我已经接收完毕，可以断开socket连接了！".getBytes());

        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
