package Arrays_Hashing;

import java.util.*;

public class N_406 {
    public static int[][] reconstructQueue(int[][] people) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                else{
                    return o1[0]-o2[0];
                }
            }
        });
        int [][] result = new int [people.length][];
        for(int i=0;i<people.length;i++){
            int[] person =people[i];
            int moreMe = person[1];
            int myHeight = person[0];
            // moreMe 만큼의 빈공간이 존재해야해
            int count =0;
            int idx =0;
            while(count<moreMe){
                if(result[idx] == null || result[idx][0] == myHeight){
                    count++;
                }
                idx++;
            }
            while(result[idx]!=null){
                idx++;
            }
            result [idx] = person;

        }
        return result;
    }
    public static void main(String[] args) {
        int [][] person = new int[][]{
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };
        reconstructQueue(person);
    }
}
