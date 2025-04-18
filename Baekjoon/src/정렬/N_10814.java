import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_10814 {
    static class Person{
        int age;
        String name;
        public Person(int age, String name){
            this.age=age;
            this.name =name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Person> people = new ArrayList<>();
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name= st.nextToken();
            people.add(new Person(age,name));
        }
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age-o2.age;
            }
        });
        for(Person p : people){
            System.out.println(p.age+" "+p.name);
        }


    }
}
