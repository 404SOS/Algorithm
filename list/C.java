package com.aojia.practice.list;

import com.sun.org.apache.bcel.internal.generic.FADD;

import java.util.List;

/**
 * @author QiTian
 * @date 2022/3/12
 * @Description 第142题.环形链表II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 思路： 快慢指针第一次相遇代表链表存在环
 * 环形入口位置：快慢指针二次相遇的位置
 */
public class C {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) { //第一次相遇
                ListNode index1 = head;  //初始化快指针的索引位置
                ListNode index2 = fast;
                while (index1 != index2) { //跳出循环为二次相遇
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;//返回二次相遇的节点
            }
        }
        return null;
    }
}
//题解分析过程：
//设head 到 环入口位置为 a，环长为b；    快指针走的距离为f，慢指针为s；
// fast 走的步数是slow步数的 2倍，即 f =2s；（解析： fast 每轮走 2 步）
//fast 比 slow多走了 n个环的长度，即 f = s + nb；
// 解析： 双指针都走过 a 步，然后在环内绕圈直到重合，重合时 fast 比 slow 多走 环的长度整数倍 ）；
//因此可得：s=nb； 慢指针走的距离是n倍的环的长度
//求环入口位置，那么设置走的步数为： k=a+nb；
// 都用慢指针来走的话：因为慢指针在第一次相遇时，已经走了nb，所以还需要再走a步必定到达入口处，
//所以在第一次相遇后，虚拟一个index1指针从head节点一轮一步走，slow指针一轮一步走，
//相遇之时，两节点重合，一定代表走了a步，到达了环形入口节点。

