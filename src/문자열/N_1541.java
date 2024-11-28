import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class N_1541 {
    static char [] exp;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        exp = str.toCharArray();
        int n=0;
        int total =0;
        boolean isMinus = false;
        for(int i=0;i<exp.length;){
            char c = exp[i];
            int [] res = calc(i);

            if(isMinus){
                res[0]*=-1;
                isMinus=false;
            }
            if(res[1]<exp.length){
                // 다음 식은 빼기를 해조야댐
                isMinus = true;
            }
            total+=res[0];
            i = res[1];
        }
        System.out.println(total);

    }
    public static int[] calc(int sIdx){
        int n =0;
        int total = 0;
        int i=0;
        for(i=sIdx;i<exp.length;i++){
            char c = exp[i];
            if(Character.isDigit(c)){
                n = n*10+(c-'0');
            }else{
                if(c == '-'){
                    total+=n;
                    break;
                }
                else{
                    total+=n;
                    n=0;
                }
            }
        }
        if(i==exp.length){
            total+=n;
        }
        return new int[]{total,i+1};
    }
}
