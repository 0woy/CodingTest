import java.io.*;
import java.util.*;

public class N_10814 {

    public static class Person {
        int age;
        String name;

        public Person() {
            age = 0;
            name = "";
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Person[] persons = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            persons[i] = new Person(age, name);
        }
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age == o2.age)
                    return 0;
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(persons[i].age + " " + persons[i].name).append('\n');

        System.out.println(sb);
    }

}
