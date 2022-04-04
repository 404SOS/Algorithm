package com.aojia.practice.stackAndQueue;

import java.util.Stack;

/**
 * @author QiTian
 * @date 2022/4/2
 * @Description 232. 用栈实现队列
 * 两个栈实现先入先出队列。
 * 队列应当支持一般队列支持的所有操作 （push、pop、peek、empty）：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 */
public class MyQueue {
    // 用两个栈的后进先出颠倒进出的顺序模拟queue的先进先出
    Stack<Integer> stack1=null; //stack1的push模拟queue的入队列
    Stack<Integer> stack2=null;  //stack2 的pop模拟的是queue的出队列
    public MyQueue() { //初始化两个栈
     stack1 =new Stack();
     stack2 =new Stack();
    }
    public void push(int x) {
        stack1.push(x);
    }
    public int pop(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){ //只要stack1有元素 就都存入stack2
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){ //只要stack1有元素 就都存入stack2
                stack2.push(stack1.pop());
            }
        }
      return stack2.peek();
    }

    public boolean empty() {
       return stack1.isEmpty()&&stack2.isEmpty();
    }

    public static void main(String[] args) {
        //输入：
        //["MyQueue", "push", "push", "peek", "pop", "empty"]
        //[[], [1], [2], [], [], []]
        //输出：
        //  [null, null, null, 1, 1, false]
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
       int peek= myQueue.peek(); // return 1
        System.out.println(peek);
       int pop= myQueue.pop(); // return 1, queue is [2]
        System.out.println(pop);
        boolean flag=myQueue.empty(); // return false
        System.out.println(flag);

    }
}
