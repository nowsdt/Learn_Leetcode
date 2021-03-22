package cn.supertao.queuestack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shidt
 * @date 2021/3/22 10:48
 */
public class QueueStack {

    public static class Stack2Queue<T> {
        private final Stack<T> s1 = new Stack<>();
        private final Stack<T> s2 = new Stack<>();

        public void push(T t) {
            s1.push(t);
        }

        public T pop() {
            peek();
            return s2.pop();
        }

        public T peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    public static class Queue2Stack<T> {
        private final Queue<T> q = new LinkedList<>();
        private T topElement;

        public void push(T t) {
            q.offer(t);
            topElement = t;
        }

        public T pop() {
            int size = q.size();

            // 为了更新topElement
            while (size > 2) {
                q.offer(q.poll());
                size--;
            }


            // 更新topElement
            topElement = q.peek();
            q.offer(q.poll());

            return q.poll();
        }

        public T top() {
            return top();
        }

        public boolean isEmpty() {
            return q.isEmpty();
        }
    }
}
