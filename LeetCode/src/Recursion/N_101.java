package Recursion;
/*
Given the root of a binary tree,
check whether it is a mirror of itself (i.e., symmetric around its center).


 */

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

public class N_101 {
    /** LinkedList Not Solve
    public static boolean isSymmentric(TreeNode root){
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            int queSize = list.size();
            while(queSize-- >0){
                TreeNode curNode = list.removeFirst();
                if(curNode==null){
                    list.add(null);
                }
                if(curNode.left == null && curNode.right==null) {
                    continue;
                }

                if(curNode.left!=null){
                    list.add(curNode.left);
                }
                else{
                    list.add(null);
                }

                if(curNode.right!=null){
                    list.add(curNode.right);
                }
                else{
                    list.add(null);
                }
            }

            // isSymmentric
            for(int i=0;i<list.size()/2;i++){
                TreeNode left = list.get(i);
                TreeNode right =list.get(list.size()-i-1);
                if(left==null && right==null) continue;
                if((left==null && right!=null) || (left !=null && right ==null)||left.val!=right.val)
                    return false;
            }
        }

        return true;
    }
     */
    public static boolean recur(TreeNode leftNode, TreeNode rightNode){
        if(leftNode==null && rightNode==null){
            return true;
        }
        if(leftNode==null || rightNode==null){
            return  false;
        }
        if(leftNode.val!=rightNode.val){
            return false;
        }
        return recur(leftNode.left, rightNode.right) && recur(leftNode.right, rightNode.left);
    }
    public static boolean isSymmetric(TreeNode root) {
        return recur(root.left, root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(8);
        System.out.println(isSymmetric(root));

    }

}
