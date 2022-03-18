package com.aojia.practice.hash;

/**
 * @author QiTian
 * @date 2022/3/18
 * @Description 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 思路：可以拿数组当哈希表来用，但哈希值不要太大！
 */
public class A {
    public static boolean isAnagram(String s, String t) {
      //因为字母都是小写 所以定义一个26大小的数组
        int record [] =new int[26];
        char [] st=s.toCharArray();//先把s转换为字符数组
        for (int i=0;i<st.length;i++){
            record[st[i]-'a']++;//将s字符数组中的字符大小作为索引映射到record数组中 将其值做+1标记
        }

        st=t.toCharArray();//把t字符串也转换为字符数组
        for (int i=0;i<st.length;i++){
            record[st[i]-'a']--;//将t符数组中的字符大小作为索引映射到record数组中 将其值做-1做标记
        }
        //经过两轮标记如何record数组上的索引值都默认为0 代表s，t是字母异位词 反之则不是
        for (int i=0;i<26;i++){
            if (record[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s ="anagram";
        String t ="nagaram";
        System.out.println(isAnagram(s,t));
    }
}
