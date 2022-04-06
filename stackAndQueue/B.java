package com.aojia.practice.stackAndQueue;

import java.util.Stack;

/**
 * @author QiTian
 * @date 2022/4/6
 * @Description 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 输 入："abbaca"
 * 输 出："ca"
 */
public class B {
    public static String removeDuplicates(String S) {
        Stack<Character> st =new Stack<>();//栈中存放最终的元素
        char chars[]=S.toCharArray();
        for (int i=0;i<S.length();i++){
            if (st.isEmpty()||chars[i]!=st.peek()){ //栈空，或者栈中元素与chars不等，则将该chars存入栈
                st.push(chars[i]);
            }else {//否则 相等时 则 出栈
                st.pop();
            }
        }

        StringBuilder res = new StringBuilder();
            for (char c : st) {
            res.append(c);//用StringBuilder将栈中元素转换成字符串输出
        }

        return res.toString();

    }

    public static void main(String[] args) {
        String S ="abbaca";
        System.out.println(removeDuplicates(S));
    }
}
