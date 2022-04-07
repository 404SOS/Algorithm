package com.aojia.practice.stackAndQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author QiTian
 * @date 2022/4/7
 * @Description 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class D {
    public static int[] topKFrequent(int[] nums, int k) {
        //思路哈：因为要前k高频的元素 所以要用map 来存储元素的频率，
        //将map存入优先队列输出，此处维护一个小顶堆 也就是从小到大排序的优先队列
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);//map不允许出现相同的键 相同则值进行覆盖
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];//该优先队列按照频率 从小到大排序
            }
        });
//        //写法1
//        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
//          int key =entry.getKey(),value=entry.getValue();
//         //先将map中键值存入queue
//            queue.offer(new int[]{key,value});
//            //维持k大小的queue，超过k则poll
//            if (queue.size()>k){
//                queue.poll();
//            }
//        }
//        //写法2
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key =entry.getKey(),value=entry.getValue();
           //以k大小为临界点 对插入queue操作优化
//            如果堆的元素个数小于 k，就可以直接插入堆中。
//            如果堆的元素个数等于 k，则检查堆顶与当前出现次数的大小。如果堆顶更大，说明至少有 k 个数字的出现次数比当前值大，
//            故舍弃当前值；否则，就弹出堆顶，并将当前值插入堆中。
//            遍历完成后，堆中的元素就代表了「出现次数数组」中前 k 大的值。
            if (queue.size()==k){
                if (queue.peek()[1]<value){
                    queue.poll(); //维护k大小的queue
                    queue.offer(new int[]{key,value});
                }
            }else {
                queue.offer(new int[]{key,value});
            }
        }
       int res[]=new int[k];
        for (int i=0;i<k;i++){
            res[i]=queue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[]=new int[]{1,1,1,2,2,3};
        int k = 2;
        int result[]=topKFrequent(nums,k);
        for(int res : result){
            System.out.print(res+"\t");
        }
    }
}
