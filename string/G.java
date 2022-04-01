package com.aojia.practice.string;

/**
 * @author QiTian
 * @date 2022/4/1
 * @Description 459. 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 思路：
 * 数组长度为：len。 如果len % (len - (next[len - 1] )) == 0 ，
 * 则说明 (数组长度-最长相等前后缀的长度) 正好可以被 数组的长度整除，说明有该字符串有重复的子字符串。
 */
public class G {
    public static boolean repeatedSubstringPattern(String s) {
        if (s==null||s.length()==0)return false;
        int len =s.length();
        char chars[]=s.toCharArray();
        int next[] =new int[len];
        int j=0;//构建next数组
        next[0]=j;
        for (int i=1;i<len;i++){
            while (j>0&&chars[i]!=chars[j])j=next[j-1];
            if (chars[i]==chars[j])j++;
            next[i]=j;
        }
        if (next[len-1]>0&&(len % (len-(next[len - 1] ))==0))return true;
        return false;
    }
    public static void main(String[] args) {
        String s="abab";
        System.out.println(repeatedSubstringPattern(s));
    }
}
