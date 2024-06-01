package chapter17.ex.pack17_6;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMethod {
    public static void main(String[] args) {
        //1. 예외 처리 기능 미포함 메서드
        Queue<Integer> queue1 = new LinkedList<Integer>();
//        System.out.println(queue1.element()); // NoSuchElementException
        //1-1. add(E item)
        queue1.add(3);
        queue1.add(4);
        queue1.add(5);
        //1-2. element() //가장 상위에 있는 원솟값 리턴.
        System.out.println(queue1.element());
        //1-3. E remove() //가장 상위에 있는 원솟값 꺼내기
        System.out.println(queue1.remove());
        System.out.println(queue1.remove());
        System.out.println(queue1.remove());
//        System.out.println(queue1.remove()); // NoSuchElementException
        System.out.println("---구분선---");

        //2. 예외 처리 기능 포함 메서드
        Queue<Integer> queue2 = new LinkedList<>();
        System.out.println(queue1.peek());
        //2-1. offer(E item)
        queue2.offer(3);
        queue2.offer(4);
        queue2.offer(5);
        //2-2. E peek(); //가장 상위에 있는 원솟값 리턴
        System.out.println(queue2.peek());
        //2-3. E poll(); //가장 상위에 있는 원솟값 꺼내기
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());


    }
}
