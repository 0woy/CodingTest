package BackTracking;
import java.util.*;

public class N_39 {
    /** First Try
        private static List<List<Integer>> list;
        private static List<Integer> newList;
        private static Set<List<Integer>> set;
        public static void backtrack(int[] candidates, int target, int total, int start){
            for(int i=start;i<candidates.length;i++){
                int cur =candidates[i];
                if(total == 0){
                    newList  = new LinkedList<>();
                }

                total +=cur;
                if(total == target){
                    newList.add(cur);
                    List<Integer> save = new LinkedList<>(newList);
                    list.add(save);
                    newList.remove(newList.size()-1);
                    return;

                }
                else if(total> target){
                    newList.remove(newList.size()-1);
                    return;
                }
                else{
                    newList.add(cur);
                    backtrack(candidates, target, total, i);
                }
            }

        }
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            list = new LinkedList<>();
            if(target<candidates[0]){ return list;}
            backtrack(candidates, target,0,0);
            return list;
        }
     */
    private static List<List<Integer>> result;
        public static void combination(int[] candidates, int target,int start, List<Integer> comb){
            if(target == 0){
                result.add(new ArrayList<>(comb));
                return;
            }
            for(int i=start;i<candidates.length;i++){
                int cur = candidates[i];
                if(target-cur==1 || target-cur<0){
                    continue;
                }
                comb.add(cur);
                combination(candidates, target-cur,i, comb);
                comb.remove(comb.size()-1);
            }
        }
        public  static List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();
            if(target==1){ return result;}
            combination(candidates, target, 0,new ArrayList<>());
            System.out.println(result.toString());
            return result;
        }
        public static void main(String[] args) {
            int [] candidates = new int[]{2,3,5};
            int target = 8;
            combinationSum(candidates, target);
        }
}
