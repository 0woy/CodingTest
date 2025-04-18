package Array;

public class 행렬의곱셈 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];
            int col = arr2[0].length;
            int idx =0;
            for(int i=0;i<arr1.length;i++){
                for(int k=0;k<col;k++){
                    int sum =0;
                    for(int j=0;j<arr2.length;j++){
                        sum = sum+arr1[i][j]*arr2[j][k];
                    }
                    answer[i][k] = sum;
                }
            }
            return answer;
        }

    }
}
