class Solution {
    private static final char[] VOWELS = {'A','E','I','O','U'};
    private int count = 0;
    private int answer = 0;

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    private void dfs(String cur, String target) {
        if (cur.equals(target)) {
            answer = count;
            return;
        }
        if (cur.length() == 5) return;

        for (char c : VOWELS) {
            count++;
            dfs(cur + c, target);
            if (answer != 0) return;
        }
    }
}
