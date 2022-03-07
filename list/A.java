package com.aojia.practice.list;

/**
 * @author QiTian
 * @date 2022/3/7
 * @Description 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 思路：使用虚拟头节点
 */

public class A {
    public ListNode removeElements(ListNode head, int val) {
        //时间复杂度：O(n)，其中 n是链表的长度。需要遍历链表一次。
        //空间复杂度：O(1)。
        ListNode dummyHead =new ListNode(0);
        dummyHead.next =head;//虚拟头节的指针指向真实节点
        ListNode cur =dummyHead;//设置一个当前节点
       while (cur.next!=null){
           if (cur.next.val==val){
               cur.next=cur.next.next;//跳过要删除的元素
           }else {
               cur=cur.next;//当前指针后移
           }

       }
       return dummyHead.next;
    }
}
