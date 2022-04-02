package com.aojia.practice.array;

/**
 * @author QiTian
 * @date 2022/3/5
 * @Description  leetCode27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并「原地」修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 */
public class B {
    public  static int removeElement1(int[] nums, int val) {
        //1.暴力破解版 时间复杂度O(n^2)
        int size=nums.length;
        for (int i=0; i<size;i++){
            if (nums[i]==val){ //当发现要移除的元素时，将删除元素后的元素向前移动
             for (int j=i+1; j<size;j++){
                 nums[j-1]=nums[j];
             }
             i--;//后边元素前移 所以i也前移 重新比较
             size--;//移除元素后 数组大小也要对应减小
            }
        }
        return  size;
    }

    public  static int removeElement(int[] nums, int val) {
        //2.双指针版 快慢指针（时间复杂度O(n))
        int slowIndex=0;
        int len=nums.length;
        for (int fastIndex=slowIndex;fastIndex<len;fastIndex++){
            if (nums[fastIndex]!=val){//不相等的元素就进行 将右指针的位置覆盖给左指针的位置 位索引移动
                nums[slowIndex++]=nums[fastIndex];//slowIndex索引对应的就是移除元素后的nums数组
            }
        }
        return slowIndex;//最后数组的空间大小
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums,val));
    }
}
