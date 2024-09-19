package Recursion;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class N_427 {
    public static Node recur(int[][] grid, int row, int col, int len){
        int flag  = grid[row][col];
        boolean val = flag==1?true:false;
        if(len == 1){
            return new Node(val,true);
        }
        for(int r=row;r<row+len;r++){
            for(int c = col;c<col+len;c++){
                int cur = grid[r][c];
                if(flag!=cur){
                    int half = len/2;
                   Node tl = recur (grid, row, col, half);
                   Node tr = recur (grid, row, col+half, half);
                   Node bl = recur (grid, row+half, col, half);
                   Node br = recur (grid, row+half, col+half, half);
                   return new Node(true, false, tl,tr,bl,br);
                }
            }
        }
        return new Node(val, true);
    }
    public static Node construct(int[][] grid) {
             Node result = recur(grid, 0,0,grid.length);
             return result;
    }

    public static void main(String[] args) {
        construct(new int[][]{
                {0,1},
                {1,0}}
        );
    }
}
