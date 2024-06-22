package BinarySearch;

import java.util.Arrays;

public class N_875 {
    public static int validMaxNum;
    public static int res;
    public static long eatBanana(int[] piles, int k){
        long totalHour = 0;
        int c =0;
        for(int bananas: piles){
            c = bananas%k > 0?1:0;
            totalHour =bananas/k+totalHour+c;
        }
        return totalHour;
    }
    public static void findK(int[]piles, int h, int start, int end){
        while(start<=end){
            int half = (start+end)/2;
            long totalHour = eatBanana(piles, half);
            if(totalHour > h){
                start =half+1;
            }
            else{
                res = Math.min(res,half);
                end=half-1;
            }
        }
    }
    public static void main(String[] args) {
        int [] piles =new int[]{805306368,805306368,805306368};
        int h = 1000000000;
        Arrays.sort(piles);
        validMaxNum = piles[piles.length-1];
        res = validMaxNum;

        findK(piles,h,1,validMaxNum);
        System.out.println(res);
    }
}
