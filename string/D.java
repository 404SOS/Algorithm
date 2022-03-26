package com.aojia.practice.string;

/**
 * @author QiTian
 * @date 2022/3/26
 * @Description 剑指Offer 05.替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class D {
    public static String replaceSpace(String s) {
        if (s==null||s.length()==0)return s;
        StringBuffer sb =new StringBuffer();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){
                sb.append("%20");
            }else { //必须有else  因为只有再不是空格的条件下才连接该元素  不加else会把空格也连接到
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s ="We are happy.";
        System.out.println(replaceSpace(s));
    }
}
