package BackTracking;

import javax.print.DocFlavor;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class N_77 {
    /** First Try: accept
    private  static List<List<Integer>> result;
    public static void combinaiton(int n, int k, int next, List<Integer> comb){
        for(int i=next;i<=n;i++){
            comb.add(i);
            if(comb.size()==k){
                result.add(new LinkedList<>(comb));
                comb.remove(comb.size()-1);
            }
            else{
                combinaiton(n,k,i+1, comb);
                comb.remove(comb.size()-1);
            }
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        result= new LinkedList<>();
        if(k==1){
            for(int i=1;i<=n;i++){
                result.add(Collections.singletonList(i));
            }
            return result;
        }
        if(n==k){
            result.add(new LinkedList<>());
            for(int i=1;i<=n;i++){
                result.get(0).add(i);
            }
            return result;
        }
        for(int i=1;i<=n;i++){
            List<Integer> comb = new LinkedList<>();
            comb.add(i);
            combinaiton(n,k,i+1,comb);
            comb.remove(comb.size()-1);
        }
        return result;
    }
     */
    private static List<List<Integer>> result;
    public static void combination(int start, int n, int k, List<Integer> comb){
        if(comb.size() == k){
            result.add(new LinkedList<>(comb));
            return;
        }
        for(int i=start;i<=n;i++){
            comb.add(i);
            combination(i+1,n,k,comb);
            comb.remove(comb.size()-1);
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        result = new LinkedList<>();
        combination(1, n,k,new LinkedList<Integer>());
        return result;
    }
    public static void main(String[] args) {
        combine(2,1);

    }
}
