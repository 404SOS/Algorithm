package com.aojia.practice.string;

/**
 * @author QiTian
 * @date 2022/4/1
 * @Description 28. 实现 strStr()
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 参考：https://leetcode-cn.com/problems/implement-strstr/solution/duo-tu-yu-jing-xiang-jie-kmp-suan-fa-by-w3c9c/
 */
public class F {
    public static int strStr1(String haystack, String needle) {
        //使用SubString暴力法解决
        //思路是暴力匹配，每遍历到一个字符，就使用 haystack.substring(i, i + lenNeedle).equals(needle)
        // 往后比较一段子串，如果相等，则此时的 i 就表示了结果子串在目标字符串中的起始位置。
        if (needle==null||needle.length()==0)return 0;
        // for 循环，每通过 haystack.substring(i, i + lenNeedle).equals(needle) 匹配到一个子串，就返回 i
        for (int i=0;i<haystack.length();i++){
            if (i+needle.length()<=haystack.length()&&haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        //官方暴力法解决
        int n = haystack.length(), m = needle.length();
        for (int i=0;i+m<=n;i++){ //i+m<=n  当前索引＋m的长度一定要在n的范围内 否则下边i+j会越界
            boolean flag=true;
            for (int j=0;j<m;j++){ //内层for 从当前i开始 匹配needle串
                if (needle.charAt(j)!=haystack.charAt(i+j)){ //遇到不符合的字符直接退出内层for
                    flag=false;
                    break;
                }
            }
            if (flag)return i;//匹配成功 返回第一个索引下标
        }
        return -1;
    }

    //kmp解决
    public static int strStr(String haystack, String needle) {
        //needle为空串则直接返回0
        if (needle==null||needle.length()==0)return 0;
        int next[]=new int[needle.length()];
        getNext(next,needle);//调用该方法 获取前缀表
        int j=0; //needle串的索引
        for (int i=0;i<haystack.length();i++){
            while (j>0&&haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(haystack.charAt(i)==needle.charAt(j)) j++;
            if (j==needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }
    //构建next数组 存储回溯的位置 前缀表
    public static void getNext(int next[],String s) {
        int j=0; //指向前缀末尾
        next[0]=j;//一个元素是没有前后缀的 因此它的回溯位置也是初始为0
        for (int i=1;i<s.length();i++){ //i指针指向后缀的末尾
            //处理前后缀不同的情况
            while (j>0&&s.charAt(i)!=s.charAt(j)){
                j=next[j-1];//通过while向前回溯 回溯前一位的next中的位置
            }
            //处理前后缀相同的情况
            if (s.charAt(i)==s.charAt(j))j++;//最长相等前后缀长度加1
            next[i]=j;
        }
    }
    public static void main(String[] args) {
        String haystack="hello";
        String needle="ll";
        System.out.println(strStr(haystack,needle));
    }
}
