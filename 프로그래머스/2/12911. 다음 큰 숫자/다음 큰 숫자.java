class Solution {
    public int solution(int n) {
        int answer = 3;         
        long binary = Integer.bitCount(n); // n의 2진수
        
        while(binary != Integer.bitCount(++n)){}
        return n;
    }
}