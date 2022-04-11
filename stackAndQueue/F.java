package com.aojia.practice.stackAndQueue;

import java.util.LinkedList;

/**
 * @author QiTian
 * @date 2022/4/11
 * @Description 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *   //**注意
 *         //1.滑动窗口的大小 要维持在【i-k+1，i】之间
 *         //2.验证dqueue的队首元素(最大值)dqueue.peek（）<=i-k;是否在窗口内
 *  这道hard题 我看题解看了半天  真的是菜狗一只 希望自己能一遍过
 */
public class F {
    public static int[] maxSlidingWindow(int[] nums, int k) {
       //声明一个双端队列（用其维护一个单调队列）
        // 内部存储的都是索引 用来判断最大值是否在窗口内
        int res[] =new int[nums.length-k+1];//存储窗口最大值的大小
        LinkedList<Integer> deque =new LinkedList();
        for (int i=0;i<nums.length;i++){
            //当前元素比deque中最小元素大的话就循环将队尾元素清除，deque中存储大数就可以
            while(!deque.isEmpty()&&nums[i]>nums[deque.peekLast()]){
                deque.pollLast();//将队尾元素清除
            }
            deque.addLast(i);//deque存储的是索引

            if (deque.peek()<i-k+1){//表示队首最大值的 索引 不在窗口内 则应该删除
                deque.poll();
            }
            if (i-k+1>=0){//已经形成窗口大小 开始存入窗口内的最大值
                res[i-k+1]=nums[deque.peek()];//索引从0开始
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int nums[]=new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[] =maxSlidingWindow(nums,k);
        for (int i:res){
            System.out.print(i+"\t");
        }
    }
}
