package com.aojia.practice.doublepoint;

/**
 * @author QiTian
 * @date 2022/4/2
 * @Description 344. 反转字符串
 */
public class B {
    public static void reverseString(char[] s) {
        for (int i=0,j=s.length-1;i<s.length/2;i++,j--){
            char tmp=s[i];
            s[i]=s[j];
            s[j]=tmp;
        }
    }

    public static void main(String[] args) {
        char []s=new char[]{'H','e','l','l','o'};
        reverseString(s);
        for (int i:s){
            System.out.print(i+"\t");
        }
    }
}
