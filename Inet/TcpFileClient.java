package com.aojia.practice.Inet;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author QiTian
 * @date 2022/4/9
 * @Description  TCP实现文件传输
 */
public class TcpFileClient {
    public static void main(String[] args) throws Exception {
        //1.建立socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 2000);
        //创建输出流
        OutputStream os = socket.getOutputStream();
        //文件输入流
        FileInputStream fis =new FileInputStream(new File("C:\\Users\\HP\\IdeaProjects\\Algorithm\\src\\com\\aojia\\practice\\Inet\\sex.png"));
        //接收文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);//将文件上传
        }
        socket.shutdownOutput();//关闭socket的输出

        //接收服务端发来的消息
        InputStream inputStream =socket.getInputStream();
        //使用管道流输出
        ByteArrayOutputStream bos =new ByteArrayOutputStream();
        byte[] bf = new byte[1024];
        int length;
        while ((length=inputStream.read(bf))!=-1){
            bos.write(buffer,0,length);//将文件上传
        }
        System.out.println(bos.toString());

        bos.close();
        inputStream.close();
        fis.close();
        os.close();
        socket.close();
    }
}
