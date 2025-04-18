import java.io.*;
import java.util.*;

public class N_6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int limit =1000001;
        boolean[] isNotPrime =new boolean[limit];
        List<Integer> primes = new ArrayList<>();
        isNotPrime[4]=true;
        for(int i=3;i<limit;i+=2){
            if(!isNotPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j < limit; j += i) {
                    if (!isNotPrime[j]) {
                        isNotPrime[j] = true;
                    }
                }
            }
        }

        Set<Integer> primeSet = new HashSet<>(primes);

        while(true){
            boolean isGold = false;
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                bw.flush();
                bw.close();
                return;
            }
            for(int small: primes){
                if(small > num/2){
                    break;
                }
                if(primeSet.contains(num-small)){
                    bw.write(num+" = "+small+" + "+(num-small));
                    bw.write("\n");
                    isGold=true;
                    break;
                }
            }
            if(!isGold){
                bw.write("Goldbach's conjecture is wrong.\n");
            }

        }
    }
}
