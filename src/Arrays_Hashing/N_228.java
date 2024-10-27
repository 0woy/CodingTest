package Arrays_Hashing;

import java.util.ArrayList;
import java.util.List;

public class N_228 {
    /** FirstTrt: 6ms
    public static void addValue(int start, int next, List<String>  result, int[] nums){
        if(start != next-1){
            result.add(nums[start]+"->"+nums[next-1]);
        }
        else{
            result.add(String.valueOf(nums[start]));
        }
    }
    public static List<String> summaryRanges(int[] nums) {
        int start = 0;
        int next =1;
        List<String> result = new ArrayList<>();
        for(;next<nums.length;next++){
            if(nums[next-1] != nums[next]-1){
                addValue(start,next,result,nums);
                start=next;
            }
        }
        if(start!=next){
            addValue(start,next,result,nums);
        }
        return result;
    }
     */
    /**
    public  static  List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            int left = i;
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (left != i) {
                sb.append("->");
                sb.append(nums[i]);
            }
            result.add(sb.toString());
        }
        return result;
    }
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> list =new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int start = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i-1]+1!= nums[i]){
                sb.setLength(0);
                sb.append(start);
                if(start!=nums[i-1]){
                    sb.append("->" + nums[i-1]);
                }
                start =nums[i];
                list.add(new String(sb));
            }
        }

        if(start == nums[nums.length-1]){
            list.add(String.valueOf(start));
        }
        else{
            list.add(start+"->"+nums[nums.length-1]);
        }
        System.out.println(list.toString());
        return list;
    }
    public static void main(String[] args) {
        summaryRanges(new int[]{0,1,2,4,5,7});
    }
}
