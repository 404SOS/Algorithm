package com.aojia.practice.stackAndQueue;

import java.util.Stack;

/**
 * @author QiTian
 * @date 2022/4/6
 * @Description  20. 有效的括号
 * 输入：s = "(]"
 * 输出：false
 * 输入：s = "{[]}"   输出：true
 * 输入：s = "()[]{}"  输出：true
 */
public class A {
    public static boolean isValid(String s) {
      Stack<Character> stack=new Stack<>();
      //括号匹配分情况考虑
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                stack.push(')');
            }else if (s.charAt(i)=='['){
                stack.push(']');
            }else if (s.charAt(i)=='{'){
                stack.push('}');
            }//元素没有遍历完 栈已经空了则代表右括号没有相应的左括号进行匹配
            //或者当栈中元素 与右括号不符合时 则代表匹配无效 都返回false
            else if (stack.isEmpty()||stack.peek()!=s.charAt(i)){
                return false;
            }else{
                stack.pop();//走该else 则代表左括号都已经存完对应的右括号了
                          // 通过stack进行右括号匹配成功 进行弹出 匹配下一个右括号
            }
        }
        //此时我们已经遍历完了字符串，如果栈不为空，说明有相应的左括号没有右括号来匹配，所以return false，
        // 否则就return true  stack恰好为空 则代表匹配成功
          return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s="{[)}";
        System.out.println(isValid(s));
    }
}
