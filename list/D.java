package com.aojia.practice.list;

/**
 * @author QiTian
 * @date 2022/3/12
 * @Description 141. 环形链表
 */
public class D {
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode slow = head;//定义慢指针
        ListNode fast = head;//快指针
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow) { //第一次相遇 代表成环 返回为真
                return true;
            }
        }
        return false;//跳出循环代表快指针==null到达重点 无环
    }
}
