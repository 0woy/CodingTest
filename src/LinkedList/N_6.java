package LinkedList;

import java.util.LinkedList;

public class N_6 {

    public static void main(String[] args) {
        String s = "AB";
        char [] charArray = s.toCharArray();
        int numRows = 1;
        int midLen = numRows-2;
        int fLen = s.length()/numRows;
        int mLen = (midLen>0)?s.length()%numRows/midLen+1:0;

        int len  = (fLen+mLen>0)?fLen+mLen:1;
        LinkedList<Character>[] list = new LinkedList[len];
        StringBuilder sb=new StringBuilder();

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
                    if(cur > list[idx].size()) break;
                    if (idx % 2 != 0) {
                        if(midLen - cur >= list[idx].size()) break;
                        sb.append(list[idx].get(midLen-cur));
                    } else {
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


}
