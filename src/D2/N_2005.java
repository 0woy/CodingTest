package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
크기가 N인 파스칼의 삼각형을 만들어야 한다.
파스칼의 삼각형이란 아래와 같은 규칙을 따른다.

1. 첫 번째 줄은 항상 숫자 1이다.
2. 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성된다.

[제약 사항]
파스칼의 삼각형의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)
[입력]
1
4

[출력]
#1
1
1 1
1 2 1
1 3 3 1


4 =  4+3+2+1 = 10
4(5)/2
 */
public class N_2005 {
    public static int[][] makeArr(int[][] pascal, int n){
        for(int i=1;i<n;i++){
            for(int j=0;j<pascal[i].length;j++){
                if(j==0 || j== pascal[i].length-1){
                    pascal[i][j] = 1;
                }
                else{
                    pascal[i][j] = pascal[i-1][j-1]+pascal[i-1][j];
                }
            }
        }

        return  pascal;
    }

    public static StringBuilder printArr(int[][] arr, StringBuilder sb){
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for(int tc = 1;tc<=testcase;tc++) {
            sb.append("#"+tc+"\n");
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][];

            // init array
            for (int i = 1; i <= n; i++) {
                arr[i - 1] = new int[i];
            }
            arr[0][0] = 1;
            arr = makeArr(arr, n);
            sb = printArr(arr, sb);
        }
        System.out.println(sb);
    }
}
