package Greedy;

import java.util.*;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int min = 0;
        int max = people.length - 1;

        int count = 0;
        while (min <= max) {
            if (people[min] + people[max] <= limit) {
                min++;
            }
            max--;
            count++;
        }
        return count;
    }

}
