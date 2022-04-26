package com.aojia.practice.binaryTree;


import com.aojia.practice.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QiTian
 * @date 2022/4/26
 * @Description 摆烂半个月 今天开始 继续努力 开始卷起来 慢慢变强 先复习一下之前写过得堆栈
 * 然后今天先写一个二叉树得算法 开始着手毕设的第四模块
 * 144. 二叉树的前序遍历 递归法
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 */
public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        preOrder(root,res);
        return res;
    }
    //1.确定递归函数的参数和返回值
    public  void preOrder(TreeNode root, List<Integer> res){
    //2.确定终止条件
        if (root==null)return ;
    //3.确定单层递归的逻辑
        res.add(root.val);//根
        preOrder(root.left,res);//左
        preOrder(root.right,res);//右
    }
}
