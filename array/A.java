package com.aojia.practice.array;

/**
 * @author QiTian
 * @date 2022/3/4
 * @Description leetCode35：搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 思路：有序数组作为前提条件 二分搜索是最好的办法；
 *  left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
 */
public class A {
    public static int searchInsert1(int[] nums, int target) {
        //1.暴力破解版
        for (int i=0;i<nums.length;i++){
        if (target<=nums[i]){//如果target大于nums[i]则继续寻找 反之则直接返回nums[i]下标
            return i;
        }
    }
        return nums.length;//如果目标值超过最大值的nums[i]  直接返回最大所引下标
    }

    public static int searchInsert(int[] nums, int target) {
        //2.二分搜索版
       int left=0;
       int right=nums.length-1;
       while (left<=right){
           int middle=left+(right-left)/2;//防止溢出
           if (target>nums[middle]){
               left=middle+1;
           }else if(target<nums[middle]){
               right=middle-1;
           }else  //nums[middle]==target
           {
               return middle;
           }
       }
            return right+1;
    }
    public static void main(String[] args) {
        int nums[]={1,3,5,6};
        int target =5;
        System.out.println(searchInsert(nums,target));
    }
}
