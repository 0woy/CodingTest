package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_2309 {
    // 시간: O(N²), 공간: O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] dwarf = new int[9];
        int total = 0;
        for(int i=0;i<9;i++){
            dwarf[i] = Integer.parseInt(br.readLine());
            total += dwarf[i];
        }
        int goal = total-100; // 오차를 구함
        Arrays.sort(dwarf);
        for(int i=0;i<dwarf.length;i++){
            for(int j=i+1;j< dwarf.length;j++){
                if(dwarf[i]+dwarf[j]==goal){    // 오차 값이 같은 경우 예외 난쟁이
                   for(int k=0;k<dwarf.length;k++){
                       if(k!=i && k!=j){
                           sb.append(dwarf[k]+"\n");
                       }
                   }
                    System.out.println(sb);
                    return;
                }
            }
        }

    }
}
