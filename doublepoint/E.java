package com.aojia.practice.doublepoint;



/**
 * @author QiTian
 * @date 2022/4/2
 * @Description 第206题：反转链表
 */
public class E {
    public ListNode reverseList(ListNode head) {
        if (head==null)return head;
        ListNode dummyNode =new ListNode(0);
        dummyNode.next=head;
        ListNode cur =dummyNode.next.next;//2号开始
        dummyNode.next.next=null;
        ListNode next=null;
        while (cur!=null){
            next=cur.next;//存3
            cur.next=dummyNode.next;//2->1
            dummyNode.next=cur;//dummy->2
            cur=next;
        }

        return dummyNode.next;
    }
}
