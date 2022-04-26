package com.aojia.practice.stackAndQueue;

import java.util.LinkedList;

/**
 * @author QiTian
 * @date 2022/4/26
 * @Description 239. 滑动窗口最大值
 *  * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 *  * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *  * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 *  * 输出：[3,3,5,5,6,7]
 *  时隔半月 自己再试试看看能不能做出这道hard
 *   * 解释：
 *  * 滑动窗口的位置                最大值
 *  * ---------------               -----
 *  * [1  3  -1] -3  5  3  6  7       3
 *  *  1 [3  -1  -3] 5  3  6  7       3
 *  *  1  3 [-1  -3  5] 3  6  7       5
 *  *  1  3  -1 [-3  5  3] 6  7       5
 *  *  1  3  -1  -3 [5  3  6] 7       6
 *  *  1  3  -1  -3  5 [3  6  7]      7
 *  *   //**注意
 *  *         //1.滑动窗口的大小 要维持在【i-k+1，i】之间
 *  *         //2.验证dqueue的队首元素(最大值)dqueue.peek（）<=i-k;是否在窗口内
 */
public class F1 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
         //声明一个双端队列（用其维护一个单调队列）
        // 内部存储的都是索引 用来判断最大值是否在窗口内
        int res[]=new int[nums.length-k+1];//维护窗口最大值的数组
        LinkedList<Integer> deque =new LinkedList<>();//双端队列 用其中的单调队列
        for (int i=0;i<nums.length;i++){
            //判断deque中的元素和该num[i]的关系

            while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.pollLast(); //deque中只存储大的数就可以 while循环 用来删除deque中的小值
            }
            deque.addLast(i);//新来的元素都放队尾  通过过滤条件保持单调

            //判断最大值索引是否在窗口内
            if (deque.peek()<i-k+1){
                deque.pollFirst(); //不在窗口内  则删除  该最大值的索引无效
            }
            if (i-k+1>=0){
                res[i-k+1]=nums[deque.peek()];
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
