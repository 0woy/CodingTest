import java.util.*;
class Solution { 
    static int res;
    static int lv;
    public int solution(String word) {  
        res= 0;
        dfs(new StringBuilder(), word);
        return res;
    }
    public void dfs(StringBuilder cur, String word){
        if(cur.toString().equals(word)){
            res = lv;
            return;
        }
        if(cur.length()>=5) return;
        for(char ch: "AEIOU".toCharArray()){
            lv++;
            dfs(cur.append(ch), word);
            cur.deleteCharAt(cur.length()-1);
            if(res!=0) return;
        }
        return;
    }
    
}