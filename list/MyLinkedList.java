package com.aojia.practice.list;

/**
 * @author QiTian
 * @date 2022/3/7
 * @Description 707. 设计链表
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，
 * 则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
public class MyLinkedList {
    int size;
    ListNode dummyNode;//虚拟头节点
    public MyLinkedList() {
        dummyNode=new ListNode(0);
        size=0;
    }
    // 获取到第index个节点数值，如果index是非法数值直接返回-1， 注意index是从0开始的 是第一个真实节点的索引
    public int get(int index) {
        if (index>=size||index<0){
            return -1;
        }
        ListNode cur =dummyNode;
       while (index-->=0){
           cur=cur.next;//死循环 移动索引下标指针
       }
//       for(int i=0;i<=index;i++){
//           cur=cur.next;
//       }
       return cur.val; //跳出循环找到索引对应的值
    }

    //头部插入
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    //尾部插入
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    // 在第index个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果index大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index>size)return;
        if (index<0){
            index=0;
        }
        size++;
            //找到插入节点的前驱节点
            ListNode pre =dummyNode;
            for (int i=0;i<index;i++){
                pre=pre.next;
            }
            ListNode newNode =new ListNode(val);//新节点

        //头插 尾插 通用代码 头插时 pre==dummyNode
        //尾插时 pre = 最后一个节点。
            newNode.next=pre.next;
            pre.next=newNode;

        }


    public void deleteAtIndex(int index) {
        if (index<0||index>=size)return;
        ListNode pre=dummyNode;
        for (int i=0;i<index;i++){//找到当前索引节点的前一个节点
            pre=pre.next;
        }
        pre.next=pre.next.next;
        size--;
    }
}
