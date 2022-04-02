package com.aojia.practice.doublepoint;

/**
 * @author QiTian
 * @date 2022/4/2
 * @Description 剑指Offer 05.替换空格
 */
public class C {
    public static String replaceSpace(String s) {
        StringBuilder sb =new StringBuilder();
        char chars[]=s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]==' '){
               sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s ="We are happy.";
        System.out.println(replaceSpace(s));
    }
}
