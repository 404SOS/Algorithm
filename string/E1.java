package com.aojia.practice.string;

import java.util.Scanner;

/**
 * @author QiTian
 * @date 2022/3/26
 * @Description 剑指 Offer 58 - I. 翻转单词顺序
 * 和leetCode151. 颠倒字符串中的单词 一模一样 不知道为啥 定义难度类型不同  敲里哇
 * 思路：双指针+倒序遍历
 */
public class E1 {
    public static String reverseWords(String s) {
           //使用一种和E类不一样的思路解决该问题
        s=s.trim();//先去首尾 空格
        int j=s.length()-1,i=j;
        StringBuilder sb=new StringBuilder();
        while (i>=0){
            //先找后边单词的起始索引位置
            while (i>=0&&s.charAt(i)!=' ') i--;
            sb.append(s.substring(i+1,j+1)+" ");//将该单词 存入 sb    加上单词之间的空格

            //再找到前一个元素的尾部索引 跳过空格
            while (i>=0&&s.charAt(i)==' ') i--;
                j=i;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String s=scanner.nextLine();
        s=reverseWords(s);
        System.out.println(s);
    }
}
