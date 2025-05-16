package DFS_BFS;

public class N_104 {
    static int max;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepth(TreeNode root) {
        max = 0;
        dfs(root, 0);
        return max;
    }

    public static void dfs(TreeNode cur, int depth) {
        if (cur == null) {
            if (depth > max) max = depth;
            return;
        }

        dfs(cur.left, depth + 1);
        dfs(cur.right, depth + 1);
    }
}
