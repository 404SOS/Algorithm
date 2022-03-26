package com.aojia.practice.string;

/**
 * @author QiTian
 * @date 2022/3/26
 * @Description 剑指Offer58-II.左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 思路：非常值简单 可以用StringBuffer 也可以直接定义一个String 串来连接
 */
public class E2 {
    public static String reverseLeftWords1(String s, int k) {
        //1.用辅助的StringBuffer
        StringBuffer sb = new StringBuffer();
        for (int i=k;i<s.length();i++)sb.append(s.charAt(i));
        for (int i=0;i<k;i++)sb.append(s.charAt(i));
        return sb.toString();
    }

    public static String reverseLeftWords(String s, int k) {
        //2.利用字符串拼接
        String str ="";
        for (int i=k;i<s.length();i++)str+=s.charAt(i);
        for (int i=0;i<k;i++)str+=s.charAt(i);
        return str;
    }

    public static void main(String[] args) {
        String  s="abcdefg";
        int k=2;
        System.out.println(reverseLeftWords(s,k));
    }
}
