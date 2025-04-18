package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N_6 {
/*
    public static void main(String[] args) {

        String s = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
        char [] charArray = s.toCharArray();
        int numRows = 3;
        StringBuilder sb=new StringBuilder();
        if(numRows<=1) return;
        else if(numRows<=2){
            for(int i=0;i<s.length();i+=2){
                sb.append(charArray[i]);
            }
            for(int i=1;i<s.length();i+=2){
                sb.append(charArray[i]);
            }
            System.out.println(sb);
            return;
        }


        int midLen = numRows-2;
        int fLen = s.length()/numRows;
        int mLen = s.length()%numRows/midLen+1;

        LinkedList<Character>[] list = new LinkedList[fLen*mLen];

        for(int idx =0;idx<list.length;idx++)
            list[idx]=new LinkedList<>();

        for(int i=0,idx=0;i<charArray.length;){
            if(list[idx].size()<numRows){
                list[idx].add(charArray[i++]);
            }
            else{
               idx++;
               for(int m=0;m<midLen && i<charArray.length;m++){
                   list[idx].add(charArray[i++]);
               }
               idx++;
            }
        }
        for(int cur=0;cur<numRows;cur++){
          int idx =0;
            if(cur==0 || cur == numRows-1){
                while(idx<list.length) {
                    if(cur >= list[idx].size()) break;
                    sb.append(list[idx].get(cur));
                    idx += 2;
                }
            }
            else {
                while(idx < list.length) {
                    if (idx % 2 != 0) {
                        if(midLen - cur >= list[idx].size()) break;
                        sb.append(list[idx].get(midLen-cur));
                    } else {
                        if(cur > list[idx].size()) break;
                        if(cur < list[idx].size()) {
                            sb.append(list[idx].get(cur));
                        }
                    }
                    idx++;
                }
            }

        }
        System.out.println(sb);
    }

 */
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        if(numRows<=1 || numRows>=s.length()) {
            System.out.println(s);
            return;
        }
        List<Character>[] list = new ArrayList[numRows];
        for(int i=0;i<numRows;i++){
            list[i] = new ArrayList<>();
        }
        int idx =0, d =1;
        for(char c: s.toCharArray()){
            list[idx].add(c);
            if(idx ==0){
                d=1;
            }
            else if(idx == numRows-1){
                d =-1;
            }
            idx +=d;
        }
        StringBuilder sb = new StringBuilder();
        for(List<Character> row: list){
            for(char c : row){
                sb.append(c);
            }
        }
        System.out.println(sb);
        return;
    }

}
