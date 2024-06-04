package chapter17;

import java.util.LinkedList;
import java.util.Queue;

public class Q10 {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();

        q.offer("땡큐");
        q.offer("베리");
        q.offer("감사");
        q.poll();               // 감사 베리
        q.offer("방가");      // 방가 감사 베리
        System.out.println(q.peek());   //베리
        System.out.println(q.poll());   //베리
        System.out.println(q.poll());   //감사
        System.out.println(q.poll());   //방가

    }
}
