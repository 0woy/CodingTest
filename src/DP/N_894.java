package DP;
/*
Given an integer n, return a list of all possible full binary trees with n nodes.
Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree.
You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 */


import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class N_894 {
    private static Map<Integer, List<TreeNode>> dp;

    public static List<TreeNode> allPossibleFBT(int n) {
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        if(n==1){
            List<TreeNode> single = new ArrayList<>();
            single.add(new TreeNode(0));
            return single;
        }
        List<TreeNode> res = new ArrayList<>();
        for(int i=1;i<n;i+=2){
            List<TreeNode> leftTree = allPossibleFBT(i);
            List<TreeNode> rightTree = allPossibleFBT(n-i-1);

            for(TreeNode left: leftTree){
                for(TreeNode right: rightTree){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        dp.put(n, res);
        return res;
    }
    public static void main(String[] args) {
        int n = 5;
        dp  = new HashMap<>();
        dp.put(0, new ArrayList<>());
        List<TreeNode> result = allPossibleFBT(n);

        for(TreeNode root: result){
            printTree(root);
            System.out.println();
        }
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
