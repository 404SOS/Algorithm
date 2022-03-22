package com.aojia.practice.hash;

import com.aojia.practice.list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author QiTian
 * @date 2022/3/22
 * @Description 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 思路：双指针+排序
 */
public class G {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        Arrays.sort(nums);//先将nums排序
        for (int k=0;k<nums.length-2;k++){//第一个数字的索引范围 外层循环控制k
            if (nums[k]>0)break; //当排序后第一个数字都大于0 那么直接退出循环

            //k>0 时  k-1才有意义 （不要忽略）
            if (k>0&&nums[k]==nums[k-1])continue;//当前k位置元素和前一个元素相等 跳过本次循环
            int i=k+1,j=nums.length-1; //i代表第二个元素  j代表第三个元素索引
            while (i<j){//循环条件
                int sum=nums[k]+nums[i]+nums[j];
                if (sum<0)//三数之和小于0时  用while循环里的boolean条件来去重num[i] 控制i索引后移
                    //*** 用while循环和先++再赋值来移动指针达到去重效果
                while (i<j&&nums[i]==nums[++i]);
                else if (sum>0)//三数之和大于0时 用while循环里的boolean条件来去重num[j] 控制j索引前移
                    while (i<j&&nums[j]==nums[--j]);
                else{ //sum=0

                    //result.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));

                    //每次需要new新的list 不能声明全局 否则会将所有符合的结果存在一个list中
                   List<Integer> list=new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list); //将sum==0的三个数字 存入result
                    //用while循环和先++再赋值来移动指针达到去重效果
                    while(i<j&&nums[i]==nums[++i]);//将i指针后移 并避免出现重复i
                    while(i<j&&nums[j]==nums[--j]);//同时j指针前移 并避免出现重复j
                }
            }

        }
        return  result;
    }

    public static void main(String[] args) {
        int nums[]=new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result=threeSum(nums);
        for (List<Integer> i :result){
            System.out.print(i+"\t");
        }
    }
}
