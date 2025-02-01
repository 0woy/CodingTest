import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1074 {
    static int r,c;
    public static int recur(int row, int col, int len, int val){
        if(len == 1){
            int plus  =0;
            if(r>row){
                plus++;
            }
            if(c>col){
                plus++;
            }
            return val+plus;
        }

        int div = len/2;
        int mul = (int) Math.pow(div, 2);
        if(r<row+div && c<col+div){
            return recur(row, col, div,val);
        }else if(r < row+div && c >= col+div){
            return recur(row, col+div, div, val+mul);
        }else if(r>=row+div && c < col+div){
            return recur(row+div, col, div,val + mul*2);
        }else{
            return recur(row+div, col+div,div, val +mul*3);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int res =recur(0,0,(int)Math.pow(2,n),0);

        System.out.println(res);


    }
}
