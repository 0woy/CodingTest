package DFS_BFS;

import com.sun.source.tree.Tree;

public class N_230 {
     static class TreeNode {
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
     public static int count;
     public static int res;
     public static void dfs(TreeNode cur){
         if(cur.left!=null){
             dfs(cur.left);
         }
         count--;
         if(count == 0){
             res = cur.val;
             return;
         }
         if(cur.right!=null){   dfs(cur.right); }
     }
     public static int kthSmallest(TreeNode root, int k) {
         count =k;
         res =0;
         dfs(root);
         return res;
     }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(1 ,null, new TreeNode(2)),
                new TreeNode(4));
        System.out.println(kthSmallest(root, 2));
    }
}
