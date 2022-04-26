package com.aojia.practice.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QiTian
 * @date 2022/4/26
 * @Description 94.二叉树的中序遍历 递归法
 */
public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        inOrder(root,res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root==null) return;
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);

    }
}
