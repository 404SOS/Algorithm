package com.aojia.practice.hash;

import com.aojia.practice.list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author QiTian
 * @date 2022/3/22
 * @Description 18. 四数之和
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 思路：双指针+排序
 */
public class H {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result =new ArrayList<>();
        if (nums==null||nums.length<4)
            return result;
        Arrays.sort(nums);
        int len=nums.length;
        for (int k=0;k<nums.length-3;k++){
           // if (nums[k]>target)break;(不能写）why？
            if (k>0&&nums[k]==nums[k-1])continue;
            //进行一些剪枝操作
            //long加上就对 why？
//            if ((long)nums[k]+nums[k+1]+nums[k+2]+nums[k+3]>target)break;
//            if ((long)nums[k]+nums[len-1]+nums[len-2]+nums[len-3]<target)continue;
            for (int p=k+1; p<nums.length-2;p++){
                //if (nums[k]+nums[p]>target)break;(不能写）why？
                if (p>k+1&&nums[p]==nums[p-1])continue;
                //进行一些剪枝操作
//                if ((long)nums[k]+nums[p]+nums[p+1]+nums[p+2]>target)break;
//                if ((long)nums[k]+nums[p]+nums[len-1]+nums[len-2]<target)continue;

                int i=p+1,j=len-1;
                while (i<j){
                    int sum=nums[k]+nums[p]+nums[i]+nums[j];
                    if (sum<target)   while (i<j&&nums[i]==nums[++i]);
                    else if (sum>target)  while (i<j&&nums[j]==nums[--j]);
                    else{
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[k]);
                        list.add(nums[p]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        result.add(list); //将sum==0的三个数字 存入result
                        //用while循环和先++再赋值来移动指针达到去重效果
                        while(i<j&&nums[i]==nums[++i]);//将i指针后移 并避免出现重复i
                        while(i<j&&nums[j]==nums[--j]);//同时j指针前移 并避免出现重复j
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
