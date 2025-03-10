package Greedy;

import java.util.*;

public class N_1657 {
    /**
     * Time: O(N), Space: O(N) ft. Map
     * public static boolean closeStrings(String word1, String word2) {
     * if (word1.length() != word2.length()) {
     * return false;
     * }
     * <p>
     * int[] alpha = new int[26];
     * int[] beta = new int[26];
     * <p>
     * for (char c : word1.toCharArray()) {
     * alpha[c - 'a']++;
     * }
     * Map<Integer, Integer> sort= new HashMap<>();
     * for (int i = 0; i < alpha.length; i++) {
     * if(alpha[i]!=0)
     * sort.put(alpha[i], sort.getOrDefault(alpha[i], 0) + 1);
     * }
     * <p>
     * for (char c : word2.toCharArray()) {
     * if (alpha[c - 'a'] == 0) {
     * return false;
     * }
     * beta[c - 'a']++;
     * }
     * <p>
     * for(int i=0;i<beta.length;i++){
     * if(beta[i]==0) continue;
     * int count = sort.getOrDefault(beta[i], 0);
     * if(count == 0){return false;}
     * else{
     * sort.put(beta[i], count-1);
     * }
     * }
     * return true;
     * }
     */

    // Space: O(1)
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray()) freq1[c - 'a']++;
        for (char c : word2.toCharArray()) freq2[c - 'a']++;

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args) {
        String word1 = "a";
        String word2 = "b";
        System.out.println(closeStrings(word1, word2));

    }
}
