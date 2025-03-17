package LinkedList;

import java.util.*;

public class N_139 {
    /** Time Limit Exceeded
    static Map<Character, List<String>> map;
    static boolean flag;
    public static void recur(String s, int idx){
        if(idx == s.length()) {
            flag = true;
            return;
        }
        char key =s.charAt(idx);
        if(map.containsKey(key)){
            for(String word : map.get(key)){
                if(idx+word.length() > s.length()){
                    continue;
                }
                if(word.equals(s.substring(idx,idx+word.length()))){
                    recur(s, idx+word.length());
                }
            }
        }
        return;
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        map= new HashMap<>();
        for (String word : wordDict) {
            char key =word.charAt(0);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(word);
            map.put(key, list);
        }
        flag= false;
        recur(s, 0);
        System.out.println(flag);
        return flag;
    }*/
    /** Time Limit Exceeded 2
    static Set<String> set;
    static Map<Character, List<String>> map;
    static boolean flag;
    public static void recur(String s){
        if(s.length() == 0) {
            flag = true;
            return;
        }
        char key = s.charAt(0);
        if(!map.containsKey(key)){set.add(s); return;}
        for (String word: map.get(key)) {

            if(word.length() > s.length()){ set.add(s); continue;}
            else if(word.equals(s)){flag=true; return;}
            if(set.contains(s)) {
                continue;
            }
            if (word.equals(s.substring(0, word.length()))){
                recur(s.substring(word.length(), s.length()));
            }
            if(flag){return;}
        }

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean [] alphabet = new boolean[26];

        map = new HashMap<>();
        for (String word : wordDict) {
            for (int i = 0; i < word.length(); i++) {
                alphabet[word.charAt(i) - 'a'] = true;
            }
            char key = word.charAt(0);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(word);
            map.put(key,list);
        }
        for (char c: s.toCharArray()) {
            if (!alphabet[c-'a']) {return false;}
        }
        set = new HashSet<>();
        flag=false;
        recur(s);
        System.out.println(flag);
        return flag;

    }
     */
    /** DP
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean []dp = new boolean[s.length()+1];
        dp[0] = true;
        int max_len = 0;
        for(String word : wordDict) {
            max_len = Math.max(word.length(), max_len);
        }

        for(int i=1;i<=s.length();i++){
            for(int j =i-1;j>=Math.max(i-max_len-1, 0);j--){
                String check = s.substring(j,i);
                if(dp[j]&&wordDict.contains(check)){
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(dp[s.length()]);
        return dp[s.length()];
    }
     */

    static int maxlen;
    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        maxlen=0;
        for(String word: wordDict) {
            maxlen = Math.max(maxlen, word.length());
        }

        return dfs(s, map, wordSet);

    }
    public static boolean dfs(String s, Map<String, Boolean> memo, Set<String> wordSet) {
        if(memo.containsKey(s)) return memo.get(s);
        if(wordSet.contains(s)) return true;

        for(int i=1;i<s.length();i++) {
            String prefix = s.substring(0,i);
            if(prefix.length()>maxlen){
                break;
            }
            if(wordSet.contains(prefix) && dfs(s.substring(i), memo, wordSet)) {
                memo.put(prefix, true);
                return true;
            }
        }
        memo.put(s,false);
        return false;
    }
    public static void main(String[] args) {
        String s = "catsandogcat";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("an");
        wordDict.add("dog");
        wordBreak(s, wordDict);
    }
}
