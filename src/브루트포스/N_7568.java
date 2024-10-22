import java.io.*;
import java.util.StringTokenizer;

public class N_7568 {
    /** Previous Solve
    static int[][] person;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        person = new int[test_case][2];
        rank = new int[test_case];

        StringTokenizer st;
        for (int i = 0; i < test_case; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < test_case; i++) {
            for (int j = i + 1; j < test_case; j++) {
                if (person[i][0] < person[j][0] &&
                        person[i][1] < person[j][1])
                    rank[i]++;
                else if (person[i][0] > person[j][0] &&
                        person[i][1] > person[j][1])
                    rank[j]++;
            }
        }
        for (int i = 0; i < rank.length; i++) {
            rank[i] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : rank) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
     */
    static class Person{
        int kg, cm;
        public Person(int kg, int cm){
            this.kg=kg;
            this.cm=cm;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] p = new Person[n];
        StringTokenizer st;
        int idx =0;
        while(n>0){
            st =new StringTokenizer(br.readLine());
            p[idx++] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            n--;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<p.length;i++){
            Person cur = p[i];
            int count =0;
            for(int j=0;j<p.length;j++){
                if(cur.kg<p[j].kg&&cur.cm<p[j].cm){
                    count++;
                }
            }
            bw.write(count+1+" ");
        }
        bw.flush();
        bw.close();

    }
}
