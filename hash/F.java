package com.aojia.practice.hash;

/**
 * @author QiTian
 * @date 2022/3/22
 * @Description 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。字符串中的每个字符只能在赎金信字符串中使用一次
 * 此题和 242. 有效的字母异位词 类似
 */
public class F {
    public static boolean canConstruct(String ransomNote, String magazine) {
        //假设都是小写字母 开辟一个26位的数组
        int record[]=new int[26];
        char st[]=magazine.toCharArray();
        for (int i=0;i<st.length;i++){
            record[st[i]-'a']++; //把magazine里的所有字符在record中的映射都进行加1操作
        }
        st=ransomNote.toCharArray();
        for (int i=0;i<st.length;i++){
            record[st[i]-'a']--;//将ransomNote里的字符在record中的映射都进行减1操作
            if (record[st[i]-'a']<0){  //如果计数有小于0的值出现代表magazine中没有ransomNote中的该字符
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote ="aa";
        String magazine ="aab";
        System.out.println(canConstruct(ransomNote,magazine));
    }
}
