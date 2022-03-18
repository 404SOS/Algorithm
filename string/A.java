package com.aojia.practice.string;

import java.util.Scanner;

/**
 * @author QiTian
 * @date 2022/2/12
 * @Description 从21年10月颓废到22年的2月 不能再停滞了 歇息很久了该继续勇往直前了
 * 今天先简单练手一个 Integer.parseInt(String str) 手动实现
 */
public class A {
    public static void main(String[] args) {
//        String str = "123456";
//        int num= parseInt(str);
//        System.out.println("“123456”由字符串类型转换为整型成功："+num+"!");
        System.out.println("请手动输入要转换成整型的字符串为：");
        Scanner scanner =new Scanner(System.in);
        String str=scanner.next();
        int num=parseInt(str);
        System.out.println(num);
    }
    private static int parseInt(String str){
        //定义char 数组 存储字符
        char chars[]=new char[str.length()];
        //定义int 数组 存储数组
        int ints[] =new int[str.length()];
        for (int i=0;i<str.length();i++){
            chars[i]=str.charAt(i);//先将字符串 拆成一个一个的字符 存储在chars数组【】中
            ints[i]=chars[i]-'0';// 将'0'，'1'这样的字符转换为整型的 单个数字 存储在 int数组【】中
        }

        //最后 将 int【】数组 转换成整型的数字
        int  num=0;
        for (int i=0;i<ints.length;i++){
            num =num*10+ints[i];
        }
        return num;
        }
}
