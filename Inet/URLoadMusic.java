package com.aojia.practice.Inet;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author QiTian
 * @date 2022/4/9
 * @Description 使用网上url地址下载vip歌曲
 */
public class URLoadMusic {
    public static void main(String[] args) throws Exception {
        //选择一个下载地址 https://y.qq.com/n/ryqq/player
        URL url =new URL("https://dl.stream.qqmusic.qq.com/RS02061lcSLJ0ZNVY3.mp3?guid=5989225810&vkey=7616BA427C7E903E83562FE652B1E9C3A6BB9D0038512BDFC3E73247A39299879AC9908FF3B9F23D3E11ACC4D87015447D56D2706451860E&uin=1822355055&fromtag=66");
        //使用http连接这个资源
        HttpURLConnection connection =(HttpURLConnection)url.openConnection();
        //使用流式传入
        InputStream is =connection.getInputStream();
        //使用file流输出
        FileOutputStream fos = new FileOutputStream("C:\\Users\\HP\\IdeaProjects\\Algorithm\\src\\com\\aojia\\practice\\Inet\\JAY.m4a");
        byte[] buffer =new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);//将数据写出来
        }
        fos.close();//断开连接
        is.close();
        connection.disconnect();
    }
}
