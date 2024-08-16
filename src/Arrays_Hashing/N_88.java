package Arrays_Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] res = new int[n+m];
        int idx =0;
        int i=0,j=0;
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                res[idx++] = nums1[i++];
            }
            else{
                res[idx++] = nums2[j++];
            }
        }
        while(i<m){
            res[idx++] = nums1[i++];
        }
        while(j<n){
            res[idx++] = nums2[j++];
        }
        idx=0;
        for(int v: res){
            nums1[idx++]=v;
        }

    }
    public static void main(String[] args) {
        merge(new int[]{4,0,0,0,0,0},1,new int[]{1,2,3,5,6},5);
    }
}
