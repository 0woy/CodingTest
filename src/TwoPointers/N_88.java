package TwoPointers;

import java.util.Arrays;

public class N_88 {
    /** O(nlogn)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int v: nums2){
            nums1[m++]=v;
        }
        Arrays.sort(nums1);
    }
     */
    /** Time: O(n+m),  Space:O(n+m)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m+n];
        int i=0, j=0, idx=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                tmp[idx++] = nums1[i++];
            }else{
                tmp[idx++] = nums2[j++];
            }
        }
        while(i<m){
            tmp[idx++] = nums1[i++];
        }
        while(j<n){
            tmp[idx++] = nums1[j++];
        }
        idx =0;
        for(int v: tmp){
            nums1[idx++]=v;
        }
    }
*/
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = m-1;
      int j = n-1;
      int idx =m+n-1;

      while(i>=0 && j>=0) {
          nums1[idx--] =
                  nums1[i] > nums2[j]
                  ? nums1[i--]
                  : nums2[j--];
      }
      while(j>=0){
          nums1[idx--] = nums2[j--];
      }
    }
    public static void main(String[] args) {
        int [] nums1 =new int[]{1};
        int [] nums2 =new int[]{2,3,5};
        int m=1;
        int n=0;

        merge(nums1,m,null,n);
    }
}
