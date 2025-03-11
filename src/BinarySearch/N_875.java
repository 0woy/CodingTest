package BinarySearch;

import java.util.Arrays;

public class N_875 {
    /** Previous Solve
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
    }*/
    public static int minEatingSpeed(int[] piles, int h) {
        int start =1;
        int end = piles[0];
        for(int i: piles){
            end = i>end?i:end;
        }
        if(piles.length==h){
            return end;
        }
        int res = end;
        while (start <= end){
            int eat = start+(end-start)/2;
            long hour=0;
            for(int n :piles){
                hour +=n/eat;
                if(n%eat > 0){hour++;}
            }
            if (hour > h){
                start = eat+1;
            }else{
                res = Math.min(res,eat);
                end = eat-1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int [] piles =new int[]{805306368,805306368,805306368};
        int h =1000000000 ;
        System.out.println(minEatingSpeed(piles,h));
    }
}
