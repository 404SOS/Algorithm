package com.aojia.practice.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author QiTian
 * @date 2022/4/4
 * @Description 225. 用队列实现栈
 * 用两个队列实现一个后入先出（LIFO）的栈，
 * 并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 */
public class MyStack {
    //新进入元素存入queue2  通过与queue1队列交换 来该边元素存入的顺序
    //最后queue1 的输出 则为栈的出队操作 重点是push方法
    Queue<Integer> queue1 = null;//queue1作栈的弹出操作

    Queue<Integer> queue2 = null;//queue2作为备份的交换操作

    public MyStack() {
        queue1 = new LinkedList();
        queue2 = new LinkedList();
    }
    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        Queue<Integer> tmp=queue1; //**通过交换 保证后进入的元素存储在先进入元素的前面
        queue1=queue2;
        queue2=tmp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        //输入：
        //["MyStack", "push", "push", "top", "pop", "empty"]
        //[[], [1], [2], [], [], []]
        //输出：
        //[null, null, null, 2, 2, false]
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty());// 返回 False
    }
}
