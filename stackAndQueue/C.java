package com.aojia.practice.stackAndQueue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author QiTian
 * @date 2022/4/6
 * @Description 215. 数组中的第K个最大元素
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class C {
//搞了一天git  明天继续写c类算法 今天先这样了
    //兄弟们 洗完澡才回来 来整两道熟悉的优先队列算法 不要虚度光阴
    public static int findKthLargest1(int[] nums, int k) {
        //先来一种简单解法直接返回索引
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    public static int findKthLargest(int[] nums, int k) {
        //优先队列求解
        PriorityQueue<Integer> queue =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;//不写也可以 因为默认是小顶堆  从小到大排序
            }
        });
        for (int i=0;i<nums.length;i++){
            queue.offer(nums[i]);
            if (queue.size()>k){
                queue.poll();//优先队列维持k大小 超过k大小 就将最小的值抛出
            }
        }
            return queue.peek();//最后k大小的优先队列中 peek的就是第k大的元素
    }

    public static void main(String[] args) {
        int nums[]=new int[]{3,2,1,5,6,4};
        int  k=2;
        System.out.println(findKthLargest(nums,k));
    }
}
