package TwoPointers;

public class N_27 {
    /** Wrong
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        ArrayDeque<Integer> idx = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                idx.add(i);
                count++;
            }else{
                if(!idx.isEmpty()){
                    nums[idx.removeFirst()] = nums[i];
                    idx.add(i);
                }
            }
        }

        nums = Arrays.copyOf(nums, nums.length-count);
        for(int v: nums){
            System.out.println(v+" ");
        }
        return count;
    }*/
    /** Wrong
    public static int removeElement(int[] nums, int val) {
       int count =0;
       int start =0, end = nums.length-1;
       if(start == end){
           if(nums[start]!=val){
               count = 1;
           }else{
               count =0;
           }
           nums = Arrays.copyOf(nums, count);
           return count;

       }
       while(start<end){
           while(nums[start]!=val){start++;}
           while(nums[end] == val){end--;}
            if(start<end){
                // switch
                int tmp = nums[start];
                nums[start]= nums[end];
                nums[end]= tmp;
            }
       }
       return start;
    }
     */
    public static int removeElement(int[] nums, int val) {
        int idx =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int val = 1;
        removeElement(nums,val);
    }
}
