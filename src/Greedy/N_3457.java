package Greedy;

import java.util.Arrays;

public class N_3457 {
    /** Wrong Ans
    public static long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        long total =0;
        int idx = 1;
        int len = pizzas.length;
        for(int i=1;i<=len/4;i++){
            total+=pizzas[len-idx];
            if(i%2!=0){
                idx+=2;
            }else{
                idx++;
            }
        }
        System.out.println(total);
        return total;
    }
    */
    public static long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int days = pizzas.length/4;
        long total = 0;
        int idx = pizzas.length-1;
        for(int day=1;day<=days;day+=2){
            total+=pizzas[idx--];
        }
        idx--;
        for(int day=2;day<=days;day+=2){
            total+=pizzas[idx];
            idx-=2;
        }
        System.out.println(total);
        return total;
    }
    public static void main(String[] args) {
        int[] pizzas= new int[]{5,2,2,4,3,3,1,3,2,5,4,2};
        maxWeight(pizzas);
    }
}
