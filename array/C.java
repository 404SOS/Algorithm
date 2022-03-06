package com.aojia.practice.array;

/**
 * @author QiTian
 * @date 2022/3/5
 * @Description leetCode209.长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class C {
    public static int minSubArrayLen1(int target, int[] nums) {
        //1.暴力法 时间复杂度 O（n^2）
       int result=Integer.MAX_VALUE;
       int subLength=0;//子序列长度
        for(int i=0;i<nums.length;i++){
            int sum =0;
            for (int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if (sum>=target){// 一旦发现子序列和超过了s，更新result
                    subLength=j-i+1;//确定子序列长度
                    result =result<subLength?result:subLength;//取最小的子序列长度；
                    break;//跳出两层for 接着进行最外层的for 找最小子序列长度
                }
            }
        }
        // 如果result没有被赋值的话，target>序列中的所有sum 就返回0。
        // 说明没有符合条件的子序列
        return result==Integer.MAX_VALUE?0:result;
    }

    public static int minSubArrayLen(int target, int[] nums) {
       //2.滑动窗口 时间复杂度：O(n)  空间复杂度：O(1)
        int result=Integer.MAX_VALUE;//定义一个最大值
        int sum = 0; //定义一个窗口内的总和
        int subLength = 0;//定义 窗口大小
        int i=0;//定义窗口起始指针
        for(int j=i;j<nums.length;j++){
            sum+=nums[j];
            while (sum>=target){
                subLength=j-i+1;//更新窗口长度
                result=result<subLength?result:subLength;
                // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
                sum-=nums[i++];//更新起始位置，修改sum值
            }
        }  // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return  result==Integer.MAX_VALUE?0:result;
    }

    public static void main(String[] args) {
        int target =7;
        int nums[]=new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target,nums));
    }
}
