import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1213 {
    /** My Solve ft. Map
    static Map<Character, Integer> alphabet;
    public static boolean isNotPossible(String str){
        // Not Possible
        int sort = alphabet.keySet().size();
        boolean isNotPossible = false;
        if(sort > str.length()/2 + str.length()%2){
            isNotPossible = true;
        }
        if(str.length()%2==0) {
            for (char key : alphabet.keySet()) {
                if(alphabet.get(key) %2!=0){
                    isNotPossible = true;
                    break;
                }
            }
        }else{
            int oddNum = 0;
            for (char key : alphabet.keySet()) {
                if(alphabet.get(key)%2!=0){
                    if(oddNum>=1){
                        isNotPossible=true;
                        break;
                    }
                    oddNum++;
                }
            }
        }
        return isNotPossible;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        alphabet = new HashMap<>();
        for(char c: str.toCharArray()){
            alphabet.put(c, alphabet.getOrDefault(c, 0)+1);
        }

        if(isNotPossible(str)){
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        List<Character> alpha = new ArrayList<>(alphabet.keySet());
        Collections.sort(alpha);
        char odd ='\0';
        if(str.length()%2!=0){
            for(char key: alphabet.keySet()){
                if(alphabet.get(key)%2!=0){
                    odd = key;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.setLength(str.length());
        int idx =0;
        for (char key: alpha){
            int count = alphabet.get(key);
            int i = idx;
            for(;i<count/2+idx;i++){
                sb.setCharAt(i, key);
                sb.setCharAt(sb.length()-i-1, key);
            }
            if (count%2!=0){
                sb.setCharAt(sb.length()/2, key);
            }
            idx = i;
        }
        System.out.println(sb.toString());
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String str = br.readLine();
        int [] alpha = new int[26];

        for(int i=0;i<str.length();i++){
            alpha[str.charAt(i)-'A']++;
        }

        int odd =0;
        int oddIdx =-1;
        for(int i=0;i<alpha.length;i++){
            if(alpha[i]%2!=0){
                odd++;
                oddIdx=i;
            }
        }
        if(odd>1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for(int i=0;i<alpha.length;i++){
            for(int j=0;j<alpha[i]/2;j++){
                sb.append((char)(i+'A'));
            }
        }
        sb.append(new StringBuilder(sb).reverse());
        if(oddIdx!=-1){
            sb.insert(sb.length()/2,(char)(oddIdx+'A'));
        }
        System.out.println(sb.toString());

    }
}
