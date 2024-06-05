package Stack;

import java.util.*;

/** 문제 설명
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.*

 * Implement the MinStack class:
    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.
    You must implement a solution with O(1) time complexity for each function.
 */
public class N_155 {
    static class Node{
        private int curMin;
        private int val;

        public Node(int curMin, int val){
            this.val=val;
            this.curMin=curMin;
        }
    }

    /** Wrong access
    static class MinStack{
        private Deque<Integer> dq = new ArrayDeque<>();
        private int top;
        public MinStack() {
            dq = new ArrayDeque<>();
            top = -1;
        }

        public void push(int val) {
            if (dq.isEmpty() || dq.peekLast() > val) {
                dq.addLast(val);
            } else {
                dq.addFirst(val);
            }
            top++;
        }

        public void pop() {
            dq.removeFirst();
        }

        public int top() {
            return dq.peekFirst();

        }

        public int getMin() {
            return dq.removeLast();
        }
    }
     */
    static class MinStack {
        private LinkedList<Node> list;
        public MinStack() {
            list =new LinkedList<>();
        }

        public void push(int val) {
            int minimum;
          if(list.isEmpty()){
              minimum = val;
          }
          else{
              int curMin =  list.getLast().curMin;
              minimum = (val>curMin)?curMin:val;
          }
          list.add(new Node(minimum, val));
        }

        public void pop() {
            list.removeLast();
        }
        public int top() {
         return list.getLast().val;
        }

        public int getMin() {
            return list.getLast().curMin;
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println( stack.getMin());
        stack.pop();
        System.out.println( stack.top());
        System.out.println( stack.getMin());

    }
}
