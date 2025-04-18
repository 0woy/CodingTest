package Arrays_Hashing;
/*
You are given a 0-indexed integer array costs
where costs[i] is the cost of hiring the ith worker.

You are also given two integers k and candidates.
We want to hire exactly k workers according to the following rules:

- You will run k sessions and hire exactly one worker in each session.
- In each hiring session, choose the worker with the lowest cost
from either the first candidates workers or the last candidates workers.
Break the tie by the smallest index.

For example,
if costs = [3,2,7,7,1,2] and candidates = 2,
then in the first hiring session,
1. we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
2. In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker
but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
3. If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them.
Break the tie by the smallest index.

A worker can only be chosen once.
Return the total cost to hire exactly k workers.
 */

import java.util.*;

public class N_2462 {
    /*
    public static void addList(int k,LinkedList<Integer>list, LinkedList<Integer> cost,int candidates, boolean isFirst){
        for(int i=list.size();list.size()<candidates;i++){
            int idx =i+k;
            if(!isFirst){
                idx = cost.size()-1-i-k;
            }
           if(list.isEmpty())
               list.add(cost.get(idx));
           else{
               if (list.getFirst() >= cost.get(idx)) {
                   list.addFirst(cost.get(idx));
               } else {
                   list.addLast(cost.get(idx));
               }
           }
        }
        Collections.sort(list);
    }
    public static void printList(LinkedList<Integer> list){
        for(int i: list){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] costs = new int[]{28,35,21,13,21,72,35,52,74,92,25,65,77,1,73,32,43,68,8,100,84,80,14,88,42,53,98,69,64,40,60,23,99,83,5,21,76,34};
        int k=32;
        int candidates =12;
        long sum = 0;

        if(candidates*2>=costs.length) {
            Arrays.sort(costs);
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < costs.length; i++)
                list.add(costs[i]);

            while (k > 0) {
                sum += list.getFirst();
                list.removeFirst();
                k--;
            }
            System.out.println(sum);
        }
        else{
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < costs.length; i++)
                list.add(costs[i]);
            LinkedList<Integer> front = new LinkedList<>();
            LinkedList<Integer> end = new LinkedList<>();
            int fcount =0;
            int ecount =0;
            while ( k>0) {
                if(front.size()<candidates)
                    addList(fcount,front, list, candidates, true);
                if(end.size()<candidates);
                    addList(ecount,end, list, candidates, false);

                int addVal = 0;
                if (front.getFirst() <= end.getFirst()) {
                    addVal = front.removeFirst();
                    fcount++;
                } else {
                    addVal = end.removeFirst();
                    ecount++;
                }
                sum += addVal;
                k--;
            }
            System.out.println(sum);
        }
    }
    */
    /*
    public static Deque<Integer> que;
    public static LinkedList<Integer> addQue(LinkedList<Integer>tmp, int candidates, boolean isFront){
        while(tmp.size()<candidates && !que.isEmpty() ){
            if(isFront){
                tmp.add(que.removeFirst());
            }
            else{
                tmp.add(que.removeLast());
            }
        }
        Collections.sort(tmp);
        return tmp;
    }
    public static void main(String[] args) {
        int [] costs = new int[]{50,80,34,9,86,20,67,94,65,82,40,79,74,92,84,37,19,16,85,20,79,25,89,55,67,84,3,79,38,16,44,2,54,58};
        int k = 7;
        int candidates = 12;
        boolean isCombine = ((costs.length-candidates*2) < k)?true:false;

        que = new ArrayDeque<>();
        for(int i : costs){
            que.addLast(i);
        }

        LinkedList<Integer> front = new LinkedList<>();
        LinkedList<Integer> end = new LinkedList<>();
        long sum =0;
        while(k>0){
            if(que.size() > candidates || !isCombine){
                if(front.size()<candidates)
                    front = addQue(front, candidates, true);
                if(end.size()<candidates)
                    end = addQue(end,candidates, false);

                int addVal = 0;
                if(front.getFirst()<end.getFirst()){
                    addVal = front.removeFirst();
                }
                else addVal=end.removeFirst();
                sum+=addVal;
            }
            else{
                int [] remain = new int[que.size()+front.size()+end.size()];
                int idx =0;
                while(!que.isEmpty()){
                    remain[idx++] = que.removeFirst();
                }
                while(!front.isEmpty()){
                    remain[idx++] = front.removeFirst();
                }
                while (!end.isEmpty()){
                    remain[idx++] = end.removeFirst();
                }
                Arrays.sort(remain);
                for(int val : remain){
                    sum+=val;
                    if(--k <= 0) break;
                }
            }
            k--;
        }

        System.out.println(sum);


    }
     /*
    public static Queue<Integer> que;
    public static void main(String[] args) {
        int [] costs = new int[]{17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 4;
        for(int val:costs)
            que.add(val);
    }

      */
    public static void main(String[] args) {
        int [] costs = new int[]{50,80,34,9,86,20,67,94,65,82,40,79,74,92,84,37,19,16,85,20,79,25,89,55,67,84,3,79,38,16,44,2,54,58};
        int k = 20;
        int candidates = 12;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int front =0;
        int end =costs.length-1;
        long sum =0;
        while(k-- >0){
            while(pq1.size()<candidates && front<=end){
                pq1.offer(costs[front++]);
            }
            while (pq2.size()<candidates&&front<=end){
                pq2.offer(costs[end--]);
            }
            int v1 = pq1.size()>0?pq1.peek():Integer.MAX_VALUE;
            int v2 = pq2.size()>0?pq2.peek():Integer.MAX_VALUE;
            if(v1<=v2){
                sum+=v1;
                pq1.poll();
            }
            else{
                sum+=v2;
                pq2.poll();
            }
        }
        System.out.println(sum);
    }
}
