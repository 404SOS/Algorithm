package com.aojia.practice.stackAndQueue;

import java.util.Stack;

/**
 * @author QiTian
 * @date 2022/4/11
 * @Description 150. 逆波兰表达式求值
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 注意 两个整数之间的除法只保留整数部分。
 * 思路：适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 */
public class E {
    public static int evalRPN(String[] tokens) {
        //逆波兰表达式 经典的用栈来解决
        //遍历逆波兰表达式 用栈存储数字，当遇到符号的时候 取出栈中的两个元素
        //与符号组合成合理的中缀表达式  最后输出栈顶元素 就是最终结果
        Stack<Integer> stack =new Stack();
        for (int i=0;i<tokens.length;i++){
            if (tokens[i].equals("+")){
                int c= stack.pop();
                int d=stack.pop();
                stack.push(c+d);
            }else if (tokens[i].equals("-")){
                int c= stack.pop();
                int d=stack.pop();
                stack.push(d-c);
            }else if (tokens[i].equals("*")){
                int c= stack.pop();
                int d=stack.pop();
                stack.push(d*c);
            }else if (tokens[i].equals("/")){
                int c= stack.pop();
                int d=stack.pop();
                stack.push(d/c);
            }else {
                //没遇到符号则将该字符转换成Int后 存入栈中
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String tokens[] =new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
