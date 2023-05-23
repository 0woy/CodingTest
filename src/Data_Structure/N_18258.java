/*
N_18258 큐2
- 처음 풀이했을 때 System.out 으로 출력했으나 시간 초과 오류가 남.
- 명령이 입력될 때마다 출력하라는 말이 없으므로 BufferedWriter를 활용해 한 번에 출력하도록 구성
- 시간초과 에러 해결
 */
package Data_Structure;

import java.io.*;
import java.util.StringTokenizer;

class Queue {
    private int front, rear, size;
    private int[] data;

    public Queue(int size) {
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.data = new int[size];
    }

    public void push(int value) {
        this.size += 1;
        this.data[rear++] = value;
    }

    public int getSize() {
        return this.size;
    }

    public int getFront() {
        if (isEmpty() == 1) return -1;
        else return this.data[this.front];
    }

    public int getBack() {
        if (isEmpty() == 1) return -1;
        else return this.data[this.rear - 1];
    }

    public int isEmpty() {
        if (front == rear) return 1;
        else return 0;
    }

    public int pop() {
        if (isEmpty() == 1) {  // 스택이 비어있는 경우
            return -1;
        } else {
            this.size -= 1;
            return this.data[front++];
        }
    }


}

public class N_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue queue = new Queue(n);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    int data = Integer.parseInt(st.nextToken());
                    queue.push(data);
                    break;
                case "pop":
                    bw.write(queue.pop() + "\n");
                    break;
                case "front":
                    bw.write(queue.getFront() + "\n");
                    break;
                case "back":
                    bw.write(queue.getBack() + "\n");
                    break;
                case "size":
                    bw.write(queue.getSize() + "\n");
                    break;
                case "empty":
                    bw.write(queue.isEmpty() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

