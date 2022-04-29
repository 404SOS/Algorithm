package com.aojia.practice.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author QiTian
 * @date 2022/4/29
 * @Description 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 输入：root = [   3,
 *              9,      20,
 *         null,null, 15,7
 *             ]
 * 输出：[[3],[9,20],[15,7]]
 * 思路：先中后序遍历是采用递归（或者迭 代 不想看）的思想 隐式的维护一个 栈（后进先出 深度搜索dfs） 来实现
 *       而层序遍历则是按层来进行遍历 采用的是队列（先进先出 广度搜索bfs）的思想
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            res.add(ans);
        }
        return res;
    }
}
