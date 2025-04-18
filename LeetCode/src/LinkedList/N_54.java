package LinkedList;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

matrix = [[1,2,3],
          [4,5,6],
          [7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
 */
public class N_54 {
    private static int [] direction = new int[]{0,1};
    private static List<Integer> res;
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        res = new ArrayList<>();
        sprialOrder(matrix);
        for(int n : res){
            System.out.print(n+" ");
        }
    }
    public static void sprialOrder(int[][] matrix){
        if(matrix ==null|| matrix.length==0){ return;}
        int row =matrix.length;
        int col = matrix[0].length;

        int left =0;
        int right = col-1;
        int top =0;
        int bottom = row-1;

        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

    }
/*
    public static void dfs(int [][] matrix, int row, int col){
        if(row>=matrix.length || row<0||col>=matrix[0].length||col<0){
            return ;
        }
        if(matrix[row][col]==-101){
            return;
        }

        res.add(matrix[row][col]);
        matrix[row][col] = -101;    // visited

       dfs(matrix, row+direction[0],col+direction[1]);
       return;
    }

 */
}
