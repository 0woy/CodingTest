package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class N_11478 {
    static Set<String> part;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        part = new HashSet<>();

        for(int i=1;i<=str.length();i++){
            backtracking(str, i);
        }
        System.out.println(part.size());
    }
    public static void backtracking(String str, int len){
        for(int i=0;i<=str.length()-len;i++){
            part.add(str.substring(i, i+len));
        }
    }
}
