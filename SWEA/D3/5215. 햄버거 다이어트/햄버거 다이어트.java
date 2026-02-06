import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Hamburger {
        int taste;
        int kal;

        public Hamburger(int taste, int kal) {
            this.taste = taste;
            this.kal = kal;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Hamburger hamburger = (Hamburger) o;
            return taste == hamburger.taste && kal == hamburger.kal;
        }

        @Override
        public int hashCode() {
            return Objects.hash(taste, kal);
        }
    }

    static StringTokenizer st;
    static BufferedReader br;
    static List<Hamburger> list;
    static int max;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            max = 0;
            list = new ArrayList<>();
            initList(n);
            maksSubSet(limit, 0, 0, 0);
            sb.append(max + "\n");
        }
        System.out.println(sb);
    }

    static void maksSubSet(int limit, int sum, int cur, int taste) {
        if (limit < sum) {
            return;
        }
        if(cur == list.size()) {
            max = Math.max(max, taste);
            return;
        }

        Hamburger ham = list.get(cur);
        maksSubSet(limit, sum + ham.kal, cur + 1, taste + ham.taste);    // 선택
        maksSubSet(limit, sum, cur + 1, taste);  // 비선택
    }

    static void initList(int n) throws Exception {
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list.add(new Hamburger(d, k));
        }
        list.sort((a, b) -> {
            if (a.kal == b.kal) {
                return Integer.compare(a.taste, b.taste);
            }
            return Integer.compare(a.kal, b.kal);
        });
    }
}