package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class N_1316 {
    /** Solve with Set
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count =0;

        int n = Integer.parseInt(br.readLine());
        while (n -- > 0){
            Set<Character> present  = new HashSet<>();
            String cur =br.readLine();
            int i=0,j=i;
            while(i<cur.length()-1){
                char flag = cur.charAt(i);
                if(present.contains(flag)){
                    break;
                }

                for(j=i+1;j<cur.length();j++){
                    if(flag!=cur.charAt(j)){
                        present.add(flag);
                        break;
                    }
                }
                if(j==cur.length()){
                    j-=1;
                    break;
                }else{
                    i=j;
                }
            }
            if(present.contains(cur.charAt(j))){
                continue;
            }
            count++;
        }
        System.out.println(count);

    }
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        int count =0;
        while (N -- > 0){
            if (check(br.readLine())){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean check(String cur){
        boolean [] alpha = new boolean[26];
        int prev = -1;
        for(int i=0;i<cur.length();i++){
            int now = cur.charAt(i)-'a';
            if(prev!=now){
                if(alpha[now]){
                    return false;
                }else{
                    alpha[now]=true;
                    prev = now;
                }
            }else{
                continue;
            }
        }
        return true;
    }
}
/**
 * import java.io.*;
 *
 * import javax.swing.undo.StateEdit;
 *
 * public class N_1316 {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *
 *         int N = Integer.parseInt(br.readLine());
 *
 *         int count = 0;
 *         for (int i = 0; i < N; i++) {
 *             String str = br.readLine();
 *             if (check(str) == true)
 *                 count++;
 *         }
 *         System.out.println(count);
 *     }
 *
 *     static boolean check(String str) {
 *         boolean check[] = new boolean[26];
 *         int prev = 0;
 *         for (int i = 0; i < str.length(); i++) {
 *             int now = str.charAt(i);
 *
 *             if (prev != now) {
 *                 if (check[now - 'a'] == false) {
 *                     check[now - 'a'] = true;
 *                     prev = now;
 *                 } else {
 *                     return false;
 *                 }
 *             }
 *
 *         }
 *         return true;
 *
 *     }
 *
 * }
 *
 */
