import java.io.*;
import java.util.*;

public class N_24060 {
    /** Previous Solve
    static int key;
    static int count = 0;
    static boolean check = false;

    public static void store(int[] tmp, int current, int x) {
        count++;
        tmp[current] = x;
        if (count == key) {
            key = x;
            check = true;
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        int[] tmp = new int[arr.length];
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j])
                store(tmp, t++, arr[i++]);
            else
                store(tmp, t++, arr[j++]);
        }
        while (i <= mid) {
            store(tmp, t++, arr[i++]);
        }
        while (j <= right) {
            store(tmp, t++, arr[j++]);
        }
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(arr, left, mid);
            merge_sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        key = Integer.parseInt(st.nextToken());
        int[] num = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(num, 0, N - 1);
        if (check)
            System.out.println(key);
        else
            System.out.println(-1);

    }*/
    public static int count;
    public static int k;
    public static int[] tmp;
    public static void merge_sort(int start, int end, int[] arr) {
        if (start < end) {
            int half = (start + end) / 2;
            merge_sort(start, half, arr);
            merge_sort(half + 1, end, arr);
            int i=start;
            int j=half+1;
            int idx = 0;
            while(i<=half && j<=end){
                if(arr[i]<arr[j]){
                    tmp[idx]=arr[i];
                    i++;
                }else{
                    tmp[idx] = arr[j];
                    j++;
                }
                idx++;
            }

            while(i<=half){
                tmp[idx++]=arr[i++];
            }
            while (j<=end) {
                tmp[idx++] = arr[j++];
            }
            i = start;
            idx = 0;
            while(i<=end){
                arr[i]=tmp[idx];
                if(++count==k){
                    System.out.println(tmp[idx]);
                    System.exit(0);
                }
                i++;
                idx++;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count =0;
        int [] arr = new int[len];
        tmp = new int[len];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<len;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0,arr.length-1, arr);

        if(count>0){
            System.out.println(-1);
            return;
        }
    }
}
