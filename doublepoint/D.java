package com.aojia.practice.doublepoint;

/**
 * @author QiTian
 * @date 2022/4/2
 * @Description 151.翻转字符串里的单词  剑指 Offer 58 - I. 翻转单词顺序
 */
public class D {
    public static String reverseWords1(String s) {
        StringBuilder sb=new StringBuilder();
        s=s.trim();
        int j=s.length()-1;
        int i=j;
        while (i>=0){
            while (i>=0&&s.charAt(i)!=' ')i--;
            sb.append( s.substring(i+1,j+1)+" ");
            while (i>=0&&s.charAt(i)==' ')i--;
            j=i;
        }
        return sb.toString().trim();
    }
 //先去掉首尾多余空格 再将整体字符串反转 最后反转单个字符
    public static String reverseWords(String s) {
        StringBuilder sb=trimSpace(s);
        reverse(sb,0,sb.length()-1);
        return reverseWords(sb).toString();
    }

    private static StringBuilder reverseWords(StringBuilder sb) {
        int n=sb.length()-1;
        int start=0,end=0;
        while (start<=n){
            while (end<=n&&sb.charAt(end)!=' ')end++;
            reverse(sb,start,end-1);
            start=end+1;
            end+=1;
        }
        return sb;
    }

    public static  StringBuilder trimSpace(String s){
        int left=0,right=s.length()-1;
        while(left<right&&s.charAt(left)==' ')left++;
        while(left<right&&s.charAt(right)==' ')right--;
        StringBuilder sb =new StringBuilder();

        while (left<=right){
         char c=s.charAt(left);
         if (c!=' '){
             sb.append(c);
         }else if (sb.charAt(sb.length()-1)!=' '){
             sb.append(c);
         }
         ++left;
        }
        return sb;
    }
    public static void  reverse(StringBuilder sb,int left,int right){
        while (left<right){
            char tmp=sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,tmp);
        }
    }

    public static void main(String[] args) {
        String s="the sky is blue";
        System.out.println(reverseWords(s));
    }
}
