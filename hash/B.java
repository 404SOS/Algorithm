package com.aojia.practice.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author QiTian
 * @date 2022/3/18
 * @Description 349. 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
public class B {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();
        for (int num: nums1){
            set1.add(num); //将num1数组中的元素存到set1中
        }
        for (int num:nums2){
            //遍历num2中元素，将与set1中元素重合的元素放到set2中
            //则set2中存在的元素就是交集元素
            if (set1.contains(num)){
                set2.add(num);
            }
        }
        int arr[]=new int[set2.size()];//取出交集元素放入集合返回
        int j=0;
        for (int num : set2){
            arr[j++]=num;
        }
        return arr;
    }

    public static void main(String[] args) {
        int []num1=new int[]{4,5,9};
        int []num2=new int[]{9,4,9,8,4};
        int [] arr=intersection(num1,num2);
        for (int num:arr){
            System.out.print(num+"\t");
        }
    }

}
