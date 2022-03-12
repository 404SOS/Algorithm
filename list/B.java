package com.aojia.practice.list;

/**
 * @author QiTian
 * @date 2022/3/12
 * @Description 第206题：反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class B {
    public ListNode reverseList(ListNode head) {
        if (head==null)return head;
        ListNode dummyNode =new ListNode(0);//定义哑节点
        dummyNode.next=head;//确定虚拟节点和头节点之间的关系
        ListNode cur = dummyNode.next.next;//将2号元素设置为当前元素
        dummyNode.next.next=null;//将第1号元素 脱钩
        ListNode next =null;//初始化下一个节点  用于指针移动
        while (cur!=null){
            next=cur.next;//存3号元素
            cur.next=dummyNode.next;//2号元素连接1号   先后顺序很重要
            dummyNode.next=cur;//虚拟节点连接2号元素
            cur=next;//当前索引后移
        }
        return dummyNode.next;
    }
}
