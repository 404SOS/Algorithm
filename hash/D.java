package com.aojia.practice.hash;

import java.util.HashMap;
import java.util.Map;


/**
 * @author QiTian
 * @date 2022/3/21
 * @Description 1. 两数之和
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class D {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
      throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int nums[]=new int[]{2,7,11,15};
        int target=9;
        int num[]=twoSum(nums,target);
        for (int i:num){
            System.out.print(i+"\t");
        }
    }
}
