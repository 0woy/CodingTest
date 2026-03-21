import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=1;i<phone_book.length;i++){
            String prev = phone_book[i-1];
            String cur =  phone_book[i];
            if(cur.startsWith(prev)) return false;
        }
        return true;
    }
}

/**
한 번호가 다른 번호의 접주어인 경우가 있는지 확인
119 119552~ , 97674
N = 백만, nlogn??
정렬 후, prev, cur해서 cur이 startWith prev인 경우 return false

*/