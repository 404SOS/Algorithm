package com.aojia.practice.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QiTian
 * @date 2022/4/26
 * @Description 145. 二叉树的后序遍历 递归法
 */
public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res =new ArrayList<>();
        postOrder(root,res);
        return res;
    }
    public  void  postOrder(TreeNode root,List<Integer> res){
            if (root==null) return;
            postOrder(root.left,res);
            postOrder(root.right,res);
            res.add(root.val);
    }
}
