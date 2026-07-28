class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int [] counts = new int [26];

        for(int i=0;i<n/2;i++){
            counts[s.charAt(i)-'a']++;
        }

        StringBuilder lHalf = new StringBuilder();
        for(int i=0;i<26;i++){
            while(counts[i]>0){
                lHalf.append((char)('a'+i));
                counts[i]--;
            }            
        }
        StringBuilder res = new StringBuilder(lHalf);
        if(n%2==1){
            res.append(s.charAt(n/2));
        }
        res.append(lHalf.reverse());

        return res.toString();
    }
}
