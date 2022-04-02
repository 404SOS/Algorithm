package com.aojia.practice.doublepoint;

/**
 * @author QiTian
 * @date 2022/4/2
 * @Description 第142题.环形链表II
 */
public class F {
    public ListNode detectCycle(ListNode head) {
        ListNode fast =head;
        ListNode slow =head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){
                ListNode index1=head;
                ListNode index2=slow;
                while (index1!=index2){
                    index1=index1.next;
                    index2=index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
