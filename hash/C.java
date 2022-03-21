package com.aojia.practice.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author QiTian
 * @date 2022/3/21
 * @Description 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，
 * 那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class C {

    public  static int getNext(int n){
        int sum=0;//每次调用都初始化sum值
        while (n>0){//通过循环次数 来求该数字的总和
            int dight = n%10;//每次都取个位上的数字 来进行乘法运算
            sum+=dight*dight;//快乐数计算公式
            n/=10;//取高一位上的数字
        }
        return sum;
    }
    //方法1： 哈希表
    public static boolean isHappy1(int n) {
        Set seen =new HashSet();//没见过的数字 存入hash表中，如果重复数字出现则代表不是快乐数字
        while (n!=1&&!seen.contains(n)){
            seen.add(n);//符合要求的数字 存入set中
            n=getNext(n);
        }
        return n==1;
    }
    //只考虑两种情况：1.成环 循环 2. 结果得1
    //无需考虑 无穷放大得情况
    //方法2：快慢指针法
    public static boolean isHappy(int n) {
       int slow = n;
       int fast = getNext(n);
       while (fast!=1&&fast!=slow){
           slow=getNext(slow);//一次走一步
           fast=getNext(getNext(fast));//一次走两步 循环嵌套
       }
       return fast==1;
    }


    public static void main(String[] args) {
        int n=19;
        System.out.println(isHappy(n));
    }
}
