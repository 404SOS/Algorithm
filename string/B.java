package com.aojia.practice.string;

/**
 * @author QiTian
 * @date 2022/3/25
 * @Description 344. 反转字符串  easy
 */
public class B {
    public static void reverseString(char[] s) {
        if (s==null||s.length==0)
            return;
         int len=s.length/2;
         for (int i=0,j=s.length-1;i<len;i++,j--){
             char tmp=s[j];
             s[j]=s[i];
             s[i]=tmp;
         }
    }

    public static void main(String[] args) {
       String s="Hello";
       char arr[]=s.toCharArray();
        reverseString(arr);
        String ss=new String(arr);
        System.out.println(ss);
    }
}
