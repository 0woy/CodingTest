package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N_13305 {
    /** SubTask: 58
    static class City{
        private int price;
        private int nextKm;

        public City(int nextKm){
            this.nextKm = nextKm;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<City> list = new ArrayList<>();

        st= new StringTokenizer(br.readLine());

        for(int i=0;i<n-1;i++){
            list.add(new City(Integer.parseInt(st.nextToken())));
        }
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++){
            list.get(i).setPrice(Integer.parseInt(st.nextToken()));
        }

        int min = Integer.MAX_VALUE;
        long total =0;

        for(int i=0;i<list.size();i++){
            City cur =list.get(i);

            min = Math.min(cur.price, min);
            total += cur.nextKm*min;
        }
        System.out.println(total);
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int [] distance = new int[n-1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<distance.length;i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long min = Integer.parseInt(st.nextToken());
        long total = min * distance[0];
        for(int i=1;i<distance.length;i++){
            min = Math.min(Integer.parseInt(st.nextToken()), min);

            total+=min*distance[i];
        }

        System.out.println(total);

    }

}
