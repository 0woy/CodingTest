package Recursion;

import java.util.ArrayList;
import java.util.List;

public class N_784 {
    public static List<String> list;
    public static char toLowerUpper(char ch){
        if(Character.isLowerCase(ch)){
            return Character.toUpperCase(ch);
        }
        else{
            return Character.toLowerCase(ch);
        }
    }
    public static void findCase(char[] letter, String str, int idx){
        StringBuilder current = new StringBuilder(str);
        if(idx == letter.length){
            list.add(str);
            return;
        }
        for(int i=idx;i<letter.length;i++){
             char cur = letter[i];
            if(Character.isAlphabetic(cur)){
                current.append(cur);
                findCase(letter,current.toString(),i+1);
                char reverse = toLowerUpper(cur);
                current.deleteCharAt(i).append(reverse);
            }
            else{
                current.append(cur);
            }
        }
        list.add(current.toString());
    }
    public static List<String> letterCasePermutation(String s) {
        list = new ArrayList<>();
        findCase(s.toCharArray(), "",0);
        System.out.println(list.toString());
        return list;
    }
    public static void main(String[] args) {
        String s ="asdv";
        letterCasePermutation(s);
    }
}
