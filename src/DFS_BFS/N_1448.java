package DFS_BFS;

public class N_1448 {
    public static class TreeNode {
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
    public static void isGood(TreeNode current, int max){
        if(current == null) return;
        if(current.val>=max){
            count++;
            max = current.val;
        }
        if(current.left!=null){
            isGood(current.left, max);
        }
        if(current.right!=null){
            isGood(current.right, max);
        }
    }
    public  static int goodNodes(TreeNode root) {
        count=0;
        isGood(root, root.val);
        System.out.println(count);
        return  count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(3, new TreeNode(4),new TreeNode(2)),
                null);
        goodNodes(root);
    }
}
