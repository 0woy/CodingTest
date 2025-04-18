package LinkedList;

import com.sun.source.tree.Tree;

import java.util.*;
class TreeNode{
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
public class N_108{

    public static TreeNode rotateRight(TreeNode parent){
        TreeNode child = parent.left;
        parent.left=child.right;
        child.right = parent;

        return child;
    }

    public static TreeNode rotateLeft(TreeNode parent){
        TreeNode child = parent.right;
        parent.right=child.left;
        child.left = parent;

        return child;
    }

    public static int getHeight(TreeNode node){
        int height =0;
        if (node  == null) return 0;
         height = 1+Math.max(getHeight(node.right), getHeight(node.left));

         return  height;
    }
    public static int getBalance(TreeNode node){
        if(node == null) return 0;
        return getHeight(node.left)-getHeight(node.right);
    }
    public static TreeNode newNode(int key){
        return new TreeNode(key);
    }

    public static TreeNode insert(TreeNode node, int key){
        if(node==null) return newNode(key);

        if(node.val > key){
            node.left = insert(node.left, key);
        }
        else{
            node.right = insert(node.right, key);
        }

        int balance = getBalance(node);

        // RR 회전
        if(balance>1 && key<node.left.val ){
            return rotateRight(node);
        }

        if(balance< -1 && key > node.right.val){
            return  rotateLeft(node);
        }
        // LR 회전
        if(balance>1 && key>node.left.val){
            node.left =rotateLeft(node.left);
            return rotateRight(node);
        }
        if(balance< -1 && key < node.right.val){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

/**
 * 레벨 순회
    public static String levelOrder(TreeNode root){
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        StringBuilder sb= new StringBuilder();

        while(!que.isEmpty()){
            TreeNode tmp = que.poll();
            sb.append(tmp.val+" ");
            if(tmp.left!=null) que.offer(tmp.left);
            if(tmp.right!=null) que.offer(tmp.right);
        }
        return sb.toString();
    }
    **/
    public static void main(String[] args) {
        int [] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = null;
        for(int key : nums){
            root = insert(root, key);
        }
    }
}
