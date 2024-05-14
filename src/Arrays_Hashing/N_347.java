package Arrays_Hashing;
import java.util.*;

/*
Given an integer array nums and an integer k,
return the k most frequent elements.
You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 */
public class N_347 {
    public static void main(String[] args) {
        int [] nums = new int[]{5,2,5,3,5,3,1,1,3};
        int k=2;

        Set<Integer> tmp = new HashSet<>();
        for(int n: nums){
            tmp.add(n);
        }
        int [] ans = new int [k];

        if(tmp.size() == k){
            System.out.println(tmp.toString());
            return;
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        int count =1;
        int cur = nums[0];
        for(int i=1;i<nums.length;i++){
            if(cur == nums[i]){
                count++;
                if(i!=nums.length-1)
                    continue;
            }

            if(!map.containsKey(count)){
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(cur);
            cur = nums[i];
            count=1;

        }
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.reverse(keyList);

        int i=0;
        while(k>0){
            for(int idx =0;idx<keyList.size();idx++){
                for(int num: map.get(keyList.get(idx))){
                    if(k<=0) break;
                    ans[i++] = num;
                    k--;
                }
            }
        }

        for(int res : ans)
            System.out.print(res+" ");
    }
}
