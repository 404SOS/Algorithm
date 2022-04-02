package com.aojia.practice.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author QiTian
 * @date 2022/4/2
 * @Description  第18题. 四数之和
 */
public class H {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int k=0;k<nums.length-3;k++){
            if (k>0&&nums[k]==nums[k-1])continue;
            for (int q=k+1;q<nums.length-2;q++){
                if (q>k+1&&nums[q]==nums[q-1])continue;
                int i=q+1,j=nums.length-1;
                while (i<j){
                    int sum=nums[i]+nums[j]+nums[q]+nums[k];
                    if (sum<target)
                        while (i<j&&nums[i]==nums[++i]);
                    else if (sum>target)
                        while (i<j&&nums[j]==nums[--j]);
                    else{
                        List<Integer> list =new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[q]);
                        result.add(list);
                        while (i<j&&nums[i]==nums[++i]);
                        while (i<j&&nums[j]==nums[--j]);
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int nums[]=new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000,
                1000000000};
        int target =1000000000;
        List<List<Integer>> result=fourSum(nums,target);
        for (List<Integer> i :result){
            System.out.print(i+"\t");
        }
    }
}
