package com.aojia.practice.doublepoint;

/**
 * @author QiTian
 * @date 2022/4/2
 * @Description 27. 移除元素
 * 该双指针部分  在之前各部分都写过原题
 * 所以此部分直接上代码 不做过多的注释
 */
public class A {
    public static int removeElement1(int[] nums, int val) {
        int size=nums.length;//注意 size在变化
        for (int i=0;i<size;i++){
            if (nums[i]==val){
                for (int j=i+1;j<size;j++){
                   nums[j-1]=nums[j];
                }
                size--;
                i--;
            }
        }
        return size;
    }
 //快慢指针
    public static int removeElement(int[] nums, int val) {
        int slow=0;
        for (int fast=slow;fast<nums.length;fast++){
            if (nums[fast]!=val){
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int nums[]=new int[]{3,2,2,3};
        int val=3;
        System.out.println(removeElement(nums,val));
    }
}
