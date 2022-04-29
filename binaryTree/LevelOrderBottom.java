package com.aojia.practice.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author QiTian
 * @date 2022/4/29
 * @Description 107. 二叉树的层序遍历 II
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （
 * 即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *输入：root = [  3,
 *            9,     20,
 *       null,null, 15,7]
 * 输出：[[15,7],[9,20],[3]]
 *
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();//最后的返回list
        if (root==null)return res;
        Queue<TreeNode> queue = new LinkedList();//创建一个队列
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();//记录一下队列长度
            List<Integer> ans  =new ArrayList<>();//每层都创建一个list存储该层的节点值
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            //相当于102层序遍历基础上加上这行代码就可以达到反转的输出结果
            //每次新的ans都放在0号index上 则 先前的ans会向后移动 达到反转的目的
            //这是list中add（）的妙处 遇到两次了
            res.add(0,ans);
        }
        return res;
    }

}
