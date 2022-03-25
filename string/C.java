package com.aojia.practice.string;


/**
 * @author QiTian
 * @date 2022/3/25
 * @Description 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 */
public class C {
    public static String reverseStr(String s, int k) {
        char arr[]=s.toCharArray();
        for (int i=0;i<s.length();i+=2*k){//i每次移动2*k  因为每2*k才需要交换一次
            reverse(arr,i, Math.min(i+k,s.length())-1);//i代表该串的起始索引，j是第k个元素的索引
        }
        return new String(arr);
    }
    //该left right区间进行交换
    public  static void reverse(char arr[],int left,int right){
        while (left<right){
            char tmp=arr[left];
            arr[left]=arr[right];
            arr[right]=tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s="abcdefg";
        int k=2;
        System.out.println(reverseStr(s,k));
    }
}
