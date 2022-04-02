package com.aojia.practice.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author QiTian
 * @date 2022/4/2
 * @Description 第15题. 三数之和
 */
public class G {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        Arrays.sort(nums);
        for (int k=0;k<nums.length-2;k++){
            if (nums[k]>0)break;
            if (k>0&&nums[k]==nums[k-1])continue;//进行下一次循环
            int i=k+1,j=nums.length-1;
            while (i<j){
                int sum=nums[i]+nums[j]+nums[k];
                if (sum<0)
                    while (i<j&&nums[i]==nums[++i]);
                else if (sum>0)
                    while (i<j&&nums[j]==nums[--j]);
                else{
                    List<Integer> list =new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                    while (i<j&&nums[i]==nums[++i]);
                    while (i<j&&nums[j]==nums[--j]);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int nums[]=new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result=threeSum(nums);
        for (List<Integer> i :result){
            System.out.print(i+"\t");
        }
    }
}
