import java.io.*;
import java.util.*;

public class N_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 단어의 개수
        String[] str = new String[N];

        for (int i = 0; i < N; i++)
            str[i] = br.readLine();

        // str 배열을 HashSet으로 변환
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(str));

        String[] resArray = hashSet.toArray(new String[0]); // 중복이 제거된 후 배열 변환

        // 문자열 길이순 정렬
        Arrays.sort(resArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 문자열 길이가 같다면 오름차순
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resArray.length; i++)
            sb.append(resArray[i]).append('\n');

        System.out.println(sb);

        br.close();
    }
}
